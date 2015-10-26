package ru.jblab.subscribe.service;

import ru.jblab.subscribe.model.User;

/**
 * Created by ainurminibaev on 26.08.14.
 */
public interface UserService {

    User findUser(String login);

    User findOne(Long id);

}
