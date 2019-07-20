package pl.sda.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.quiz.dao.QuestionRepository;
import pl.sda.quiz.dao.ReplyRepository;
import pl.sda.quiz.dao.SurveyRepository;
import pl.sda.quiz.entity.Question;
import pl.sda.quiz.entity.Reply;
import pl.sda.quiz.entity.Survey;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    @Autowired
   private InitializerService initializerService;

   @PostConstruct
   public void init(){
       initializerService.initSurveys();
       initializerService.initQuestions();
       initializerService.initAnswers();
   };

}
