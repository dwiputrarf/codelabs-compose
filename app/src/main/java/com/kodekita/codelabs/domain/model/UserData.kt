package com.kodekita.codelabs.domain.model

data class UserData(
    val id: Int,
    val name: String,
    val email: String,
    val avatar: String,
    val job: String,
    val createdAt: String,
    val updatedAt: String,
)