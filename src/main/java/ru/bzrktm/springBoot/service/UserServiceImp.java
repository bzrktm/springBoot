package ru.bzrktm.springBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bzrktm.springBoot.DAO.UserDAO;
import ru.bzrktm.springBoot.models.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User getById(Long id) {
        return userDAO.getById(id);
    }

    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    @Transactional
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    @Transactional
    public void updateUser(long id, User updateUser) {
        userDAO.updateUser(id, updateUser);
    }

    @Override
    @Transactional
    public void delete(long id) {
     userDAO.delete(id);
    }
}
