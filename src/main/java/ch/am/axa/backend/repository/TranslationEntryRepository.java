package ch.am.axa.backend.repository;

import ch.am.axa.backend.entity.TranslationEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TranslationEntryRepository extends CrudRepository<TranslationEntry, String> {
    List<TranslationEntry> findAllByText(String text);
}
