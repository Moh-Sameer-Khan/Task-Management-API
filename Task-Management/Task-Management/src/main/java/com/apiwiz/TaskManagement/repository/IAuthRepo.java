package com.apiwiz.TaskManagement.repository;

import com.apiwiz.TaskManagement.model.AuthenticationToken;
import com.apiwiz.TaskManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthRepo extends JpaRepository<AuthenticationToken, Integer> {

    AuthenticationToken findFirstByTokenValue(String newTokenValue);

    AuthenticationToken findFirstByTokenOwner(User existingUser);
    @Query(value = "select token_id from token where token_user_id =:id AND token_user_type =:type", nativeQuery = true)
    Integer findToken(Integer id, String type);

    @Query(value = "select token_value from token where token_user_id =:adminId AND token_user_type =:userType", nativeQuery = true)
    String findTokenValueByTokenUserIdAndTokenUserType(Integer adminId, String userType);

}