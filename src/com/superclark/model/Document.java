package com.superclark.model;

import java.util.Optional;

/**
 * Created by clark on 31/10/15.
 */
public class Document {
    private String title;
    private String content;

    public Document(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Document{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Optional<String> getContentOption() {
        return Optional.ofNullable(this.content);
    }

    public Optional<String> getTitleOption() {
        return Optional.ofNullable(this.title);
    }
}
