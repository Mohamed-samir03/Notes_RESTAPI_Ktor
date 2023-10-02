package com.example.routing

import com.example.db.DatabaseConnection
import com.example.entities.NotesEntity
import com.example.models.NoteRequest
import com.example.models.NoteResponse
import com.example.models.Notes
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.dsl.*


fun Application.notesRouting(){

    val db = DatabaseConnection.database

    routing {

        get("/notes"){

            val notes = db.from(NotesEntity).select()
                .map {
                    val id = it[NotesEntity.id]
                    val note = it[NotesEntity.note]
                    Notes(id ?: -1,note ?: "")
                }
            call.respond(notes)

        }

        post("/notes"){

            val request = call.receive<NoteRequest>()
            val result = db.insert(NotesEntity){
                set(it.note,request.note)
            }

            if (result == 1){
                call.respond(HttpStatusCode.OK,NoteResponse(true,"note insert success"))
            }else{
                call.respond(HttpStatusCode.BadRequest,NoteResponse(false,"failed insert"))
            }

        }

        get("/notes/{id}"){

            val id = call.parameters["id"]?.toInt() ?: -1

            val note = db.from(NotesEntity)
                .select()
                .where(NotesEntity.id eq id)
                .map {
                    val id = it[NotesEntity.id]!!
                    val note = it[NotesEntity.note]!!
                    Notes(id,note)
                }.firstOrNull()

            if (note == null){
                call.respond(HttpStatusCode.NotFound,NoteResponse(false,"note not found"))
            }else{
                call.respond(HttpStatusCode.OK,NoteResponse(true,note))
            }

        }

    }
}