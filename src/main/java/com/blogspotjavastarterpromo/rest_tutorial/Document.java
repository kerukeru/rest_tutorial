package com.blogspotjavastarterpromo.rest_tutorial;

public class Document {

    private String title;

    public Document(String example_document) {
        this.title=example_document;
    }

    public Document() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
