package com.kodekita.codelabs.domain.usecase

import com.kodekita.codelabs.data.repository.UserRepository

class UserDataUseCase(private val repository: UserRepository) {
    fun getData() = repository.getData()
}