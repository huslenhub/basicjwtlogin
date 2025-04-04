package org.example.springjwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody// 왜냐 아마도 웹 반환이 아니라서
public class AdminController {

    @GetMapping("/admin")
    public String adminP() {
        return "admin controller";
    }
}
