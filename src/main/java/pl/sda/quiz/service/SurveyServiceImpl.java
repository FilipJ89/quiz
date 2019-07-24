package pl.sda.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import pl.sda.quiz.dao.SurveyRepository;
import pl.sda.quiz.entity.Survey;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyServiceImpl implements SurveyService {
    private SurveyRepository surveyRepository;

    @Autowired
    public SurveyServiceImpl(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }


    @Override
    public List<Survey> findAll() {
        return surveyRepository.findAll();
    }

    @Override
    public Survey findById(int theId) {
        Optional<Survey> result = surveyRepository.findById(theId);

        Survey theSurvey = null;

        if (result.isPresent()) {
            theSurvey = result.get();
        }
        else {
            // we didn't find the survey
            throw new RuntimeException("Did not find survey id - " + theId);
        }

        return theSurvey;
    }

    @Override
    public void save(Survey theSurvey) {
        surveyRepository.save(theSurvey);
    }

    @Override
    public void deleteById(int theId) {
        surveyRepository.deleteById(theId);
    }
}
