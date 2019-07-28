package pl.sda.quiz.Survey;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class SurveyForm {


    private SurveyType type;

    @NotBlank(message = "* field cannot be left empty")
    private String title;

    @NotBlank(message = "* field cannot be left empty")
    private String description;

    @NotNull(message = "* field cannot be null")
    private List<QuestionBlock> questions= new ArrayList<>();

    @Getter
    @Setter
    @NoArgsConstructor
    public static class QuestionBlock {

        private List<ReplyBlock> answers = new ArrayList<>();

        @NotEmpty(message = "* field cannot be left empty")
        private String questionText;

        private String choice;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class ReplyBlock {
        @NotEmpty(message = "* field cannot be left empty")
        String answer;
    }


}
