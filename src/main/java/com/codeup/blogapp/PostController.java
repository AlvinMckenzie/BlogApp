package com.codeup.blogapp;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @RequestMapping(path = "/posts")
    @ResponseBody
    public String posts() {
        return "posts index page";
    }

    @RequestMapping(path = "/posts/{id}")
    @ResponseBody
    public String viewPost() {
        return "view the form for creating post";
    }

    @RequestMapping(path = "/posts/create")
    @ResponseBody
    public String createPost() {
        return "create a new post";
    }
}
