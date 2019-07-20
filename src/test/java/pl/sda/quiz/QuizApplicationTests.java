package pl.sda.quiz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sda.quiz.controller.SurveyController;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
public class QuizApplicationTests {

    @Autowired
    private SurveyController surveyController;

    @Test
    public void contextLoads() {
        System.out.println(surveyController.findAll());
    }

//    @Test
//    public void addUser(){
//        surveyController.addSurvey()
//    }

}
