package com.aurelmarishta.restblog.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepo;

    @Autowired
    UserServiceImpl (UserRepository theUserRepo){
        userRepo= theUserRepo;
    }

    @Override
    public Page<User> findAllUserSPageable(Pageable pageable) {
        return userRepo.findAll(pageable);
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public User getOneById(long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public User getOneByUsername(String username) {
        return userRepo.findByUsername(username).get();
    }
}
