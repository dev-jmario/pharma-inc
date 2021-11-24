package com.challenge.pharmainc.service;

import com.challenge.pharmainc.model.User;
import com.challenge.pharmainc.model.random.RandomUser;

import java.util.List;

public interface RandomUserService {

    public RandomUser importRandomUsers();

    public List<User> convertRandomUser(RandomUser randomUser);

}
