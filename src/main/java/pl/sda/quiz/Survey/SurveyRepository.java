package pl.sda.quiz.Survey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.quiz.Question.Question;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {
//    @Query("select s from Survey s where s.id = ?1")
//    public Survey findQuestionByText(String questionText);


}
