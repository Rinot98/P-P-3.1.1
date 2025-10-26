package org.rinot98.spring.spring_boot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.rinot98.spring.spring_boot.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {

        List<User> allUsers = em.createQuery("SELECT u FROM User u", User.class)
                .getResultList();

        return allUsers;
    }

    @Override
    public void saveUser(User user) {
        if (user.getId() != 0) {
            em.merge(user);
        } else {
            em.persist(user);
        }
    }

    @Override
    public User getUserById(int id) {

        User user = em.find(User.class, id);
        return user;
    }

    @Override
    public void deleteUser(int id) {
        User user = em.find(User.class, id);
        em.remove(user);
    }
}
