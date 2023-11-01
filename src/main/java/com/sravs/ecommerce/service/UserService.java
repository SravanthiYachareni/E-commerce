package com.sravs.ecommerce.service;

import com.sravs.ecommerce.dto.ResponseDto;
import com.sravs.ecommerce.dto.user.SignupDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public ResponseDto signup(SignupDto signupDto) {
        ResponseDto responseDto = new ResponseDto("success", "dummy");
        return responseDto;
    }
}
