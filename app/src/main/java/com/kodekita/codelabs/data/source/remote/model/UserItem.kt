package com.kodekita.codelabs.data.source.remote.model

import com.kodekita.codelabs.domain.model.UserData

data class UserItem(
    val id: Int?,
    val name: String?,
    val email: String?,
    val avatar: String?,
    val job: String?,
    val createdAt: String?,
    val updatedAt: String?,
){
    fun toUserData() = UserData(
        id = id ?: 0,
        name = name ?: "",
        email = email ?: "",
        avatar = avatar ?: "",
        job = job ?: "",
        createdAt = createdAt ?: "",
        updatedAt = updatedAt ?: "",
    )
}