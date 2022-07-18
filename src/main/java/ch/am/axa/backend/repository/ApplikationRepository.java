package ch.am.axa.backend.repository;

import ch.am.axa.backend.entity.ApplikationEntity;
import org.springframework.data.repository.CrudRepository;

public interface ApplikationRepository extends CrudRepository<ApplikationEntity, String> {
}
