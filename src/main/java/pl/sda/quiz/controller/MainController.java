package pl.sda.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.quiz.User.User;
import pl.sda.quiz.User.UserRepository;

import javax.servlet.http.HttpServletRequest;


@Controller
public class MainController {

    private UserRepository userRepository;

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

    @PostMapping("/processLogin")
    public String processLogin(HttpServletRequest request, Model model){
            model.addAttribute("yourName", request.getParameter("yourName"));
            return "helloUser";
        //Survey s1 = surveyRepository.findSurveyByTitle("Jedzenie");


    }

}
