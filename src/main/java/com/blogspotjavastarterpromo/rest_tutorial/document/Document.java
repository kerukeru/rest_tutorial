package com.blogspotjavastarterpromo.rest_tutorial.document;

import java.util.List;

public class Document {

    private long number;
    private String title;
    private List<String> tags;

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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
}
