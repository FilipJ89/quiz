package pl.sda.quiz.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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



//    public Question(String question) {
//        this.question = question;
//        //this.survey = survey;
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
