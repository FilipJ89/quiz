package pl.sda.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.quiz.User.User;
import pl.sda.quiz.User.UserRepository;
import pl.sda.quiz.dao.QuestionRepository;
import pl.sda.quiz.dao.ReplyRepository;
import pl.sda.quiz.dao.SurveyRepository;
import pl.sda.quiz.entity.Question;
import pl.sda.quiz.entity.Reply;
import pl.sda.quiz.entity.Survey;

import java.util.Optional;

@Service
public class InitializerService {
    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private UserRepository userRepository;


    @Transactional
    public void initAnswers() {
        if (replyRepository.count() != 0) {
            return;
        }
        // save data to db
        //Question q1 = questionRepository.findById(1).get();
        Question q1 = questionRepository.findQuestionByText("Jaka pizza jest najlepsza?");

        Reply r1 = new Reply();
        r1.setQuestion(q1);
        r1.setAnswer("Hawajska");
        replyRepository.save(r1);

        Reply r2 = new Reply();
        r2.setQuestion(q1);
        r2.setAnswer("Pepperoni");
        replyRepository.save(r2);

        Reply r3 = new Reply();
        r3.setQuestion(q1);
        r3.setAnswer("Margherita");
        replyRepository.save(r3);

        Reply r4 = new Reply();
        r4.setQuestion(q1);
        r4.setAnswer("Capriciosa");
        replyRepository.save(r4);

        //Question q2 = questionRepository.findById(2).get();
        Question q2 = questionRepository.findQuestionByText("Jakiego zwierzaczka lubisz najbardziej?");
        Reply r5 = new Reply();
        r5.setQuestion(q2);
        r5.setAnswer("Kot");
        replyRepository.save(r5);

        Reply r6 = new Reply();
        r6.setQuestion(q2);
        r6.setAnswer("Pies");
        replyRepository.save(r6);

        Reply r7 = new Reply();
        r7.setQuestion(q2);
        r7.setAnswer("Chomik");
        replyRepository.save(r5);

        Reply r8 = new Reply();
        r8.setQuestion(q2);
        r8.setAnswer("Koń");
        replyRepository.save(r8);
    }


    @Transactional
    public void initQuestions() {
        if (questionRepository.count() != 0) {
            return;
        }
        // save data to db
        //Survey s1 = surveyRepository.findById(1).get();
        Survey s1 = surveyRepository.findSurveyByTitle("Jedzenie");
        Question q1 = new Question();
        q1.setSurvey(s1);
        q1.setText("Jaka pizza jest najlepsza?");
        questionRepository.save(q1);

//        Survey s2 = surveyRepository.findById(2).get();
        Survey s2 = surveyRepository.findSurveyByTitle("Zwierzaczki");
        Question q2 = new Question();
        q2.setSurvey(s2);
        q2.setText("Jakiego zwierzaczka lubisz najbardziej?");
        questionRepository.save(q2);
    }


    @Transactional
    public void initSurveys() {
        if (surveyRepository.count() != 0) {
            return;
        }
        // save data to db
        Survey s1 = new Survey();
        s1.setTitle("Jedzenie");
        s1.setDescription("Ankieta o jedzeniu");
        surveyRepository.save(s1);

        Survey s2 = new Survey();
        s2.setTitle("Zwierzaczki");
        s2.setDescription("Ankieta o zwierzeczkach");
        surveyRepository.save(s2);
    }

    @Transactional
    public void initUsers(){
        if (userRepository.count() != 0) {
            return;
        }

        User u1 = new User();
        u1.setFirstName("Jan");
        u1.setLastName("Kowalski");
        u1.setEmail("jk@onet.pl");
        u1.setPassword("password");
        userRepository.save(u1);

        User u2 = new User();
        u2.setFirstName("Stanisław");
        u2.setLastName("Wokulski");
        u2.setEmail("sw@onet.pl");
        u2.setPassword("password");
        userRepository.save(u2);
    }

//    @Transactional
//    public User findUserByName(String string){
//        return userRepository.findUserByName(string);
//
//    }

//    @Transactional
//    public void deleteSurvey(){
//        Survey s1 = surveyRepository.findSurveyByTitle("Jedzenie");
//        surveyRepository.delete(s1);
//    }
}
