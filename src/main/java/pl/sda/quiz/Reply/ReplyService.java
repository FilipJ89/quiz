package pl.sda.quiz.Reply;
import java.util.List;

public interface ReplyService {
    public List<Reply> findAll();

    public Reply findById(int theId);

    public void save(Reply theReply);

    public void deleteById(int theId);

    //public List findRepliesByQuestion(int id);
}
