package com.vuhien.application.service;

import com.vuhien.application.entity.User;
import com.vuhien.application.model.request.RegisterRequest;
import org.springframework.stereotype.Service;

/**
 * Created by VuHien96 on 17/08/2021 10:57
 */
@Service
public interface UserService {
    User registerUser(RegisterRequest registerRequest);
}
