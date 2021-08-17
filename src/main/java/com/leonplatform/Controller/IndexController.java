package com.leonplatform.Controller;

import com.leonplatform.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/blog")
    public String blogPost() {
        return "blog-post";
    }

    @GetMapping("/about-me")
    public String aboutMe() {
        return "about-me";
    }

    @GetMapping("admin/navigate")
    public String adminNavigate() {
        return "admin-navigate";
    }

    @GetMapping("admin/new-post")
    public String adminPost() {
        return "admin-post";
    }
}
