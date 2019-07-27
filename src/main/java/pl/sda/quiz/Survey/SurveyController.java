package pl.sda.quiz.Survey;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor
@Controller
public class SurveyController {

    private SurveyRepository surveyRepository;
    private QuestionRepository questionRepository;
    private ReplyRepository replyRepository;

    @Autowired
    public SurveyController(SurveyRepository surveyRepository, QuestionRepository questionRepository, ReplyRepository replyRepository) {
        this.surveyRepository = surveyRepository;
        this.questionRepository = questionRepository;
        this.replyRepository = replyRepository;
    }

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
        Survey theSurvey = survey.get();
        model.addAttribute("survey",theSurvey);
        return "showSurvey";
    }

    @PostMapping("/new")
    public String createSurvey(@ModelAttribute @Valid SurveyForm surveyForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "surveyForm";
        }

        List<Reply> listAnswers = new ArrayList<>();

        model.addAttribute(surveyForm);
        Survey survey = new Survey();
        survey.setTitle(surveyForm.getTitle());
        survey.setDescription(surveyForm.getDescription());
        survey.setCreationDate(LocalDate.now());
        surveyRepository.save(survey);

        List<Question> questions = surveyForm.getQuestions()
                .stream()
                .map(questionBlock -> {
                    Question question = new Question();
                    question.setQuestion(questionBlock.getQuestionText());
                    question.setSurvey(survey);

                    listAnswers.addAll(questionBlock.getAnswers()
                            .stream()
                            .map(replyBlock -> {
                                Reply reply = new Reply();
                                reply.setAnswer(replyBlock.getAnswer());
                                reply.setQuestion(question);
                                return reply;
                            })
                            .collect(Collectors.toList())
                    );
                    question.setAnswers(listAnswers);
                    return question;})
                .collect(Collectors.toList());
        questionRepository.saveAll(questions);

        replyRepository.saveAll(listAnswers);

        return "index";
    }


}

