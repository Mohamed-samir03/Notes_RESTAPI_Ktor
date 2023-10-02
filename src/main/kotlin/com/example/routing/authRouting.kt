package com.example.routing

import com.example.db.DatabaseConnection
import com.example.entities.UsersEntity
import com.example.models.NoteResponse
import com.example.models.Users
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.dsl.*

fun Application.authRouting(){

    val db = DatabaseConnection.database

    routing {

        post("/register"){

            val user = call.receive<Users>()

            if (!user.validLength()){
                call.respond(HttpStatusCode.BadRequest, NoteResponse(false,"userName or password not valid"))
                return@post
            }

            val userName = user.userName.toLowerCase()
            val password = user.encryptPassword()

            val userValidation = db.from(UsersEntity)
                .select()
                .where(UsersEntity.userName eq userName)
                .map {
                    it[UsersEntity.userName]
                }.firstOrNull()

            if (userValidation != null){
                call.respond(HttpStatusCode.BadRequest, NoteResponse(false,"user already exists"))
                return@post
            }

            db.insert(UsersEntity){
                set(it.userName,userName)
                set(it.password,password)
            }

            call.respondText { "Register Success" }

        }

    }

}