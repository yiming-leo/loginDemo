package com.example.logindemo.controller;

import com.example.logindemo.common.Response;
import com.example.logindemo.dto.LoginUserDTO;
import com.example.logindemo.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 24797
 * @version 1.0
 * @description auth related api
 * @date 2025/12/13 22:34
 */

@RequestMapping("/api")
@RestController
public class AuthController {

    @Autowired
    private LoginServiceImpl loginService;

    /**
     * @param loginUserDTO request User entity
     * @return http Response, Response Class
     * @author 24797
     * @date 2025/12/14 0:43
     */
    @PostMapping("/login")
    public Response login(@RequestBody LoginUserDTO loginUserDTO) {
        return loginService.login(loginUserDTO);
    }

}
