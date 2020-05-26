package com.project.gelingeducation.service;

import com.project.gelingeducation.domain.User;

public interface IRedisCacheService {

    User getUserById(long id) throws Exception;

    void saveUser(User user) throws Exception;
}