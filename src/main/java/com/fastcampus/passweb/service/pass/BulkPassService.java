package com.fastcampus.passweb.service.pass;

import com.fastcampus.passweb.controller.admin.BulkPassRequest;
import com.fastcampus.passweb.repository.packaze.Packaze;
import com.fastcampus.passweb.repository.packaze.PackazeRepository;
import com.fastcampus.passweb.repository.pass.BulkPass;
import com.fastcampus.passweb.repository.pass.BulkPassRepository;
import com.fastcampus.passweb.repository.pass.BulkPassStatus;
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

    @Transactional
    public void addBulkPass(BulkPassRequest bulkPassRequest) {
        Packaze packaze = packazeRepository.findById(bulkPassRequest.getPackageSeq())
                .orElseThrow();

        BulkPass bulkPass = BulkPassMapper.INSTANCE.map(bulkPassRequest);
        bulkPass.setStatus(BulkPassStatus.READY);
        bulkPass.setCount(packaze.getCount());
        bulkPass.setEndedAt(packaze.getPeriod());

        bulkPassRepository.save(bulkPass);
    }
}
