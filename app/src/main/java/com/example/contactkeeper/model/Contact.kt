package com.example.contactkeeper.model

import java.util.UUID

data class Contact(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val phone: String,
    val isFriend: Boolean
)
