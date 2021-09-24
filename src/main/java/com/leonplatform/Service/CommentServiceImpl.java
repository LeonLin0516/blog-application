package com.leonplatform.Service;

import com.leonplatform.DAO.CommentRepository;
import com.leonplatform.Objects.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment saveComment(Comment comment) {
        if (comment.getParentComment().getId() == -1) {
            comment.setParentComment(null);
        } else {
            comment.getParentComment().addReplyComment(comment);
        }
        comment.setCreateTime(new Date());
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> listCommentByBlogId(Long blogId) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        return commentRepository.findByBlogId(blogId, sort);
    }

    @Override
    public List<Comment> listParentCommentByBlogId(Long blogId) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        return commentRepository.findAllByBlogIdAndParentCommentIsNull(blogId, sort);
    }

}
