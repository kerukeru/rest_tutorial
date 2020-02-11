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

    @DeleteMapping("/{id}")
    public void deleteDocument(@PathVariable("id") long number){
        documents.removeIf(doc -> doc.getNumber()==number);
    }

    @PatchMapping("/{number}")
    public void updateDocument(@PathVariable long number,
                               @RequestBody Document newPartialDoc){
        findDocByNumber(number).ifPresent(doc ->{
            if(newPartialDoc.getTitle() != null)
                doc.setTitle(newPartialDoc.getTitle());
            if(newPartialDoc.getTags() != null)
                doc.setTags(newPartialDoc.getTags());
        });
    }

    @PutMapping("/{number}")
    public void replaceDocument(@PathVariable long number,
                                @RequestBody Document newDocument){
        findDocByNumber(number).ifPresent(document -> {
            document.setTitle(newDocument.getTitle());
            document.setTags(newDocument.getTags());
        });
    }

    @GetMapping
    public Iterable<Document> getDocuments(){
        return documents;
    }

    @GetMapping("/{number}/title")
    public Optional<String> getTitle(@PathVariable long number){
        return findDocByNumber(number).map(Document::getTitle);
    }

    @GetMapping("/{number}")
    public Optional<Document> getDocument(@PathVariable long number){
        return findDocByNumber(number);
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

    private Optional<Document> findDocByNumber(long number){
        return documents.stream().filter(doc -> doc.getNumber()==number)
                .findAny();
    }

}
