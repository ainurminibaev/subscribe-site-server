package ru.jblab.subscribe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.jblab.subscribe.model.User;

import java.util.List;

/**
 * Created on 26.08.2014.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByNameIgnoreCaseContaining(String term);

    User findOneByLogin(String login);

}
