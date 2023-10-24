package ru.bzrktm.springBoot.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import ru.bzrktm.springBoot.models.User;

import java.util.List;

@Repository
public class UserDAOImp implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getUsers() {
        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(long id, User updateUser) {
        User userToBeUpdated  = getById(id);
        userToBeUpdated.setName(updateUser.getName());
        userToBeUpdated.setLastName(updateUser.getLastName());
        userToBeUpdated.setAge(updateUser.getAge());
        entityManager.merge(userToBeUpdated);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(getById(id));
    }

}
