package com.fastcampus.passweb.service.pass;

import com.fastcampus.passweb.repository.packaze.PackazeRepository;
import com.fastcampus.passweb.repository.pass.BulkPass;
import com.fastcampus.passweb.repository.pass.BulkPassRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class BulkPassService {

    private final BulkPassRepository bulkPassRepository;
    private final PackazeRepository packazeRepository;

    public List<BulkPass> getAllBulkPasses() {
        return bulkPassRepository.findAllOrderByStartedAtDesc();
    }
}
