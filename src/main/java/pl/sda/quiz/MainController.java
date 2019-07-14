package pl.sda.quiz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String showRegisterForm() {
        return "index";
    }

}
