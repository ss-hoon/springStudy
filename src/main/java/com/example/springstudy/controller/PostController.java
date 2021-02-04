package com.example.springstudy.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    // @RequestMapping(method = RequestMethod.POST, path = "/postMethod") == @PostMapping("/postMethod")
    @PostMapping(value = "/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam){
        return searchParam;
    }

    @PutMapping("/putMethod")
    public void put(){

    }

    @PatchMapping("/PatchMethod")
    public void patch(){

    }
}
