package ch.am.axa.backend.service;


import ch.am.axa.backend.entity.*;
import ch.am.axa.backend.repository.ApplikationRepository;
import ch.am.axa.backend.repository.LanguageRepository;
import ch.am.axa.backend.repository.TranslationEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@CrossOrigin
public class DataService {

    private final ApplikationRepository applikationRepository;

    private final LanguageRepository languageRepository;

    private final TranslationEntryRepository translationEntryRepository;

    @Autowired
    public DataService(ApplikationRepository applikationRepository,LanguageRepository languageRepository, TranslationEntryRepository translationEntryRepository) {
        this.applikationRepository = applikationRepository;
        this.languageRepository = languageRepository;
        this.translationEntryRepository = translationEntryRepository;
    }

    public Iterable<Language> getAllLanguages(){return languageRepository.findAll();}

    public List<RestDataStructur> getAllTranslationEntrys(){
        List<RestDataStructur> data = new ArrayList<>();

        Iterable<TranslationEntry> translationEntries = translationEntryRepository.findAll();

        for(TranslationEntry e: translationEntries){

            RestDataStructur structur = new RestDataStructur();
            /*
            String id = e.getText_id();

            if(e.getLang_idfs().equals("4")){

                structur.setEntry(e);
            }
             */

            data.add(structur);
        }

        return data;
    }

    /*
    public List<RestDataStructur> getAllTranslationGermany(){

        List<RestDataStructur> structurList = new ArrayList<>();

        List<TranslationEntry> entries = new ArrayList<>();
        Iterable<TranslationEntry> translationEntries = translationEntryRepository.findAll();

        for(TranslationEntry e: translationEntries){
            if(e.getLang_idfs().getLang_id().equals("4")){
                entries.add(e);
            }
        }

        for(TranslationEntry e: entries){
            List<Language> languageList = new ArrayList<>();
            RestDataStructur structur = new RestDataStructur();

            structur.setEntry(e);

            List<TranslationEntry> entriesFromTextId = translationEntryRepository.findAllByText_id(e.getText_id());

            for(TranslationEntry entry: entriesFromTextId){
                languageList.add(entry.getLang_idfs());
            }

            structur.setLanguageList(languageList);

            structurList.add(structur);
        }

        return structurList;
    }

     */

    /*
    public Optional<Language> getLanguageByTextId(String id){
        return languageRepository.findById(id);
    }


    public Optional<TranslationEntry> getTranslationEntryById(String id){
        return translationEntryRepository.findById(id);
    }

    public void deleteTranslation(TranslationEntry entry){
        
        //translationEntryRepository.deleteByTextAndLang_idfsAndApp_idfs(entry.getText_id(), entry.getLang_idfs(), entry.getApp_idfs());
    }

    public void addTranslation(TranslationEntry entry){
        translationEntryRepository.save(entry);
    }
     */


}
