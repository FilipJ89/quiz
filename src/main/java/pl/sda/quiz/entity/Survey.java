package pl.sda.quiz.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.sda.quiz.entity.Question;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "survey")
public class Survey {

    public Survey() {
        this.creationDate = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @NotNull
    @Column(name = "creation_date")
    private Date creationDate;

    @OneToMany(mappedBy = "survey")
    private List <Question> questions = new ArrayList<>();




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
