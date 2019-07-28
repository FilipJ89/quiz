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
import pl.sda.quiz.Survey.SurveyType;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class MainController {

    @Autowired
    SurveyRepository surveyRepository;

    @GetMapping("/")
    public String showMainPage(@RequestParam(name = "view" , required = false) String view, @RequestParam(name = "search", required = false) String search, Model model)
    {
        List<Survey> surveys;
        if (search == null || search.equals("")) {
            surveys = surveyRepository.findAll();
            model.addAttribute("view",view);
        } else {
            surveys= surveyRepository.findByTitleContains(search);
            model.addAttribute("search",search);
        }
        model.addAttribute("surveys", surveys);
        return "index";
    }
}
