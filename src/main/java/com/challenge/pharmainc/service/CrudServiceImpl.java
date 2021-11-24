package com.challenge.pharmainc.service;

import com.challenge.pharmainc.model.User;
import com.challenge.pharmainc.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CrudServiceImpl implements CrudService {

    private final String msg_challenge = "REST Back-end Challenge 20201209 Running";

    private final UserRepository userRepository;

    public CrudServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String message() {
        return msg_challenge;
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(
                ()->new RuntimeException("not found")
        );
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public List<User> saveAll(List<User> userList) {
        return userRepository.saveAll(userList);
    }
}
