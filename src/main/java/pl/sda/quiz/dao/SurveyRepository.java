package pl.sda.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.quiz.entity.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {
}
