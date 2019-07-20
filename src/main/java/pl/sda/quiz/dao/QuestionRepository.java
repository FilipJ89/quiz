package pl.sda.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.quiz.entity.Question;
import pl.sda.quiz.entity.Survey;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
