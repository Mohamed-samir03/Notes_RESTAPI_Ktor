package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class NoteResponse<T>(
    val status:Boolean,
    val data:T
)
