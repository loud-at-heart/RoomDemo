package com.example.roomdemo.db

import androidx.room.*

@Dao
interface UserDao {

    @Query("SELECT * FROM userinfo ORDER BY id ASC")
    fun getAllUserInfo() : List<UserEntity>

    @Insert
    fun insertUser(user: UserEntity?)

    @Delete
    fun deleteUser(user: UserEntity?)

    @Update
    fun updateUser(user: UserEntity?)

}