package com.example.roomdemo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.roomdemo.db.RoomAppDb
import com.example.roomdemo.db.UserEntity

class MainActivityViewHolder(app :Application):AndroidViewModel(app) {

    lateinit var allUser: MutableLiveData<List<UserEntity>>

    init {
        allUser = MutableLiveData()
        getAllUsers()
    }

    fun getAllUserObservers():MutableLiveData<List<UserEntity>> {
        return allUser
    }

    fun getAllUsers(){
        val userDao = RoomAppDb.getAppDatabase((getApplication()))?.userDao()
        val list = userDao?.getAllUserInfo()


        allUser.postValue(list)
    }

    fun insertUserInfo(entity: UserEntity){
        val userDao = RoomAppDb.getAppDatabase((getApplication()))?.userDao()
        val list = userDao?.insertUser(entity)
        getAllUsers()
    }

    fun updateUserInfo(entity: UserEntity){
        val userDao = RoomAppDb.getAppDatabase((getApplication()))?.userDao()
        val list = userDao?.updateUser(entity)
        getAllUsers()
    }

    fun deleteUserInfo(entity: UserEntity){
        val userDao = RoomAppDb.getAppDatabase((getApplication()))?.userDao()
        val list = userDao?.deleteUser(entity)
        getAllUsers()
    }

}