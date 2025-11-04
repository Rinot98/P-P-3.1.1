package org.rinot98.spring.spring_boot.dao;

import org.rinot98.spring.spring_boot.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUserById(int id);

    public void deleteUser(int id);

    public void updateUser(User updatedUser);
}
