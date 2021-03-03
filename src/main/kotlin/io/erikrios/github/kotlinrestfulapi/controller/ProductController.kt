package io.erikrios.github.kotlinrestfulapi.controller

import io.erikrios.github.kotlinrestfulapi.model.CreateProductRequest
import io.erikrios.github.kotlinrestfulapi.model.ProductResponse
import io.erikrios.github.kotlinrestfulapi.model.WebResponse
import io.erikrios.github.kotlinrestfulapi.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
class ProductController(val productService: ProductService) {

    @PostMapping(
        value = ["/api/products"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createProduct(@RequestBody body: CreateProductRequest): WebResponse<ProductResponse> {
        val productResponse = productService.create(body)

        return WebResponse(
            code = HttpStatus.OK.value(),
            status = HttpStatus.OK.reasonPhrase,
            data = productResponse
        )
    }

    @GetMapping(
        value = ["/api/products/{idProduct}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getProduct(@PathVariable("idProduct") id: String): WebResponse<ProductResponse> {
        val productResponse = productService.get(id)

        return WebResponse(
            code = HttpStatus.OK.value(),
            status = HttpStatus.OK.reasonPhrase,
            data = productResponse
        )
    }
}