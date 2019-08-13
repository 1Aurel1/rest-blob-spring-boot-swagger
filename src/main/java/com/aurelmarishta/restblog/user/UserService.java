package com.aurelmarishta.restblog.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    Page<User> findAllUserSPageable(Pageable pageable);

    List<User> findAllUsers();

    User getOneById(long id);

    User getOneByUsername(String username);

}
