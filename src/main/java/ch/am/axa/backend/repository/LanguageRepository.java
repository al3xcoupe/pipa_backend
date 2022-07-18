package ch.am.axa.backend.repository;

import ch.am.axa.backend.entity.Language;
import org.springframework.data.repository.CrudRepository;

public interface LanguageRepository extends CrudRepository<Language, String> {
}
