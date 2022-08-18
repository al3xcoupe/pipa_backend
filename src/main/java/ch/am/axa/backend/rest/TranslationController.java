package ch.am.axa.backend.rest;

import ch.am.axa.backend.entity.TranslationEntity;
import ch.am.axa.backend.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author : Alexander Margraf
 * @version : 18.08.2022
 */

@RestController
@Slf4j
public class TranslationController {

    @Autowired
    private DataService dataService;

    @GetMapping("/translation")
    public ResponseEntity<Iterable<TranslationEntity>> getTranslations(){
        log.info("GET all Translations");
        Iterable<TranslationEntity> translationEntities = dataService.getAllTranslationEntrys();
        if (translationEntities != null) return ResponseEntity.ok(translationEntities);
        return ResponseEntity.internalServerError().build();
    }

    @DeleteMapping("/translation")
    public ResponseEntity deleteTranslation(@RequestParam String textid){
        log.info("DELETE translation with id:  {}",textid);
        dataService.deleteTranslation(textid);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/translation")
    public ResponseEntity<TranslationEntity> addTranslation(@RequestBody TranslationEntity entity){
        log.info("POST translation with id:  {}",entity.getText_id());
        if(entity == null) {
            log.error("Translation cannot be added because is null");
            return ResponseEntity.badRequest().build();
        }

        TranslationEntity t = dataService.addTranslation(entity);
        log.info("SUCCESS: The translation with the id: {} is added in the DB",entity.getText_id());
        return ResponseEntity.ok(t);
    }

    @GetMapping("/translation/text/{textid}")
    public ResponseEntity<TranslationEntity> getByTextId(@PathVariable String textid){
        log.info("GET translation with text id:  {}",textid);
        Optional<TranslationEntity> entity = dataService.getTranslationEntryById(textid);
        return entity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/translation/text")
    public ResponseEntity<Iterable<TranslationEntity>> getByAppId(@RequestParam String appId){
        log.info("GET translation with app id:  {}",appId);
        Iterable<TranslationEntity> entities = dataService.getTranslationByAppId(appId);
        return ResponseEntity.ok(entities);
    }






}
