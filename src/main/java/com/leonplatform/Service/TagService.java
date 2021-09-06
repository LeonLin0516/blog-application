package com.leonplatform.Service;

import com.leonplatform.Objects.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TagService {

    Tag saveTag(Tag tag);

    Optional<Tag> getTag(Long id);

    Tag getTagByName(String name);

    List<Tag> listTag();

    List<Tag> listTag(String ids);

    Page<Tag> listTag(Pageable pageable);

    List<Tag> listTopTags(Integer size);

    Tag updateTag(Long id, Tag tag);

    void deleteTag(Long id);

}
