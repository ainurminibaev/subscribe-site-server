package ru.jblab.subscribe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.jblab.subscribe.model.User;
import ru.jblab.subscribe.repository.UserRepository;
import ru.jblab.subscribe.service.UserService;

/**
 * Created by ainurminibaev on 26.08.14.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User findUser(String login) {
        return userRepository.findOneByLogin(login);
    }

    public User findOne(Long id) {
        return userRepository.findOne(id);
    }


}
