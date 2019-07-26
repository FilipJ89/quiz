package pl.sda.quiz.Question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.quiz.Reply.Reply;

import java.util.List;


public interface QuestionRepository extends JpaRepository<Question, Integer> {

    @Query("select answer from Reply where id=questionId")
    public List<Reply> findReplyByQuestion(int questionId);

}
