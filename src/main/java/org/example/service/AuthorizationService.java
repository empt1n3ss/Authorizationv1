package org.example.service;

import org.example.model.Authorities;
import org.example.model.InvalidCredentials;
import org.example.model.UnauthorizedUser;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {
    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        String username = user.getUser();
        String password = user.getPassword();
        if (isEmpty(username) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(username, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + username);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> list) {
        return list == null || list .isEmpty();
    }

}