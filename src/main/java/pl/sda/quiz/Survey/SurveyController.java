package pl.sda.quiz.Survey;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.quiz.User.UserRepository;

@Controller
public class SurveyController {

//    SurveyRepository surveyRepository;
//
//    public SurveyController(SurveyRepository surveyRepository) {
//        this.surveyRepository = surveyRepository;
//    }

    // TODO mapping pages with parameters to show all or only surveys or only quizes on the main page using "MainPAgeView" interface. All should be a default option when loading the page
    @GetMapping("/survey")
    public String showRegisterForm() {
        return "index";
    }
}
