package io.erikrios.github.kotlinrestfulapi.model

import java.util.*

data class ProductResponse(

    val id: String,

    val name: String,

    val price: Long,

    val quantity: Int,

    val createdAt: Date,

    val updatedAt: Date?
)
