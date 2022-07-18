package ch.am.axa.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="translationentry")
public class TranslationEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "text_id", nullable = false)
    private String text_id;

    @Column(name = "content", nullable = false)
    private String content;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lang_idfs", nullable = false)
    private Language lang_idfs;


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
}
