package pl.sda.quiz.Question;

import pl.sda.quiz.Reply.Reply;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue
    @Column(name = "question_id")
    Integer id;

    String question;

    @Column(name = "is_open")
    boolean isOpen;

    // TODO What's with this? Another table?
//    List<String> multipleChoices;

//    @OneToMany
//    @JoinTable(
//            name = "questions_replies",
//            joinColumns = @JoinColumn(name = "question_id"),
//            inverseJoinColumns = @JoinColumn(name = "question_id"))
//    List<Reply> replies;
}
