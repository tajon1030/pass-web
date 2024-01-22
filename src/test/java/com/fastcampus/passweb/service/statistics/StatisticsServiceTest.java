package com.fastcampus.passweb.service.statistics;

import com.fastcampus.passweb.repository.statistics.StatisticsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StatisticsServiceTest {

    @Mock // Mock 객체로 사용
    private StatisticsRepository statisticsRepository;

    @InjectMocks // 인스턴스를 생성하고 @Mock으로 생성된 객체를 주입
    private StatisticsService statisticsService;

    @Nested
    @DisplayName("통계데이터를 기반으로 차트만들기")
    class MakeChartData {
        final LocalDateTime to = LocalDateTime.of(2022, 9, 10, 0, 0);

        @DisplayName("통계 데이터가 있을 때")
        @Test
        void makeChartData_when_hasStatistics() {
            // given
            List<AggregatedStatistics> statisticsList = List.of(
                    new AggregatedStatistics(to.minusDays(1), 15, 10, 5),
                    new AggregatedStatistics(to, 10, 8, 2)
            );

            // when
            when(statisticsRepository.findByStatisticsAtBetweenAndGroupBy(eq(to.minusDays(10)), eq(to))).thenReturn(statisticsList);

            final ChartData chartData = statisticsService.makeChartData(to);

            // then
            verify(statisticsRepository, times(1)).findByStatisticsAtBetweenAndGroupBy(eq(to.minusDays(10)), eq(to));

            assertNotNull(chartData);
            assertEquals(new ArrayList<>(List.of("09-09", "09-10")), chartData.getLabels());
            assertEquals(new ArrayList<>(List.of(10L, 8L)), chartData.getAttendedCounts());
            assertEquals(new ArrayList<>(List.of(5L, 2L)), chartData.getCancelledCounts());

        }

        @DisplayName("통계 데이터가 없을 때")
        @Test
        void makeChartData_when_notHasStatistics() {
            // when
            when(statisticsRepository.findByStatisticsAtBetweenAndGroupBy(eq(to.minusDays(10)), eq(to))).thenReturn(Collections.emptyList());

            final ChartData chartData = statisticsService.makeChartData(to);

            // then
            verify(statisticsRepository, times(1)).findByStatisticsAtBetweenAndGroupBy(eq(to.minusDays(10)), eq(to));

            assertNotNull(chartData);
            assertTrue(chartData.getLabels().isEmpty());
            assertTrue(chartData.getAttendedCounts().isEmpty());
            assertTrue(chartData.getCancelledCounts().isEmpty());

        }
    }

    @Test
    @DisplayName("차트 데이터 만들기")
    public void makeChartData() {
        //given
        final LocalDateTime to = LocalDateTime.of(2022, 9, 10, 0, 0);

        List<AggregatedStatistics> aggregatedStatistics = List.of(
                new AggregatedStatistics(to.minusDays(1), 15, 10, 5),
                new AggregatedStatistics(to, 10, 8, 2)
        );

        //when
        when(statisticsRepository.findByStatisticsAtBetweenAndGroupBy(eq(to.minusDays(10)), eq(to))).thenReturn(aggregatedStatistics);
        final ChartData chartData = statisticsService.makeChartData(to);

        //then
        verify(statisticsRepository, times(1))
                .findByStatisticsAtBetweenAndGroupBy(eq(to.minusDays(10)), eq(to));

        assertNotNull(chartData);
        assertEquals(new ArrayList<>(List.of("09-09", "09-10")), chartData.getLabels());
        assertEquals(new ArrayList<>(List.of(10L, 8L)), chartData.getAttendedCounts());
        assertEquals(new ArrayList<>(List.of(5L, 2L)), chartData.getCancelledCounts());

    }
}