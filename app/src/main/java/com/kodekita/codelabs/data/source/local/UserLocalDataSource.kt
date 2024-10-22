package com.kodekita.codelabs.data.source.local

import com.kodekita.codelabs.data.source.remote.model.UserItem

class UserLocalDataSource {
    fun getData(): String {
        return "Data from LocalDataSource"
    }

    val mockUserItem = listOf(
        UserItem(
            id = 1,
            name = "John Doe",
            email = "john_doe@yopmail.com",
            avatar = "https://randomuser.me/api/portraits",
            job = "Software Engineer",
            createdAt = "2021-08-01",
            updatedAt = "2021-08-01",
        ),
        UserItem(
            id = 2,
            name = "John Doe 2",
            email = "john_doe2@yopmail.com",
            avatar = "https://randomuser.me/api/portraits",
            job = "Software Engineer 2",
            createdAt = "2021-08-01",
            updatedAt = "2021-08-01",
        ),
    )
}