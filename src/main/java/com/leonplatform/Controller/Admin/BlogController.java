package com.leonplatform.Controller.Admin;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BlogController {

    @GetMapping("/navigate")
    public String blog(@PageableDefault(size = 5, sort = {"updatedTime"}) Pageable pageable,
                       Model model) {

        return "admin/navigate";
    }
}
