package com.files.repository;

import com.files.model.UserInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserInfo, Integer> {

    @Query("SELECT ud " +
            "FROM UserInfo ud " +
            "WHERE ud.userId = ?1 ")
    List<UserInfo> getDataForUserId(int userId);

    @Query("SELECT ud " +
            "FROM UserInfo ud " +
            "WHERE ud.profession = ?1 ")
    List<UserInfo> getDataForProfession(String profession);

    @Query("SELECT ud " +
            "FROM UserInfo ud ")
    List<UserInfo> getAllRows();

}
