package pl.sda.quiz.service;

import pl.sda.quiz.entity.Reply;

import java.util.List;

public interface ReplyService {
    public List<Reply> findAll();

    public Reply findById(int theId);

    public void save(Reply theReply);

    public void deleteById(int theId);
}
