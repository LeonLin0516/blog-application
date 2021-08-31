package com.leonplatform.Controller.Admin;

import com.leonplatform.Objects.Blog;
import com.leonplatform.Objects.User;
import com.leonplatform.Service.BlogService;
import com.leonplatform.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/admin")
public class NewPostController {

    @Autowired
    BlogService blogService;

    @Autowired
    TagService tagService;

    @GetMapping("/new-post")
    public String newPost(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("tags", tagService.listTag());
        return "admin/new-post";
    }

    @PostMapping("/new-post/post")
    public String post(Blog blog, RedirectAttributes redirectAttributes, HttpSession session) {
        blog.setViewed(0);
        blog.setCreatedTime(new Date());
        blog.setUpdatedTime(new Date());
        blog.setUser((User) session.getAttribute("user"));
        blog.setPublished(true);
        blog.setTags(tagService.listTag(blog.getTagIDs()));
        Blog b = blogService.saveBlog(blog);
        if (b == null) {
            redirectAttributes.addFlashAttribute("negativeMessage", "Failed!");
            return "redirect:/admin/new-post";
        }
        redirectAttributes.addFlashAttribute("positiveMessage", "Success!");
        return "redirect:/admin/navigate";
    }


}
