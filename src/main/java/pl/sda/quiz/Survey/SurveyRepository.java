package pl.sda.quiz.Survey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.quiz.Question.Question;
import pl.sda.quiz.Reply.Reply;

import java.util.List;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {

    public List<Survey> findByTitleContains(String text);
}