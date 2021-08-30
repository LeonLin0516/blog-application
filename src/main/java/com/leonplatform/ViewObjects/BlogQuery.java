package com.leonplatform.ViewObjects;

import com.leonplatform.Objects.Tag;

import java.util.List;

public class BlogQuery {

    private String title;
    private List<Long> tagIDs;

    public BlogQuery() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Long> getTagIDs() {
        return tagIDs;
    }

    public void setTagIDs(List<Long> tagIDs) {
        this.tagIDs = tagIDs;
    }
}
