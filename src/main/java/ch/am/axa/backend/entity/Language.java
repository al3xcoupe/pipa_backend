package ch.am.axa.backend.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lang_id", nullable = false)
    private String lang_id;

    @Column(name = "lang_name", nullable = false)
    private String lang_name;

    @Column(name = "lang_name_en", nullable = false)
    private String lang_name_en;

    @JsonIgnore
    @OneToMany(mappedBy = "lang_idfs")
    private Set<TranslationEntry> translationEntries = new LinkedHashSet<>();

    public Language(){

    }

    public String getLang_id() {
        return lang_id;
    }

    public void setLang_id(String lang_id) {
        this.lang_id = lang_id;
    }

    public String getLang_name() {
        return lang_name;
    }

    public void setLang_name(String lang_name) {
        this.lang_name = lang_name;
    }

    public String getLang_name_en() {
        return lang_name_en;
    }

    public void setLang_name_en(String lang_name_en) {
        this.lang_name_en = lang_name_en;
    }

    public Set<TranslationEntry> getTranslationEntries() {
        return translationEntries;
    }

    public void setTranslationEntries(Set<TranslationEntry> translationEntries) {
        this.translationEntries = translationEntries;
    }
}
