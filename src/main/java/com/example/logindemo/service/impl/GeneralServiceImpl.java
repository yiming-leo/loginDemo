package com.example.logindemo.service.impl;

import com.example.logindemo.common.Response;
import com.example.logindemo.service.GeneralService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 24797
 * @version 1.0
 * @description TODO
 * @date 2025/12/14 17:21
 */

@Service
public class GeneralServiceImpl implements GeneralService {
    public Response hello() {
        System.out.println("hello() triggered");
        return Response.success(200, "Hello World!", new Date());
    }
}
