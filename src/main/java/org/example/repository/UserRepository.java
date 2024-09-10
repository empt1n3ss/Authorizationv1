package org.example.repository;

import org.example.model.Authorities;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        if ("admin".equals(user)|| "admin_password".equals(password)) {
            List<Authorities> authorities = new ArrayList<>();
            authorities.add(Authorities.READ);
            authorities.add(Authorities.WRITE);
            authorities.add(Authorities.DELETE);
            return authorities;
        } else if("user".equals(user)|| "password".equals(password)){
            List<Authorities> authorities = new ArrayList<>();
            authorities.add(Authorities.READ);
            return authorities;
        }
        return new ArrayList<>();
    }
}
