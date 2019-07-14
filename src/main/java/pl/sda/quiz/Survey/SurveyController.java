package pl.sda.quiz.Survey;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SurveyController {

    // TODO mapping pages with parameters to show all or only surveys or only quizes on the main page using "MainPAgeView" interface. All should be a default option when loading the page
    @GetMapping("/survey")
    public String showRegisterForm() {
        return "index";
    }
}
