package com.apiwiz.TaskManagement.repository;

import com.apiwiz.TaskManagement.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAdminRepo extends JpaRepository<Admin, Integer> {
    Optional<Admin> findFirstByAdminEmailAddress(String adminEmail);
}
