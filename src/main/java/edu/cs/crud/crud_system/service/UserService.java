package edu.cs.crud.crud_system.service;

import edu.cs.crud.crud_system.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
    User findByEmailAndPassword(String email,String password);
}
