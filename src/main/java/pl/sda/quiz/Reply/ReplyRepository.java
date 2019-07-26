package pl.sda.quiz.Reply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.quiz.Question.Question;

import java.util.List;


public interface ReplyRepository extends JpaRepository<Reply, Integer> {
//    @Query("select answer from reply where question_id = ?1")
//    public List findRepliesByQuestion(int id);
}
