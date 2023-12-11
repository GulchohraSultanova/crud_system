package edu.cs.crud.crud_system.repository;

import edu.cs.crud.crud_system.model.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanRepository extends JpaRepository<Human,Long> {
}
