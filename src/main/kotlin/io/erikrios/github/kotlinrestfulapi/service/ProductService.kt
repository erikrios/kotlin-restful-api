package io.erikrios.github.kotlinrestfulapi.service

import io.erikrios.github.kotlinrestfulapi.model.CreateProductRequest
import io.erikrios.github.kotlinrestfulapi.model.ProductResponse

interface ProductService {
    fun create(createProductRequest: CreateProductRequest): ProductResponse
}