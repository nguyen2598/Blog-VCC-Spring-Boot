package com.nguyen.blog.controller;

import com.nguyen.blog.dto.request.LanguageCreationRequest;
import com.nguyen.blog.entity.Language;
import com.nguyen.blog.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/languages")
public class LanguageController {
    @Autowired
    private LanguageService languageService;


    @PostMapping("/create-language")
    Language createLanguage(@RequestBody LanguageCreationRequest request) {
       return languageService.createLanguage(request);
    }

    @GetMapping("all")
    List<Language> getAllLanguages() {
        return languageService.getAllLanguages();
    }

    @GetMapping("/")
    Language getLanguage(@RequestParam int id) {
        return  languageService.getLanguage(id);
    }


    @PutMapping("/edit-language/{languageId}")
    Language updateLanguage(@PathVariable int languageId, @RequestBody LanguageCreationRequest request) {
        return languageService.updateLanguage(languageId, request);
    }


    @DeleteMapping("/delete/{languageId}")
    void deleteLanguage(@PathVariable int languageId) {
         languageService.deleteLanguage(languageId);
    }

}
