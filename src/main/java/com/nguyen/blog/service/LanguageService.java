package com.nguyen.blog.service;

import com.nguyen.blog.dto.request.LanguageCreationRequest;
import com.nguyen.blog.entity.Language;
import com.nguyen.blog.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    @Autowired
    LanguageRepository languageRepository;
    public Language createLanguage(LanguageCreationRequest request) {
        Language language = new Language();
        language.setName(request.getName());
        language.setFlag(request.getFlag());
        language.setLocale(request.getLocale());
        return languageRepository.save(language);
    }
    public Language getLanguage(int id) {
        return languageRepository.findById(id+"").orElseThrow(
                () -> new RuntimeException("Language not found")// day la lambda
        );
    }
    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }
    public Language updateLanguage(int id,LanguageCreationRequest request) {
        Language language=getLanguage(id);
        language.setName(request.getName());
        language.setFlag(request.getFlag());
        language.setLocale(request.getLocale());
        return languageRepository.save(language);
    }
    public void deleteLanguage(int id) {
        languageRepository.deleteById(id+"");
    }
}
