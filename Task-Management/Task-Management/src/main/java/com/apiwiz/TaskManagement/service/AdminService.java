package com.apiwiz.TaskManagement.service;

import com.apiwiz.TaskManagement.model.Admin;
import com.apiwiz.TaskManagement.model.AuthenticationToken;
import com.apiwiz.TaskManagement.model.enums.TokenUserType;
import com.apiwiz.TaskManagement.repository.IAdminRepo;
import com.apiwiz.TaskManagement.repository.IAuthRepo;
import com.apiwiz.TaskManagement.service.utility.hashingUtility.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private IAdminRepo adminRepo;

    @Autowired
    private IAuthRepo tokenRepo;

    //-----------------------  admin signUp -------------------
    public ResponseEntity<String> adminSignup(Admin admin) throws NoSuchAlgorithmException {

        Optional<Admin> optionalAdmin = adminRepo.findFirstByAdminEmailAddress(admin.getAdminEmail());

        if (optionalAdmin.isEmpty()) {
            String adminPassword = PasswordEncrypter.encryptPassword(admin.getAdminPassword());
            admin.setAdminPassword(adminPassword);
            adminRepo.save(admin);
            return ResponseEntity.status(HttpStatus.OK).body("admin saved successfully");
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("email already registered please try with different one");
        }
    }

    public boolean isValidAdmin(String adminEmail, String adminTokenValue){

        Optional<Admin> optionalAdmin = adminRepo.findFirstByAdminEmailAddress(adminEmail);

        if(optionalAdmin.isPresent()){
            Admin admin = optionalAdmin.get();
            String tokeValue = tokenRepo.findTokenValueByTokenUserIdAndTokenUserType(admin.getAdminId(),TokenUserType.ADMIN.name());

            return tokeValue.equals(adminTokenValue);
        }else{
            return false;
        }
    }
    public ResponseEntity<String> adminSignIn(String adminEmail, String adminPassword)  {
        Optional<Admin> optionalAdmin = adminRepo.findFirstByAdminEmailAddress(adminEmail);

        if (optionalAdmin.isPresent()) {
            Admin admin = optionalAdmin.get();
            if (tokenRepo.findToken(admin.getAdminId(), TokenUserType.ADMIN.name()) == null) {
                String encryptPassword;
                try {
                    encryptPassword = PasswordEncrypter.encryptPassword(adminPassword);
                } catch (Exception exception) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("server issue try after some time");
                }

                if (admin.getAdminPassword().equals(encryptPassword)) {
                    AuthenticationToken token = new AuthenticationToken(TokenUserType.ADMIN, admin.getAdminId());
                    tokenRepo.save(token);
                    return ResponseEntity.status(HttpStatus.OK).body("signIn with token id " + token.getTokenValue());
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credential issue");
                }
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("you have already signIn first signOut ");
            }
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please signUp first");
        }
    }

    public ResponseEntity<String> adminSignOut(String adminEmail, String tokenValue) {

        if (isValidAdmin(adminEmail,tokenValue)) {
            Admin admin = adminRepo.findFirstByAdminEmailAddress(adminEmail).get();
            Integer tokenId = tokenRepo.findToken(admin.getAdminId(),TokenUserType.ADMIN.name());
            tokenRepo.deleteById(tokenId);

            return ResponseEntity.status(HttpStatus.OK).body(" signOut done!!!!!");
        }
        else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credential issue");
        }
    }
}
