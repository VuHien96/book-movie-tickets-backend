package com.vuhien.application.service;

import com.vuhien.application.entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by VuHien96 on 17/08/2021 11:17
 */
@Service
public interface VerificationTokenService {
    String createToken(User user);
    void confirmToken(String token);
}
