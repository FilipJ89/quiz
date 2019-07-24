package pl.sda.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.quiz.dao.ReplyRepository;
import pl.sda.quiz.entity.Reply;
import pl.sda.quiz.entity.Survey;

import java.util.List;
import java.util.Optional;
@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    @Override
    public List<Reply> findAll() {
        return replyRepository.findAll();
    }

    @Override
    public Reply findById(int theId) {
        Optional<Reply> result = replyRepository.findById(theId);

        Reply theReply = null;

        if (result.isPresent()) {
            theReply = result.get();
        }
        else {
            // we didn't find the reply
            throw new RuntimeException("Did not find reply id - " + theId);
        }

        return theReply;
    }

    @Override
    public void save(Reply theReply) {
        replyRepository.save(theReply);
    }

    @Override
    public void deleteById(int theId) {
        replyRepository.deleteById(theId);
    }
}
