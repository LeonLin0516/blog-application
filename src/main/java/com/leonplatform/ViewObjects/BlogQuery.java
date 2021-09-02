package com.leonplatform.ViewObjects;

import com.leonplatform.Objects.Tag;

import java.util.List;

public class BlogQuery {

    private String title;
    private String tagIDs;

    public BlogQuery() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTagIDs() {
        return tagIDs;
    }

    public void setTagIDs(String tagIDs) {
        this.tagIDs = tagIDs;
    }
}
