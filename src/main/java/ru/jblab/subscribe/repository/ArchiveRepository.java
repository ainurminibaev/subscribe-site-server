package ru.jblab.subscribe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.jblab.subscribe.model.Archive;

/**
 * Created by ainurminibaev on 25.10.15.
 */
@Repository
public interface ArchiveRepository extends CrudRepository<Archive, Long> {
}
