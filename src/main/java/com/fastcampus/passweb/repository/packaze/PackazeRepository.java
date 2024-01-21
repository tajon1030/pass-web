package com.fastcampus.passweb.repository.packaze;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackazeRepository extends JpaRepository<Packaze, Integer> {
    List<Packaze> findAllByOrderByPackageName();
}
