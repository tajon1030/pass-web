package com.fastcampus.passweb.repository.statistics;

import com.fastcampus.passweb.service.statistics.AggregatedStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface StatisticsRepository extends JpaRepository<Statistics, Integer> {

    @Query(value = """
           SELECT new com.fastcampus.passweb.service.statistics.AggregatedStatistics(s.statisticsAt, SUM(s.allCount), SUM(s.attendedCount), SUM(s.cancelledCount))
           FROM Statistics s
           WHERE s.statisticsAt BETWEEN :from AND :to
           GROUP BY s.statisticsAt
            """)
    List<AggregatedStatistics> findByStatisticsAtBetweenAndGroupBy(@Param("from") LocalDateTime from, @Param("to") LocalDateTime to);

}
