package ch.am.axa.backend.repository;

import ch.am.axa.backend.entity.TranslationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Alexander Margraf
 * @version : 18.08.2022
 */

@Repository
public interface TranslationRepository extends CrudRepository<TranslationEntity, String> {
}
