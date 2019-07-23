package pl.sda.quiz.Survey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SurveyController {

    @GetMapping("/new")
    public String showSurveyCreationForm(Model model) {
        model.addAttribute("surveyForm", new SurveyForm());
        return "surveyForm";
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
