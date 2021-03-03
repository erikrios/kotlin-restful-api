package io.erikrios.github.kotlinrestfulapi.service.impl

import io.erikrios.github.kotlinrestfulapi.entity.Product
import io.erikrios.github.kotlinrestfulapi.model.CreateProductRequest
import io.erikrios.github.kotlinrestfulapi.model.ProductResponse
import io.erikrios.github.kotlinrestfulapi.repository.ProductRepository
import io.erikrios.github.kotlinrestfulapi.service.ProductService
import io.erikrios.github.kotlinrestfulapi.validation.ValidationUtil
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductServiceImpl(
    val productRepository: ProductRepository,
    val validationUtil: ValidationUtil
) : ProductService {

    override fun create(createProductRequest: CreateProductRequest): ProductResponse {
        validationUtil.validate(createProductRequest)

        val product = Product(
            id = createProductRequest.id,
            name = createProductRequest.name,
            price = createProductRequest.price,
            quantity = createProductRequest.quantity,
            createdAt = Date(),
            updatedAt = null
        )

        productRepository.save(product)

        return ProductResponse(
            id = product.id,
            name = product.name,
            price = product.price,
            quantity = product.quantity,
            createdAt = product.createdAt,
            updatedAt = product.updatedAt
        )
    }
}