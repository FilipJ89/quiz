package pl.sda.quiz.Survey;

import lombok.Getter;
import lombok.Setter;
import pl.sda.quiz.Question.Question;
import pl.sda.quiz.Reply.Reply;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "survey")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="description")
    private String description;

    @Column(name = "creation_date")
    private Date creationDate;

    @OneToMany(mappedBy = "survey")
    private List <Question> questions;

}
