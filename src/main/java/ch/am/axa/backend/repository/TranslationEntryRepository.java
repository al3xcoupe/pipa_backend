package ch.am.axa.backend.repository;

import ch.am.axa.backend.entity.TranslationEntry;
import org.springframework.data.repository.CrudRepository;

public interface TranslationEntryRepository extends CrudRepository<TranslationEntry, String> {
}
