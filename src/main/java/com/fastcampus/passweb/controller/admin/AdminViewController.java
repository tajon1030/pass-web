package com.fastcampus.passweb.controller.admin;

import com.fastcampus.passweb.service.packaze.PackazeMapper;
import com.fastcampus.passweb.service.packaze.PackazeService;
import com.fastcampus.passweb.service.pass.BulkPassMapper;
import com.fastcampus.passweb.service.pass.BulkPassService;
import com.fastcampus.passweb.service.statistics.StatisticsService;
import com.fastcampus.passweb.service.user.UserGroupMappingService;
import com.fastcampus.passweb.util.LocalDateTimeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminViewController {

    private final StatisticsService statisticsService;
    private final BulkPassService bulkPassService;
    private final PackazeService packazeService;
    private final UserGroupMappingService userGroupMappingService;

    @GetMapping
    public String home(@RequestParam("to") String toString, Model model) {
        LocalDateTime to = LocalDateTimeUtils.parseDate(toString);
        model.addAttribute("chartData", statisticsService.makeChartData(to));
        return "admin/index";
    }

    @GetMapping("/bulk-pass")
    public String registerBulkPass(Model model) {
        model.addAttribute("bulkPasses", BulkPassMapper.INSTANCE.map(bulkPassService.getAllBulkPasses()));
        model.addAttribute("packages", PackazeMapper.INSTANCE.map(packazeService.getAllPackages()));
        model.addAttribute("userGroupIds", userGroupMappingService.getAllUserGroupIds());
        model.addAttribute("request", new BulkPassRequest());
        return "admin/bulk-pass";
    }

    @PostMapping("/bulk-pass")
    public String addBulkPass(BulkPassRequest request){
        bulkPassService.addBulkPass(request);
        return "redirect:/admin/bulk-pass";
    }
}
