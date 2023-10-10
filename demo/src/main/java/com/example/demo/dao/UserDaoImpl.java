package com.example.demo.dao;


import com.example.demo.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void addUser(User user) {
        entityManager.persist(user);
    }


    public void deleteUser(Long id) {

        User user = getUser(id);
        entityManager.remove(user);
    }

    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    public void updateUser(User user) {

        entityManager.merge(user);
    }

    public User getUser(Long id) {

        return entityManager.find(User.class, id);
    }
}
