package com.fastcampus.passweb.controller.admin;

import com.fastcampus.passweb.service.statistics.StatisticsService;
import com.fastcampus.passweb.util.LocalDateTimeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminViewController {

    private final StatisticsService statisticsService;

    @GetMapping
    public String home(@RequestParam("to") String toString, Model model){
        LocalDateTime to = LocalDateTimeUtils.parseDate(toString);
        model.addAttribute("chartData",statisticsService.makeChartData(to));
        return "admin/index";
    }
}
