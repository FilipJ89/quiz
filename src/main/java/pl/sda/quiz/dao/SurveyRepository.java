package pl.sda.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.quiz.entity.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {
    @Query("select s from Survey s where s.title = ?1")
    public Survey findSurveyByTitle(String surveyTitle);
}
