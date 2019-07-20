package pl.sda.quiz.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "text")
    private String question;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "survey_id")
    private Survey survey;

    @OneToMany(mappedBy = "question")
    private List<Reply> answers;

    //public Question (){}

    public Question(String question) {
        this.question = question;
        //this.survey = survey;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getQuestion() {
//        return question;
//    }
//
//    public void setQuestion(String question) {
//        this.question = question;
//    }
//
//    public Survey getSurvey() {
//        return survey;
//    }
//
//    public void setSurvey(Survey survey) {
//        this.survey = survey;
//    }
//
//    public Reply getCorrectAnswer() {
//        return correctAnswer;
//    }
//
//    public void setCorrectAnswer(Reply correctAnswer) {
//        this.correctAnswer = correctAnswer;
//    }

    public List<Reply> getAnswers() {
        return answers;
    }

    public void add(Reply tempAnswer){
        if(answers == null){
            answers = new ArrayList<>();
        }

        answers.add(tempAnswer);
        tempAnswer.setQuestion(this);
    }
}
