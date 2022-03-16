package com.aca.homework.week10.user.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserRepository implements CrudRepository<User> {

    private List<User> users = new ArrayList<>();

    @Override
    public User save(User entity) {
        if (entity == null)
            throw new IllegalArgumentException("Entity is null");

        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).equals(entity)) {
                users.set(i, entity);
                return entity;
            }
        }

        users.add(entity);
        return entity;
    }

    @Override
    public void delete(User entity) {
        if (entity == null)
            throw new IllegalArgumentException("Entity is null");

        Iterator<User> it = users.iterator();

        while (it.hasNext()) {
            if(it.next().equals(entity)) {
                it.remove();
                return;
            }
        }

        throw new UserNotFoundException(entity.getId());
    }

    @Override
    public User findById(Long id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public long count() {
        return users.size();
    }

    @Override
    public void deleteAll() {
        users.clear();
    }

    @Override
    public List<User> findAll() {
        return users;
    }
}
