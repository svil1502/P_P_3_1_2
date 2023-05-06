package ru.web.dao;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.web.models.User;

//import javax.persistence;


import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {
    private final EntityManager entityManager;

    @Autowired
    public UserDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<User> index() {
        return entityManager.createQuery("select p from User p", User.class)
                .getResultList();
    }


    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }


    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(int id, User updatedUser) {
        User userUpd = entityManager.find(User.class, id);
        userUpd.setName(updatedUser.getName());
        userUpd.setEmail(updatedUser.getEmail());
        entityManager.persist(userUpd);
    }

    @Override
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}


