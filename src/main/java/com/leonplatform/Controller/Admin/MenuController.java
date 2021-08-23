package com.leonplatform.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class MenuController {

    @GetMapping("/navigate")
    public String adminNavigate() {
        return "admin/navigate";
    }

    @GetMapping("/new-post")
    public String adminPost() {
        return "admin/new-post";
    }
}
