package ch.am.axa.backend.entity;

import ch.am.axa.backend.repository.ApplikationRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="translationentry")
@IdClass(TranslationKey.class)
public class TranslationEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "text_id", nullable = false)
    private String text_id;

    @Column(name = "content", nullable = false)
    private String content;


    @Id
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "lang_idfs", nullable = false)
    private Language lang_idfs;

    @Id
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "app_idfs", nullable = false)
    private ApplikationEntity app_idfs;


    public TranslationEntry() {
    }

    public String getText_id() {
        return text_id;
    }

    public void setText_id(String text_id) {
        this.text_id = text_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Language getLang_idfs() {
        return lang_idfs;
    }

    public void setLang_idfs(Language lang_idfs) {
        this.lang_idfs = lang_idfs;
    }

    public ApplikationEntity getApp_idfs() {
        return app_idfs;
    }

    public void setApp_idfs(ApplikationEntity app_idfs) {
        this.app_idfs = app_idfs;
    }
}
