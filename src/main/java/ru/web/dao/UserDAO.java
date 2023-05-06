package ru.web.dao;

import ru.web.models.User;

import java.util.List;

public interface UserDAO {
    public List<User> index();

    public User show(int id);

    public void save(User user);

    public void update(int id, User updatedUser);

    public void delete(int id);
}
