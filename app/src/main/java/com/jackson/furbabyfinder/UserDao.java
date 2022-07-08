package com.jackson.furbabyfinder;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert
    void registerUser(UserEntity userEntity);

    @Query("SELECT * from users where userId=(:userId) and password=(:password)")
    UserEntity login(String userId, String password);


    //Update Will go here


    //delete user will go here
    @Delete
    void deleteUser(UserEntity userEntity);
}
