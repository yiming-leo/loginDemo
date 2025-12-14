package com.example.logindemo.service;

import com.example.logindemo.common.Response;
import com.example.logindemo.dto.LoginUserDTO;

/**
 * @author 24797
 * @version 1.0
 * @description user info's interface
 * @date 2025/12/13 23:19
 */
public interface LoginService {
    Response login(LoginUserDTO loginUserDTO);
}
