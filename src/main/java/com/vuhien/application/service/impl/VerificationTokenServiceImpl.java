package com.vuhien.application.service.impl;

import com.vuhien.application.entity.User;
import com.vuhien.application.entity.VerificationToken;
import com.vuhien.application.exception.BadRequestException;
import com.vuhien.application.exception.NotFoundException;
import com.vuhien.application.repository.UserRepository;
import com.vuhien.application.repository.VerificationTokenRepository;
import com.vuhien.application.service.VerificationTokenService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Created by VuHien96 on 17/08/2021 11:17
 */
@Component
public class VerificationTokenServiceImpl implements VerificationTokenService {

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String createToken(User user) {
        VerificationToken verificationToken = new VerificationToken();
        String token = RandomString.make(64);
        verificationToken.setToken(token);
        verificationToken.setCreatedAt(LocalDateTime.now());
        verificationToken.setExpiresAt(LocalDateTime.now().plusMinutes(15));
        verificationToken.setUser(user);
        verificationTokenRepository.save(verificationToken);

        return token;
    }

    @Override
    public void confirmToken(String token) {
        Optional<VerificationToken> verificationToken = verificationTokenRepository.findByToken(token);
        if (verificationToken.isEmpty()){
            throw new NotFoundException("Token không tồn tại");
        }
        if (verificationToken.get().getConfirmedAt() != null){
            throw new BadRequestException("Tài khoản đã kích hoạt");
        }
        LocalDateTime expiredAt = verificationToken.get().getExpiresAt();
        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new BadRequestException("Mã đã hết hạn");
        }
        userRepository.updateEnable(verificationToken.get().getUser().getEmail());
        verificationTokenRepository.updateConfirmedAt(token, LocalDateTime.now());
    }
}
