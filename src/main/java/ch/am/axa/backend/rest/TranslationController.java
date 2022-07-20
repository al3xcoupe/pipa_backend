package ch.am.axa.backend.rest;

import ch.am.axa.backend.entity.RestDataStructur;
import ch.am.axa.backend.entity.TranslationEntry;
import ch.am.axa.backend.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TranslationController {

    @Autowired
    private DataService dataService;

    @GetMapping("/translation")
    public List<RestDataStructur> getTranslations(){
        return dataService.getAllTranslationGermany();
    }


}
