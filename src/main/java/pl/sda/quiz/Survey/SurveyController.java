package pl.sda.quiz.Survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda.quiz.Question.Question;
import pl.sda.quiz.Question.QuestionRepository;
import pl.sda.quiz.Reply.Reply;
import pl.sda.quiz.Reply.ReplyRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class SurveyController {

    @Autowired
    private SurveyRepository surveyRepository;


    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @GetMapping("/new")
    public String showSurveyCreationForm(Model model) {
        model.addAttribute("surveyForm", new SurveyForm());
        return "surveyForm";
    }

    @GetMapping("/survey")
    public String showSurvey(@RequestParam(value = "id") Integer id, Model model) {

        Optional<Survey> survey = surveyRepository.findById(id);
        if(!survey.isPresent()) {
            throw new RuntimeException("Did not find survey id - " + id);
        }

//        Optional<Question> question = questionRepository.findQuestionBySurvey(id);
        Survey theSurvey = survey.get();
        model.addAttribute("survey",theSurvey);

        Optional<Question> question = questionRepository.findById(id);
        if(!question.isPresent()) {
            throw new RuntimeException("Did not find question id - " + id);
        }

        Question theQuestion = question.get();
        model.addAttribute("question", theQuestion);

        List<Reply> replies = replyRepository.findAll();

        model.addAttribute("replies", replies);








        return "showSurvey";
    }

    @PostMapping("/new")
    public String createSurvey(@ModelAttribute @Valid SurveyForm surveyForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "surveyForm";
        }

        System.out.println(surveyForm.getTitle());
        System.out.println(surveyForm.getDescription());

        return "index";}
}
