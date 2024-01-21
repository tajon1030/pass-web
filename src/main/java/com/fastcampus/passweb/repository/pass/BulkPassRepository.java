package com.fastcampus.passweb.repository.pass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BulkPassRepository extends JpaRepository<BulkPass, Integer> {

    @Query(value = """
            select b from BulkPass b
            order by b.startedAt desc
            """)
    List<BulkPass> findAllOrderByStartedAtDesc();
}
