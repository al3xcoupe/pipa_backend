package ch.am.axa.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "application")
public class ApplikationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_id", nullable = false)
    private String app_id;

    @Column(name = "app_owner_email", nullable = false)
    private String app_owner_email;

    @JsonIgnore
    @OneToMany(mappedBy = "app_idfs")
    private Set<TranslationEntry> translationEntries = new LinkedHashSet<>();

    public ApplikationEntity() {
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getApp_owner_email() {
        return app_owner_email;
    }

    public void setApp_owner_email(String app_owner_email) {
        this.app_owner_email = app_owner_email;
    }

    public Set<TranslationEntry> getTranslationEntries() {
        return translationEntries;
    }

    public void setTranslationEntries(Set<TranslationEntry> translationEntries) {
        this.translationEntries = translationEntries;
    }
}
