package com.apiwiz.TaskManagement.service;

import com.apiwiz.TaskManagement.model.AuthenticationToken;
import com.apiwiz.TaskManagement.model.User;
import com.apiwiz.TaskManagement.model.dto.AuthInput;
import com.apiwiz.TaskManagement.model.dto.SignInInput;
import com.apiwiz.TaskManagement.model.dto.SignUpOutput;
import com.apiwiz.TaskManagement.repository.IUserRepo;
import com.apiwiz.TaskManagement.service.utility.emailUtility.EmailHandler;
import com.apiwiz.TaskManagement.service.utility.hashingUtility.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserRepo iUserRepo;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private TaskService postService;

    public SignUpOutput signUpBlogsUser(User user) {

        boolean signUpStatus = true;
        String signUpStatusMessage = null;

        String newEmail = user.getUserEmail();

        if(newEmail == null)
        {
            signUpStatusMessage = "Invalid User email!!!";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }

        //check if this user email already exists ??
        User exitingUser = iUserRepo.findFirstByUserEmail(newEmail);
        if(exitingUser != null) {
            signUpStatusMessage = "Email already registered!!!";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }

        //hash the password: encrypt the password

        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(user.getUserPassword());

            //save  the user with the new encrypted password
            user.setUserPassword(encryptedPassword);
            iUserRepo.save(user);

            return new SignUpOutput(signUpStatus, "User registered successfully!!!");
        } catch (Exception e) {
            signUpStatusMessage = "Internal error occurred during User Sign Up!!!";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }
    }

    public String sigInBlogsUser(SignInInput signInInput) {

        String signInStatusMessage = null;

        String signInEmail = signInInput.getEmail();

        if(signInEmail == null)
        {
            signInStatusMessage = "Invalid User email!!!";
            return signInStatusMessage;
        }

        //check if this user email already exists ??
        User existingUser = iUserRepo.findFirstByUserEmail(signInEmail);

        if(existingUser == null)
        {
            signInStatusMessage = "Email not registered!!!";
            return signInStatusMessage;
        }

        //match passwords :

        //hash the password: encrypt the password

        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(signInInput.getPassword());

            if(existingUser.getUserPassword().equals(encryptedPassword)) {
                //session should be created since password matched and user id is valid
                AuthenticationToken authToken = new AuthenticationToken(existingUser);
                authenticationService.saveAuthToken(authToken);

//                now I Want to send OTP on Email --> Email Integration
                EmailHandler.sendEMail("mskhanm1819@gmail.com", "Blogs Sign-In Testing!!!", authToken.getTokenValue());;

                return "Token Sent to your Email!!!";

            }else {
                signInStatusMessage = "Invalid credentials!!!";
                return signInStatusMessage;
            }

        } catch (Exception e) {
            signInStatusMessage = "Internal error occurred during sign in";
            return signInStatusMessage;
        }

    }

    public void blogsUserSignOut(AuthInput authInput) {
        String newEmail = authInput.getEmail();
        User existingUser = iUserRepo.findFirstByUserEmail(newEmail);

        AuthenticationToken authToken = authenticationService.findFirstByUser(existingUser);

        authenticationService.remove(authToken);
    }

}
