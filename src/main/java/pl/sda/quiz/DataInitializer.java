package pl.sda.quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
       initializerService.initUsers();


       //initializerService.deleteSurvey();
   }

}
