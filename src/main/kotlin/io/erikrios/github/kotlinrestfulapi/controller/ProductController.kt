package io.erikrios.github.kotlinrestfulapi.controller

import io.erikrios.github.kotlinrestfulapi.model.CreateProductRequest
import io.erikrios.github.kotlinrestfulapi.model.ProductResponse
import io.erikrios.github.kotlinrestfulapi.model.WebResponse
import io.erikrios.github.kotlinrestfulapi.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(val productService: ProductService) {

    @PostMapping(
        value = ["/api/products"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createProduct(@RequestBody body: CreateProductRequest): WebResponse<ProductResponse> {
        val productResponse = productService.create(body)

        return WebResponse<ProductResponse>(
            code = HttpStatus.OK.value(),
            status = HttpStatus.OK.name,
            data = productResponse
        )
    }
}