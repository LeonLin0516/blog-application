package com.leonplatform.Service;

import com.leonplatform.Objects.Blog;
import com.leonplatform.ViewObjects.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {

    Blog getBlog(Long id);

    Blog saveBlog(Blog blog);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blogQuery);

    Blog updateBlog(Long id, Blog blog);

    void deleteBlog(Long id);

}
