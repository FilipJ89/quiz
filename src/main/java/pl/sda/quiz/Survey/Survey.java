package pl.sda.quiz.Survey;

import lombok.Getter;
import lombok.Setter;
import pl.sda.quiz.Question.Question;
import pl.sda.quiz.Reply.Reply;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "survey")
public class Survey {

    @Id
    @GeneratedValue
    Integer id;

    @Column(name = "short_description", length = 500)
    String shortDescription;

    @Column(name = "long_description", length = 10000)
    String fullDescription;

    @Column(name = "is_quiz")
    boolean isQuiz;


//    @OneToMany
//    @JoinTable(
//            name = "survey_questions",
//            joinColumns = @JoinColumn(name = "id"),
//            inverseJoinColumns = @JoinColumn(name = "question_id"))
//    List<Question> questionList;
}
