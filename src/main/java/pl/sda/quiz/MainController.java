package pl.sda.quiz;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @GetMapping("/")
    public String showRegisterForm(@RequestParam(name = "view", required = false) String view, Model model)
    {
        if(view == null) {
            view = "all";
        }
        System.out.println(view);
        model.addAttribute("view",view);
        return "index";
    }



}
