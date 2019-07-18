package pl.sda.quiz.Survey;

import lombok.Getter;
import lombok.Setter;
import pl.sda.quiz.Question.Question;
import pl.sda.quiz.Reply.Reply;

import javax.persistence.*;
import java.util.ArrayList;
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

    public Survey (){}

    public Survey(String description, Date creationDate) {
        this.description = description;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Date getCreationDate() {
//        return creationDate;
//    }
//
//    public void setCreationDate(Date creationDate) {
//        this.creationDate = creationDate;
//    }
//
//    public List<Question> getQuestions() {
//        return questions;
//    }

    public void add(Question tempQuestion){
        if(questions == null){
            questions = new ArrayList<>();
        }

        questions.add(tempQuestion);
        tempQuestion.setSurvey(this);
    }
}
