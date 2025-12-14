package com.example.logindemo.service.impl;

import com.example.logindemo.common.Response;
import com.example.logindemo.dto.LoginUserDTO;
import com.example.logindemo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 24797
 * @version 1.0
 * @description a login related service with login method, including auth judge
 * @date 2025/12/13 23:41
 */

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Response login(LoginUserDTO loginUserDTO) {

        try {
            // Auth the account: release or deny
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginUserDTO.getUsername(),
                            loginUserDTO.getPassword()
                    )
            );
            // if succeed set AUTH-STATUS into Session
            SecurityContextHolder.getContext().setAuthentication(authentication);
            //System.out.println("User: " + loginUserDTO.getUsername() + " Login Success, timestamp: " + new Date());
            return Response.success(200, "Login Success", new Date());
        } catch (AuthenticationException ae) {
            //System.out.println("User: " + loginUserDTO.getUsername() + " Login Failed, timestamp: " + new Date());
            return Response.error(401, "Unauthorized", new Date());
        }
    }
}
