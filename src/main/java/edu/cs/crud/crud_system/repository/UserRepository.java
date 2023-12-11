package edu.cs.crud.crud_system.repository;

import edu.cs.crud.crud_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmailAndPassword(String email,String password);
}
