package pl.sda.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.quiz.dao.QuestionRepository;
import pl.sda.quiz.entity.Question;


import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question findById(int theId) {
        Optional<Question> result = questionRepository.findById(theId);

        Question theQuestion = null;

        if (result.isPresent()) {
            theQuestion = result.get();
        }
        else {
            // we didn't find the question
            throw new RuntimeException("Did not find question id - " + theId);
        }

        return theQuestion;
    }

    @Override
    public void save(Question theQuestion) {
        questionRepository.save(theQuestion);
    }

    @Override
    public void deleteById(int theId) {
        questionRepository.deleteById(theId);
    }
}
