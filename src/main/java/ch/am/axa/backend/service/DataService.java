package ch.am.axa.backend.service;

import ch.am.axa.backend.entity.ApplikationEntity;
import ch.am.axa.backend.entity.TranslationEntity;
import ch.am.axa.backend.repository.ApplikationRepository;
import ch.am.axa.backend.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

/**
 * @author : Alexander Margraf
 * @version : 18.08.2022
 */
@Service
@CrossOrigin
public class DataService {

    private final ApplikationRepository applikationRepository;

    private final TranslationRepository translationEntryRepository;

    @Autowired
    public DataService(ApplikationRepository applikationRepository, TranslationRepository translationEntryRepository) {
        this.applikationRepository = applikationRepository;
        this.translationEntryRepository = translationEntryRepository;
    }

    public Iterable<TranslationEntity> getAllTranslationEntrys(){
        Iterable<TranslationEntity> translationEntries = translationEntryRepository.findAll();

        return translationEntries;
    }

    public Optional<TranslationEntity> getTranslationEntryById(String id){
        return translationEntryRepository.findById(id);
    }

    public Iterable<TranslationEntity> getTranslationByAppId(String appId){
        List<TranslationEntity> entities = (List<TranslationEntity>) getAllTranslationEntrys();

        for(TranslationEntity e : entities){
            if(!e.getApp_idfs().equals(appId)){
                entities.remove(e);
            }
        }

        return entities;
    }

    public void deleteTranslation(String textid){
        translationEntryRepository.deleteById(textid);
    }

    public TranslationEntity addTranslation(TranslationEntity entity){

        TranslationEntity newEntity = new TranslationEntity();

        Optional<ApplikationEntity> applikationDb = applikationRepository.findById(entity.getApp_idfs().getApp_id());

        if(applikationDb.isPresent()){
            newEntity.setApp_idfs(applikationDb.get());
        }else{
            ApplikationEntity newApplikation = new ApplikationEntity();
            newApplikation.setApp_id(entity.getApp_idfs().getApp_id());
            newApplikation.setApp_owner_email(entity.getApp_idfs().getApp_owner_email());

            newEntity.setApp_idfs(newApplikation);
        }

        newEntity.setText_id(entity.getText_id());
        newEntity.setApp_idfs(entity.getApp_idfs());
        newEntity.setContent_de(entity.getContent_de());
        newEntity.setContent_fr(entity.getContent_fr());
        newEntity.setContent_en(entity.getContent_en());
        newEntity.setContent_it(entity.getContent_it());

        return translationEntryRepository.save(entity);
    }





}
