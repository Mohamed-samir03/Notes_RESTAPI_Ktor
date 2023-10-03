package com.example.utils

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.example.models.User
import io.ktor.server.config.*

class TokenManager(
    val config:HoconApplicationConfig
) {

    fun generateJWT(user:User):String{

        val secret = config.property("secret").getString()
        val issuer = config.property("issuer").getString()
        val audience = config.property("audience").getString()

        val token = JWT.create()
            .withAudience(audience)
            .withIssuer(issuer)
            .withClaim("username", user.userName)
            .withClaim("id", user.id)
            .sign(Algorithm.HMAC256(secret))

        return token

    }

}