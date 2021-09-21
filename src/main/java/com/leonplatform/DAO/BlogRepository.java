package com.leonplatform.DAO;

import com.leonplatform.Objects.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {

    Page<Blog> findBlogsByPublishedIsTrue(Pageable pageable);

    List<Blog> findBlogsByPublishedIsTrue();
}
