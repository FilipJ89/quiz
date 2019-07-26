package pl.sda.quiz.Question;


import java.util.List;

public interface QuestionService {
    public List<Question> findAll();

    public Question findById(int theId);

    public void save(Question theQuestion);

    public void deleteById(int theId);
}
