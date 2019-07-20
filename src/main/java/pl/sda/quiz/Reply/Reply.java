package pl.sda.quiz.Reply;

import lombok.Getter;
import lombok.Setter;
import pl.sda.quiz.Question.Question;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "reply")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "answer")
    private String answer;

    @Column(name = "is_correct")
    private boolean isCorrect;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Question question;

}
