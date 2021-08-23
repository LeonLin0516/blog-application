package com.leonplatform.Controller.Admin;

import com.leonplatform.Objects.Tag;
import com.leonplatform.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public String tags(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable,
                       Model model) {
        System.out.println(tagService.listTag(pageable));
        model.addAttribute("page", tagService.listTag(pageable));
        return "admin/tags";
    }

    @PostMapping("/tags/post")
    public String post(Tag tag) {
        Tag t = tagService.saveTag(tag);
        if (t == null) {
            System.out.println("Failed to add tag");
        }
        return "redirect:/admin/tags";
    }
}
