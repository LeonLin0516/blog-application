package com.leonplatform.Controller;

import com.leonplatform.Objects.Comment;
import com.leonplatform.Service.BlogService;
import com.leonplatform.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/blog-post")
public class CommentController {

    @Resource
    private CommentService commentService;

    @Resource
    private BlogService blogService;

    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model) {
        List<Comment> comments = commentService.listParentCommentByBlogId(blogId);
        System.out.println(comments);
        model.addAttribute("comments", comments);
        return "blog-post :: commentList";
    }

    @PostMapping("/comments")
    public String post(Comment comment) {
        Long id = comment.getBlog().getId();
        comment.setBlog(blogService.getBlog(id));
        commentService.saveComment(comment);
        return "redirect:/blog-post/comments/" + comment.getBlog().getId();
    }
}
