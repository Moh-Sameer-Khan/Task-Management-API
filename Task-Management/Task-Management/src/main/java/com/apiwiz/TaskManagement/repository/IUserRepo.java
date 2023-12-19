package com.apiwiz.TaskManagement.repository;

import com.apiwiz.TaskManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User, Integer> {

    User findFirstByUserEmail(String newEmail);
}
