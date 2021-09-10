package com.leonplatform.Service;

import com.leonplatform.DAO.BlogRepository;
import com.leonplatform.NotFoundException;
import com.leonplatform.Objects.Blog;
import com.leonplatform.Objects.Tag;
import com.leonplatform.Utils.MarkdownUtils;
import com.leonplatform.ViewObjects.BlogQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.leonplatform.Utils.ConversionUtils.convertToList;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Override
    public Blog getBlog(Long id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public Blog getBlogAndConvertContent(Long id) {
        Blog blog = blogRepository.findById(id).get();
        if (blog == null) {
            throw new NotFoundException("This Blog Doesn't Exist!");
        }
        Blog b = new Blog();
        BeanUtils.copyProperties(blog, b);
        b.setContent(MarkdownUtils.markdownToHtml(blog.getContent()));
        return b;
    }

    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Page<Blog> listBlog(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> listBlog(Pageable pageable, BlogQuery blogQuery) {
        return blogRepository.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root,
                                         CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if (blogQuery.getTitle() != null && !"".equals(blogQuery.getTitle())) {
                    predicates.add(criteriaBuilder.like(root.<String>get("title"), "%" + blogQuery.getTitle() + "%"));
                }
//                if (blogQuery.getTagIDs() != null) {
//                    List<Long> IDs = convertToList(blogQuery.getTagIDs());
//                    System.out.println(IDs);
//                    for (Long id : IDs) {
//                        predicates.add(criteriaBuilder.equal(root.<List<Tag>>get("tags").get("id"), id));
//                    }
//                }
                criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        }, pageable);
    }

    @Override
    public List<Blog> listBlog() {
        return blogRepository.findAll();
    }

    @Override
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}
