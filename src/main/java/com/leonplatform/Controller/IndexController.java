package com.leonplatform.Controller;

import com.leonplatform.NotFoundException;
import com.leonplatform.Objects.Blog;
import com.leonplatform.Service.BlogService;
import com.leonplatform.Service.TagService;
import com.leonplatform.ViewObjects.BlogArchives;
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
    BlogService blogService;
    @Autowired
    TagService tagService;

    @GetMapping("/")
    public String index(@PageableDefault(size = 5, sort = {"updatedTime"}) Pageable pageable,
                        Model model) {
        model.addAttribute("page", blogService.listBlog(pageable));
        model.addAttribute("tags", tagService.listTopTags(7));
        model.addAttribute("archives", new BlogArchives(blogService.listBlog()));
        return "index";
    }

    @GetMapping("/blog-post/{id}")
    public String blogPost(@PathVariable Long id, Model model) {
        Blog b = blogService.getBlog(id);
        if (b == null) {
            throw new NotFoundException("Blog Doesn't Exist!");
        }
        model.addAttribute("blog", b);
        return "blog-post";
    }

    @GetMapping("/about-me")
    public String aboutMe() {
        return "about-me";
    }
}
