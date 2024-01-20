package com.fastcampus.passweb.service.pass;

import com.fastcampus.passweb.repository.pass.Pass;
import com.fastcampus.passweb.repository.pass.PassRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PassService {
    private final PassRepository passRepository;

    public List<Pass> getPasses(String userId) {
        return passRepository.findByUserId(userId);
    }
}
