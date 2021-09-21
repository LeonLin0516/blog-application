package com.leonplatform.Service;

import com.leonplatform.Objects.Blog;
import com.leonplatform.ViewObjects.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {

    Blog getBlog(Long id);

    Blog getBlogAndConvertContent(Long id);

    Blog saveBlog(Blog blog);

    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blogQuery);

    Page<Blog> listPublishedBlog(Pageable pageable);

    List<Blog> listPublishedBlog();

    List<Blog> listBlog();

    void deleteBlog(Long id);

}
