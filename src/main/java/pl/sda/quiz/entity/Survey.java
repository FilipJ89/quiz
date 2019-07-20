package pl.sda.quiz.entity;

import lombok.Getter;
import lombok.Setter;
import pl.sda.quiz.entity.Question;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    //public Survey (){}

    public Survey(String description) {
        this.description = description;
        this.creationDate = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public void add(Question tempQuestion){
        if(questions == null){
            questions = new ArrayList<>();
        }

        questions.add(tempQuestion);
        tempQuestion.setSurvey(this);
    }
}
