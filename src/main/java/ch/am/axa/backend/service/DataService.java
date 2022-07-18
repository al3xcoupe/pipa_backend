package ch.am.axa.backend.service;


import ch.am.axa.backend.entity.ApplikationEntity;
import ch.am.axa.backend.entity.Language;
import ch.am.axa.backend.entity.TranslationEntry;
import ch.am.axa.backend.repository.ApplikationRepository;
import ch.am.axa.backend.repository.LanguageRepository;
import ch.am.axa.backend.repository.TranslationEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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

    public Iterable<TranslationEntry> getAllTranslationEntrys(){return translationEntryRepository.findAll();}

    public Optional<Language> getLanguageById(String id){
        return languageRepository.findById(id);
    }

    public Optional<TranslationEntry> getTranslationEntryById(String id){
        return translationEntryRepository.findById(id);
    }



}
