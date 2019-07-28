package pl.sda.quiz.Survey;

import lombok.Getter;

@Getter
public enum SurveyType {

    QUIZ("Quiz"), SURVEY("Survey");

    private String type;
    SurveyType(String type) {
        this.type = type;
    }
}
