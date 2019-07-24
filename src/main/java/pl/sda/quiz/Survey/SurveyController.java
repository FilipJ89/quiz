package pl.sda.quiz.Survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class SurveyController {

    @Autowired
    private SurveyRepository surveyRepository;

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

        System.out.println(surveyForm.getTitle());
        System.out.println(surveyForm.getDescription());

        return "index";}
}
