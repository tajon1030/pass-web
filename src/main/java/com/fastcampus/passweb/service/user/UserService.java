package com.fastcampus.passweb.service.user;

import com.fastcampus.passweb.repository.user.User;
import com.fastcampus.passweb.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUser(final String userId) {
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> {
                    throw new NoSuchElementException("회원을 찾을 수 없습니다.");
                });
    }
}
