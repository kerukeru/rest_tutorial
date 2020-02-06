package com.blogspotjavastarterpromo.rest_tutorial.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {

    @GetMapping("/api/hello")
    public Greeting hello(){
        Greeting gr = new Greeting();
        gr.setMsg("hello!");
        return gr;
    }

}
