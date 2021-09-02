package com.leonplatform.Controller.Admin;

import com.leonplatform.Objects.Blog;
import com.leonplatform.Service.BlogService;
import com.leonplatform.Service.TagService;
import com.leonplatform.ViewObjects.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    BlogService blogService;
    @Autowired
    TagService tagService;

    @GetMapping("/navigate")
    public String blog(@PageableDefault(size = 2, sort = {"updatedTime"}) Pageable pageable,
                       BlogQuery blogQuery, Model model) {

        model.addAttribute("tags", tagService.listTag());
        model.addAttribute("page", blogService.listBlog(pageable, blogQuery));
        return "admin/navigate";
    }

    @PostMapping("/navigate/search")
    public String search(@PageableDefault(size = 5, sort = {"updatedTime"}) Pageable pageable,
                         BlogQuery blogQuery, Model model) {
        model.addAttribute("tags", tagService.listTag());
        model.addAttribute("page", blogService.listBlog(pageable, blogQuery));
        return "admin/navigate";
    }

    @GetMapping("/navigate/{id}/delete")
    public String delete(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return "redirect:/admin/navigate";
    }
}
