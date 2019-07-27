package pl.sda.quiz.Question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    @Query("from Question as q where q.survey.id=:id")
    List<Question> findQuestionBySurveyId(@Param("id") Integer surveyId);

    List<Question> findBySurvey_Id(Integer surveyId);

}
