package io.erikrios.github.kotlinrestfulapi.service

import io.erikrios.github.kotlinrestfulapi.model.CreateProductRequest
import io.erikrios.github.kotlinrestfulapi.model.ListProductRequest
import io.erikrios.github.kotlinrestfulapi.model.ProductResponse
import io.erikrios.github.kotlinrestfulapi.model.UpdateProductRequest

interface ProductService {
    fun create(createProductRequest: CreateProductRequest): ProductResponse

    fun get(id: String): ProductResponse

    fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse

    fun delete(id: String): String

    fun list(listProductRequest: ListProductRequest): List<ProductResponse>
}