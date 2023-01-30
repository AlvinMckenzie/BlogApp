package com.codeup.serviceimplementation;

import com.codeup.models.User;
import com.codeup.repository.UserRepository;
import com.codeup.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository usersDao;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImp(UserRepository usersDao, PasswordEncoder passwordEncoder) {
        this.usersDao = usersDao;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(User user) {

        String hash = passwordEncoder.encode(user.getPassword());

        user.setPassword(hash);
        usersDao.save(user);

    }

}
