package pl.sda.quiz.Survey;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SurveyController {

    @GetMapping("/new")
    public String showSurveyCreationForm() {
        return "surveyForm";
    }
}
