package com.example.models

import kotlinx.serialization.Serializable
import org.mindrot.jbcrypt.BCrypt

@Serializable
data class Users(
    val userName:String,
    val password:String
){
    fun encryptPassword():String{
        return BCrypt.hashpw(password,BCrypt.gensalt())
    }

    fun validLength():Boolean{
        return userName.length >= 5 && password.length >= 7
    }

}
