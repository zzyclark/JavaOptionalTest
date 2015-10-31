package com.superclark.model;

import java.util.Optional;

/**
 * Created by clark on 31/10/15.
 */
public class User {
    private String name;
    private Document document;

    public User(String name, Document document) {
        this.name = name;
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", document=" + document.toString() +
                '}';
    }

    public Optional<String> getNameOption() {
        return Optional.ofNullable(this.name);
    }

    public Optional<Document> getDocumentOption() {
        return Optional.ofNullable(this.document);
    }
}
