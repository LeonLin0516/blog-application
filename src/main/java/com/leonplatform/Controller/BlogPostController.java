package com.leonplatform.Controller;

import com.leonplatform.Objects.Blog;
import com.leonplatform.Objects.Comment;
import com.leonplatform.Service.BlogService;
import com.leonplatform.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BlogPostController {

    @Autowired
    BlogService blogService;

    @Autowired
    CommentService commentService;

    @GetMapping("/blog-post/{id}")
    public String blogPost(@PathVariable Long id, Model model) {
        Blog b = blogService.getBlogAndConvertContent(id);
        model.addAttribute("blog", b);
        model.addAttribute("comments", commentService.listCommentByBlogId(b.getId()));
        return "blog-post";
    }
}
