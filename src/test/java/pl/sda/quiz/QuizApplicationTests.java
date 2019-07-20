package pl.sda.quiz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.quiz.controller.SurveyController;
import pl.sda.quiz.dao.QuestionRepository;
import pl.sda.quiz.dao.SurveyRepository;
import pl.sda.quiz.entity.Question;
import pl.sda.quiz.entity.Survey;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
public class QuizApplicationTests {

    @Autowired
    private SurveyController surveyController;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private SurveyRepository surveyRepository;

    @Test
    public void contextLoads() {
        System.out.println(surveyController.findAll());
    }

    @Test
    public void shouldAddData() {
        Survey s = new Survey();
        s.setDescription("desc2");
        s.setTitle("title2");
        surveyRepository.save(s);
    }

    @Test
    @Transactional
    public void shouldAddQuestion(){
        Survey s = surveyRepository.findById(1).get();
        Question q = new Question();
//        Survey s = new Survey();
//        s.setId(1);
        q.setSurvey(s);
        q.setText("example test");
        questionRepository.save(q);
    }

    @Test
    public void addUser(){
        Survey survey = new Survey();
        survey.setDescription("Food survey");
    }

}
