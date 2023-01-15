package ru.netology.restapplication.repository;

import org.springframework.stereotype.Repository;
import ru.netology.restapplication.model.Authorities;
import ru.netology.restapplication.model.User;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    ConcurrentHashMap<User, List<Authorities>> userAuthoritiesData;
    public UserRepository() {
        userAuthoritiesData = new ConcurrentHashMap<>();
        userAuthoritiesData.put(new User("Root", "qwerty12345"), List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
        userAuthoritiesData.put(new User("Writer", "BestWriter123"), List.of(Authorities.WRITE));
        userAuthoritiesData.put(new User("Reader", "StealthWriter"), List.of(Authorities.READ));
    }
    public List<Authorities> getUserAuthorities(String user, String password) {
        var userCredential = new User(user, password);
        return userAuthoritiesData.getOrDefault(userCredential, null);
    }

}
