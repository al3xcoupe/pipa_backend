package ch.am.axa.backend.entity;

import javax.persistence.*;
/**
 * @author : Alexander Margraf
 * @version : 18.08.2022
 */
@Entity
@Table(name = "translationentry")
public class TranslationEntity {

    @Id
    @Column(name = "text_id", nullable = false)
    private String text;

    @Column(name = "content_de", nullable = false)
    private String content_de;

    @Column(name = "content_fr", nullable = false)
    private String content_fr;

    @Column(name = "content_it", nullable = false)
    private String content_it;

    @Column(name = "content_en", nullable = false)
    private String content_en;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "app_idfs", nullable = false)
    private ApplikationEntity app_idfs;

    public TranslationEntity() {
    }

    public String getText_id() {
        return text;
    }

    public void setText_id(String text) {
        this.text = text;
    }

    public String getContent_de() {
        return content_de;
    }

    public void setContent_de(String content_de) {
        this.content_de = content_de;
    }

    public String getContent_fr() {
        return content_fr;
    }

    public void setContent_fr(String content_fr) {
        this.content_fr = content_fr;
    }

    public String getContent_it() {
        return content_it;
    }

    public void setContent_it(String content_it) {
        this.content_it = content_it;
    }

    public String getContent_en() {
        return content_en;
    }

    public void setContent_en(String content_en) {
        this.content_en = content_en;
    }

    public ApplikationEntity getApp_idfs() {
        return app_idfs;
    }

    public void setApp_idfs(ApplikationEntity app_idfs) {
        this.app_idfs = app_idfs;
    }
}

