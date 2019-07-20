package pl.sda.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.quiz.Survey.SurveyRepository;
import pl.sda.quiz.dao.QuestionRepository;
import pl.sda.quiz.dao.ReplyRepository;
import pl.sda.quiz.entity.Survey;

import java.util.List;
import java.util.Optional;


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
