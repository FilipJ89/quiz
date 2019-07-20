package pl.sda.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sda.quiz.dao.QuestionRepository;
import pl.sda.quiz.dao.ReplyRepository;
import pl.sda.quiz.dao.SurveyRepository;
import pl.sda.quiz.entity.Survey;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SurveyController {

    @Autowired
    private SurveyRepository surveyRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ReplyRepository replyRepository;


    @Autowired
    public SurveyController(SurveyRepository surveyRepository, QuestionRepository questionRepository, ReplyRepository replyRepository) {
        this.surveyRepository = surveyRepository;
        this.questionRepository = questionRepository;
        this.replyRepository = replyRepository;
    }

    //expose "/surveys" and return list of surveys
    @GetMapping("/surveys")
    public List<Survey> findAll(){
        return surveyRepository.findAll();
    }

    //add mapping for GET /surveys/{surveyId}
    @GetMapping("/surveys/{surveyId}")
    public Survey getSurvey(@PathVariable int surveyId){
        Optional<Survey> result = surveyRepository.findById(surveyId);

        Survey survey = null;

        if(result.isPresent()){
            survey = result.get();
        }
        else{
            // we didn't find the employee
            throw new RuntimeException("Did not find survey id - " + surveyId);
        }

        return survey;
    }

    //add mapping for POST / surveys = add new survey
    @PostMapping("/surveys")
    public Survey addSurvey(@RequestBody Survey survey) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        survey.setId(0);

        surveyRepository.save(survey);

        return survey;
    }

    //add mapping for PUT /surveys
    @PutMapping("/surveys")
    public Survey updateSurvey(@RequestBody Survey survey) {

        surveyRepository.save(survey);

        return survey;
    }

    @DeleteMapping("/surveys/{surveyId}")
    public String deleteSurvey(@PathVariable int surveyId) {

        Optional<Survey> result = surveyRepository.findById(surveyId);

        Survey survey= null;

        if(result.isPresent()){
            survey = result.get();
        }

        if (survey == null) {
            throw new RuntimeException("Employee id not found - " + surveyId);
        }

        surveyRepository.deleteById(surveyId);

        return "Deleted survey id - " + surveyId;
    }
}
