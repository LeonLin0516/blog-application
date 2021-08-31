package com.leonplatform.Controller.Admin;

import com.leonplatform.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class NewPostController {

    @Autowired
    TagService tagService;

    @GetMapping("/new-post")
    public String newPost(Model model) {
        model.addAttribute("tags", tagService.listTag());
        return "admin/new-post";
    }


}
