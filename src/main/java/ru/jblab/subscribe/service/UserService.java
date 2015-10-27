package ru.jblab.subscribe.service;

import ru.jblab.subscribe.model.User;
import ru.jblab.subscribe.model.UserInfo;

import java.util.List;

/**
 * Created by ainurminibaev on 26.08.14.
 */
public interface UserService {

    User findUser(String login);

    User findOne(Long id);

    void save(UserInfo userInfo);

    List<UserInfo> getAllUserInfos();
}
