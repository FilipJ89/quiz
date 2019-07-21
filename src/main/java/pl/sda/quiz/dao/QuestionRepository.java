package pl.sda.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.quiz.entity.Question;
import pl.sda.quiz.entity.Survey;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    @Query("select q from Question q where q.text = ?1")
    public Question findQuestionByText(String questionText);
}
