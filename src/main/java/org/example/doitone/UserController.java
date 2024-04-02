package org.example.doitone;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // html을 반환
public class UserController {

    @GetMapping("/homePage")
    public String homePage() {
        return "home"; // home.html - view resolve
    }

    @GetMapping("/doitPage")
    public String doitPage() {
        return "doit";
    }

    @GetMapping("/userPage")
    public String userPage(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "user";
    }

    @GetMapping("/userModelPage")
    public String userPage(@ModelAttribute User user, Model model){
        model.addAttribute("user", user);
        return "userModel";
    }

    @ResponseBody
    @GetMapping("/responseBody")
    public String responseBody() {
        return "Hello World!";
    }

}
