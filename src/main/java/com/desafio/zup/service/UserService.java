package com.desafio.zup.service;

import com.desafio.zup.model.UserModel;

import java.util.List;

public interface UserService {

    List<UserModel> getUsers();

    UserModel getUserById(Long id);

    UserModel insert(UserModel user);

    boolean updateUser(Long id, UserModel user);

    void deleteUser(Long userId);
}
