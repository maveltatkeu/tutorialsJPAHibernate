package com.pix.tutorial.sample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pix.tutorial.sample.model.Tutorial;
import com.pix.tutorial.sample.repository.TutorialRepository;

import lombok.Data;

@Data
@Service
public class TutorialService {

    @Autowired
    private TutorialRepository tutorialRepository;

    public Optional<Tutorial> getTutorial(final Long id) {
        return tutorialRepository.findById(id);
    }

    public Iterable<Tutorial> getTutorials() {
        return tutorialRepository.findAll();
    }

    public void deleteTutorial(final Long id) {
        tutorialRepository.deleteById(id);
    }

    public Tutorial saveTutorial(Tutorial tutorial) {
        Tutorial savedTutorial = tutorialRepository.save(tutorial);
        return savedTutorial;
    }

    public Iterable<Tutorial> findAll() {
        return tutorialRepository.findAll();
    }

    public Iterable<Tutorial> findByTitleContaining(String title) {
        return tutorialRepository.findByTitleContaining(title);
    }

    public void deleteAll() {
        tutorialRepository.deleteAll();
    }

    public List<Tutorial> findByPublished(boolean b) {

        return tutorialRepository.findByPublished(b);
    }

}