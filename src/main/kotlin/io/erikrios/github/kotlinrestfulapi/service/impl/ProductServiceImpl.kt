package io.erikrios.github.kotlinrestfulapi.service.impl

import io.erikrios.github.kotlinrestfulapi.entity.Product
import io.erikrios.github.kotlinrestfulapi.error.BadRequestException
import io.erikrios.github.kotlinrestfulapi.error.NotFoundException
import io.erikrios.github.kotlinrestfulapi.model.CreateProductRequest
import io.erikrios.github.kotlinrestfulapi.model.ProductResponse
import io.erikrios.github.kotlinrestfulapi.model.UpdateProductRequest
import io.erikrios.github.kotlinrestfulapi.repository.ProductRepository
import io.erikrios.github.kotlinrestfulapi.service.ProductService
import io.erikrios.github.kotlinrestfulapi.validation.ValidationUtil
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductServiceImpl(
    val productRepository: ProductRepository,
    val validationUtil: ValidationUtil
) : ProductService {

    override fun create(createProductRequest: CreateProductRequest): ProductResponse {
        validationUtil.validate(createProductRequest)

        val isProductAlreadyExists = productRepository.existsById(createProductRequest.id)
        if (isProductAlreadyExists)
            throw BadRequestException("Product with id ${createProductRequest.id} already exists.")

        val product = Product(
            id = createProductRequest.id,
            name = createProductRequest.name,
            price = createProductRequest.price,
            quantity = createProductRequest.quantity,
            createdAt = Date(),
            updatedAt = null
        )

        productRepository.save(product)

        return convertProductToProductResponse(product)
    }

    override fun get(id: String): ProductResponse {
        val product = productRepository.findByIdOrNull(id)
        product?.let {
            return convertProductToProductResponse(it)
        } ?: throw NotFoundException("Product with id $id not found.")
    }

    override fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse {
        validationUtil.validate(updateProductRequest)

        val product = productRepository.findByIdOrNull(id)
        product?.let {
            it.apply {
                name = updateProductRequest.name
                price = updateProductRequest.price
                quantity = updateProductRequest.quantity
                updatedAt = Date()
            }
            productRepository.save(it)
            return convertProductToProductResponse(it)
        } ?: throw NotFoundException("Product with id $id not found.")
    }

    private fun convertProductToProductResponse(product: Product): ProductResponse {
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