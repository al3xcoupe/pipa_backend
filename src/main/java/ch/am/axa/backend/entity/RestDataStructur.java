package ch.am.axa.backend.entity;

import java.util.List;

public class RestDataStructur {

    private TranslationEntry entry;
    private List<Language> languageList;

    public RestDataStructur() {
    }

    public TranslationEntry getEntry() {
        return entry;
    }

    public void setEntry(TranslationEntry entry) {
        this.entry = entry;
    }

    public List<Language> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(List<Language> languageList) {
        this.languageList = languageList;
    }
}
