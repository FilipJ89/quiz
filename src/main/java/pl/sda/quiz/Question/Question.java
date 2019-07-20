package pl.sda.quiz.Question;

import lombok.Getter;
import lombok.Setter;
import pl.sda.quiz.Reply.Reply;
import pl.sda.quiz.Survey.Survey;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "question")
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

}
