package pl.sda.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.quiz.entity.Survey;
import pl.sda.quiz.service.QuestionService;
import pl.sda.quiz.service.ReplyService;
import pl.sda.quiz.service.SurveyService;
import java.util.List;

@Controller
@RequestMapping()
public class SurveyController {

    @Autowired
    private SurveyService surveyService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private ReplyService replyService;

    @Autowired
    public SurveyController(SurveyService surveyService, QuestionService questionService, ReplyService replyService) {
        this.surveyService = surveyService;
        this.questionService = questionService;
        this.replyService = replyService;
    }


    @GetMapping("/surveys")
    public String listSurveys(Model model){
        // get theSurveys from db
        List<Survey> theSurveys = surveyService.findAll();
        //add to the spring model
        model.addAttribute("surveys", theSurveys);

        return "list-surveys";
    }

    @GetMapping("/survey/${id}")
    public String showSurvey(Model model){
        // get survey from db
        Survey survey = surveyService.findById(id);
        //add to the spring model
        model.addAttribute("surveys", survey);

        return "survey-page";
    }





    //przekierowanie na stronę dodawania ankiety
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        // create model atribute to bind form data
        Survey theSurvey = new Survey();

        model.addAttribute("survey", theSurvey);

        return "survey-form";
    }

}
