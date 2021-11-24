package com.challenge.pharmainc.service;

import com.challenge.pharmainc.model.User;

import java.util.List;

public interface CrudService {

    public String message();

    public User updateUser(User user);

    public void deleteUser(User user);

    public User findById(Integer id);

    public List<User> findAll();

    public List<User> saveAll(List<User> userList);
}
