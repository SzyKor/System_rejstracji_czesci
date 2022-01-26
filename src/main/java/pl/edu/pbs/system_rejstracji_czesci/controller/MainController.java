package pl.edu.pbs.system_rejstracji_czesci.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @ResponseBody
    @GetMapping("/hello")
    public String helloString(){
        return "hello Spring!";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
