package com.example.logindemo.controller;

import com.example.logindemo.common.Response;
import com.example.logindemo.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 24797
 * @version 1.0
 * @description 1. print "hello world" with auth 2. a dashboard
 * @date 2025/12/13 22:35
 */


@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    private GeneralService generalService;

    @GetMapping("/hello")
    public Response helloWorld(Authentication authentication) {
        System.out.println("Auth = " + authentication);
        return generalService.hello();
    }
}
