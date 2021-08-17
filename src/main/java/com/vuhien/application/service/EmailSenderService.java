package com.vuhien.application.service;

import org.springframework.stereotype.Service;

/**
 * Created by VuHien96 on 17/08/2021 12:00
 */
@Service
public interface EmailSenderService {
    void sendEmail(String to, String email);
}
