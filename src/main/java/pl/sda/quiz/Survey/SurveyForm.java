package pl.sda.quiz.Survey;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.sda.quiz.Question.Question;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
public class SurveyForm {

    @NotBlank(message = "* field cannot be left empty")
    private String title;

    @NotBlank(message = "* field cannot be left empty")
    private String description;

    @NotNull(message = "* field cannot be null")
    @NotBlank(message = "* field cannot be left empty")
    private List<Question> questions;


}
