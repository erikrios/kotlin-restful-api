package io.erikrios.github.kotlinrestfulapi.model

data class CreateProductRequest(

    val id: String,

    val name: String,

    val price: Long,

    val quantity: Int
)
