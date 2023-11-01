package com.sravs.ecommerce.controller;

import com.sravs.ecommerce.dto.ResponseDto;
import com.sravs.ecommerce.dto.user.SignupDto;
import com.sravs.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    //Two apis

    //Sign-up
@PostMapping("/signup")
    public ResponseDto signup(@RequestBody SignupDto signupDto) {
    return userService.signup(signupDto);

}

    //Sing-in
}
