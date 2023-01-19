package com.codeup.controllers;

import com.codeup.repository.PostRepository;
import com.codeup.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @RequestMapping(path = "/posts")
    @ResponseBody
    public String posts() {
        return "posts index page";
    }

    @RequestMapping(path = "/posts/index/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String viewPost(@PathVariable long id) {
        return "view the form for creating post" + id;
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    public String createPost() {
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public void createPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body, HttpServletResponse resp, HttpServletRequest req) throws IOException {
        System.out.println(title);
        System.out.println(body);
        postDao.findAll();
        Post post = new Post(title, body);
        System.out.println(post.getBody());

        postDao.save(post);
        resp.sendRedirect("/posts/show");
    }

    @GetMapping("/posts/{id}/edit")
    public String index(Model model) {
        model.addAttribute("post", new Post());
        return "posts/show";
    }
}
