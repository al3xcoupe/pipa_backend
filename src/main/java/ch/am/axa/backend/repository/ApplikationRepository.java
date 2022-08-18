package ch.am.axa.backend.repository;

import ch.am.axa.backend.entity.ApplikationEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : Alexander Margraf
 * @version : 18.08.2022
 */
public interface ApplikationRepository extends CrudRepository<ApplikationEntity, String> {
}
