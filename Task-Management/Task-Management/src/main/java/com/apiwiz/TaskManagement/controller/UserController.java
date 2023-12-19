package com.apiwiz.TaskManagement.controller;

import com.apiwiz.TaskManagement.model.User;
import com.apiwiz.TaskManagement.model.dto.AuthInput;
import com.apiwiz.TaskManagement.model.dto.SignInInput;
import com.apiwiz.TaskManagement.model.dto.SignUpOutput;
import com.apiwiz.TaskManagement.service.AuthenticationService;
import com.apiwiz.TaskManagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationService authenticationService;

    //sign up particular Blogs user
    @PostMapping("blogs/user/signUp")
    public SignUpOutput signUpBlogsUser(@RequestBody @Valid User user)
    {
        return userService.signUpBlogsUser(user);
    }

    //Sign-In a particular Blogs user
    @PostMapping("blogs/user/signIn")
    public String sigInBlogsUser(@RequestBody @Valid SignInInput signInInput)
    {
        return userService.sigInBlogsUser(signInInput);
    }

    //    User -- SIGN-OUT // DELETE
    @DeleteMapping("blogs/user/signOut")
    public String blogsUserSignOut(@RequestBody @Valid AuthInput authInput) {
        boolean authenticateValid = authenticationService.authenticateUser(authInput);
        if(authenticateValid) {
            userService.blogsUserSignOut(authInput);
            return "User Signed Out Successfully!!!";
        }else {
            return "Sign out not allowed for non authenticated user.";
        }
    }
}
