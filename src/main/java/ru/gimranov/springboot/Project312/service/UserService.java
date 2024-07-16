package ru.gimranov.springboot.Project312.service;

import ru.gimranov.springboot.Project312.model.User;

import java.util.List;

public interface UserService {
    List<User> readingAllUsers();

    User readUser(Long id);

    void saveUser(User user);

    void updateUser(Long id, User user);

    void deleteUser(Long id);
}
