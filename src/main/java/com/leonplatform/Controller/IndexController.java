package com.leonplatform.Controller;

import com.leonplatform.NotFoundException;
import com.leonplatform.Service.TagService;
import com.leonplatform.ViewObjects.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

    @Autowired
    TagService tagService;

    @GetMapping("/")
    public String index(@PageableDefault(size = 5, sort = {"updatedTime"}) Pageable pageable,
                        Model model) {
        model.addAttribute("tags", tagService.listTopTags(7));
        return "index";
    }

    @GetMapping("/blog-post")
    public String blogPost() {
        return "blog-post";
    }

    @GetMapping("/about-me")
    public String aboutMe() {
        return "about-me";
    }
}
