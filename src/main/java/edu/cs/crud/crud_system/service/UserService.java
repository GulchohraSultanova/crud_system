package edu.cs.crud.crud_system.service;

import edu.cs.crud.crud_system.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getUserById(Long id);
    void createUser(User user);
    User findByEmailAndPassword(String email,String password);
}
