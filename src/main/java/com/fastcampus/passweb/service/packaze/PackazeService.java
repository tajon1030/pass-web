package com.fastcampus.passweb.service.packaze;

import com.fastcampus.passweb.repository.packaze.Packaze;
import com.fastcampus.passweb.repository.packaze.PackazeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PackazeService {

    private final PackazeRepository packazeRepository;

    public List<Packaze> getAllPackages() {
        return packazeRepository.findAllByOrderByPackageName();
    }
}
