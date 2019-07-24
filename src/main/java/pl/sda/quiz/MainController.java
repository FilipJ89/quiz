package pl.sda.quiz;

import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.quiz.Survey.Survey;
import pl.sda.quiz.Survey.SurveyRepository;

import java.awt.*;
import java.util.List;


@Controller
public class MainController {

    @Autowired
    SurveyRepository surveyRepository;

    @GetMapping("/")
    public String showMainPage(@RequestParam(name = "view", required = false) String view, Model model)
    {
        if(view == null) {
            view = "all";
        }
        System.out.println(view);

        List<Survey> surveys= surveyRepository.findAll();
        model.addAttribute("surveys", surveys);
        model.addAttribute("view",view);
        return "index";
    }
}
