package com.leonplatform.Service;

import com.leonplatform.Objects.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentService {

    Comment saveComment(Comment comment);

    List<Comment> listCommentByBlogId(Long blogId);

    List<Comment> listParentCommentByBlogId(Long blogId);
}
