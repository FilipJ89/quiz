package pl.sda.quiz.Reply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {

//    @Query("select answer from reply where question_id=?1")
//    public List<Reply> findReplyByQuestionId(int questionId);
}
