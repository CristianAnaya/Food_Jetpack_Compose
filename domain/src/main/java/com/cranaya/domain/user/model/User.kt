package com.cranaya.domain.user.model

import com.cranaya.domain.address.model.Address
import com.cranaya.domain.auth.model.Rol
import com.google.gson.Gson
import java.io.Serializable
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class User(
    val id: String? = null,
    var name: String,
    var lastname: String,
    val email: String? = null,
    var phone: String,
    val password: String? = null,
    var image: String? = null,
    val roles: List<Rol>? = null,
    var address: Address? = null
): Serializable {
    fun toJson(): String = Gson().toJson(User(
        id,
        name,
        lastname,
        email,
        phone,
        password,
        if (!image.isNullOrBlank()) URLEncoder.encode(image, StandardCharsets.UTF_8.toString()) else "",
        roles?.map { rol -> Rol.fromJson(rol.toJson()) },
        address
    ))

    companion object {
        fun fromJson(data: String): User = Gson().fromJson(data, User::class.java)
    }

}
