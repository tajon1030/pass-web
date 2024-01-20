package com.fastcampus.passweb.controller.pass;

import com.fastcampus.passweb.service.pass.PassMapper;
import com.fastcampus.passweb.service.pass.PassService;
import com.fastcampus.passweb.service.user.UserMapper;
import com.fastcampus.passweb.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/passes")
@Slf4j
public class PassViewController {

    private final UserService userService;
    private final PassService passService;

    @GetMapping
    public String getPasses(@RequestParam("userId") String userId, Model model) {
        List<PassResponse> passResponses = PassMapper.INSTANCE.map(passService.getPasses(userId));
        UserResponse userResponse = UserMapper.INSTANCE.map(userService.getUser(userId));
        model.addAttribute("user", userResponse);
        model.addAttribute("passes", passResponses);
        return "pass/index";
    }

}
