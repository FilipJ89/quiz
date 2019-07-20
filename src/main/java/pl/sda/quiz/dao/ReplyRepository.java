package pl.sda.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.quiz.entity.Reply;
import pl.sda.quiz.entity.Survey;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
}
