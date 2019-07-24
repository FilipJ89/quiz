package pl.sda.quiz.service;

import pl.sda.quiz.entity.Survey;

import java.util.List;

public interface SurveyService {

    public List<Survey> findAll();

    public Survey findById(int theId);

    public void save(Survey theSurvey);

    public void deleteById(int theId);
}
