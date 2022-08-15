package ch.am.axa.backend.repository;

import ch.am.axa.backend.entity.ApplikationEntity;
import ch.am.axa.backend.entity.Language;
import ch.am.axa.backend.entity.TranslationEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TranslationEntryRepository extends CrudRepository<TranslationEntry, String> {
    //List<TranslationEntry> findAllByText_id(String text_id);
    //public void deleteByTextAndLang_idfsAndApp_idfs(String text, Language lang_idfs, ApplikationEntity app_idfs);
}
