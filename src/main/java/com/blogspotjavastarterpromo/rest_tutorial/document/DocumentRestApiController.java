package com.blogspotjavastarterpromo.rest_tutorial.document;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/documents")
public class DocumentRestApiController {

    private Collection<Document> documents = new ArrayList<>();

    @GetMapping
    public Iterable<Document> getDocuments(){
        return documents;
    }

    @GetMapping("/{number}")
    public Optional<Document> getDocument(@PathVariable long number){
        return documents.stream().filter(doc -> doc.getNumber()==number).findAny();
    }

    @GetMapping("/{number}/title")
    public Optional<String> getTitle(@PathVariable long number){
        return documents.stream().filter(doc -> doc.getNumber()==number)
                .findAny().map(Document::getTitle);
    }

    @PostMapping
    public void addDocument(@RequestBody Document dokument){
        documents.add(dokument);
    }

    @PostMapping(value = "/{docNumber}/tags", consumes = MediaType.TEXT_PLAIN_VALUE)
    public void addTag(@PathVariable long docNumber,@RequestBody String tag){
        documents.stream()
                .filter(document -> document.getNumber() == docNumber)
                .findAny().ifPresent(document -> document.getTags().add(tag));

    }
}
