package com.codeup.blogapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HomeController {

    @GetMapping(path = "/")
    @ResponseBody
    public String home() {
        return "This is the landing page";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello" ;
    }

    @GetMapping("roll-dice")
    public String rollDice(Model model) {
        model.addAttribute("roll", (int) (Math.random() * 6) + 1);
        return "roll-dice";
    }

    @PostMapping("/roll-dice")
    @ResponseBody
    public void rolledDice(@RequestParam(name = "guess") int guess, Model model, HttpServletResponse response) throws IOException {
        model.addAttribute("guess", guess);
        model.addAttribute("roll", (int) (Math.random() * 6) + 1);
        response.sendRedirect("/roll-dice/" + guess);
    }


    @GetMapping("roll-dice/{n}")
    public String rollDice(@PathVariable int n, Model model) {
        model.addAttribute("roll", (int) (Math.random() * 6) + 1);
        model.addAttribute("guess", n);
        return "roll-dice-n";
    }

}
