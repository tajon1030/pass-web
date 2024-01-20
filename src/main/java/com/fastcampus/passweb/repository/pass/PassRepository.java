package com.fastcampus.passweb.repository.pass;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PassRepository extends JpaRepository<Pass, Integer> {

    List<Pass> findByUserId(String userId);
}
