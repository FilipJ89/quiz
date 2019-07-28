package pl.sda.quiz.User;

import lombok.Getter;
import lombok.Setter;
import pl.sda.quiz.Survey.Survey;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    Integer id;

    @Column(name = "first_name", length = 20)
    String firstName;

    @Column(name = "last_name", length = 20)
    String lastName;

    @Column(name = "email", length = 50)
    String email;

    @Column(name = "password")
    String password;

    @ManyToMany
    @JoinTable(
            name = "survey_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "survey_id"))
    Set<Survey> filledSurveys;

}
