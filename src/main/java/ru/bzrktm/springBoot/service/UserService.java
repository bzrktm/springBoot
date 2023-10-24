package ru.bzrktm.springBoot.service;

import ru.bzrktm.springBoot.models.User;

import java.util.List;

public interface UserService {

    public User getById(Long id);

    public List<User> getUsers();

    public void add(User user);

    public void updateUser(long id, User updateUser);

    public void delete(long id);
}
