package com.example.entities

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object UsersEntity:Table<Nothing>(tableName = "users") {

    val id = int(name = "id").primaryKey()

    val userName = varchar(name = "userName")

    val password = varchar(name = "password")

}