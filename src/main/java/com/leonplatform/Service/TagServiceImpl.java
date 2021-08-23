package com.leonplatform.Service;

import com.leonplatform.DAO.TagRepository;
import com.leonplatform.NotFoundException;
import com.leonplatform.Objects.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Transactional
    @Override
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Transactional
    @Override
    public Optional<Tag> getTag(Long id) {
        return tagRepository.findById(id);
    }

    @Transactional
    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Tag updateTag(Long id, Tag tag) {
        Optional<Tag> t = tagRepository.findById(id);
        if (t == null) {
            throw new NotFoundException("Can't find the specified tag!");
        }
        BeanUtils.copyProperties(tag, t);
        return saveTag(tag);
    }

    @Transactional
    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }
}