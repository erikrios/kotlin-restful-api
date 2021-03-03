package io.erikrios.github.kotlinrestfulapi.controller

import io.erikrios.github.kotlinrestfulapi.model.*
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

    @PutMapping(
        value = ["/api/products/{idProduct}"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateProduct(
        @PathVariable("idProduct") id: String,
        @RequestBody body: UpdateProductRequest
    ): WebResponse<ProductResponse> {
        val productResponse = productService.update(id, body)
        return WebResponse(
            code = HttpStatus.OK.value(),
            status = HttpStatus.OK.reasonPhrase,
            data = productResponse
        )
    }

    @DeleteMapping(
        value = ["/api/products/{idProduct}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteProduct(@PathVariable("idProduct") id: String): WebResponse<String> {
        val message = productService.delete(id)
        return WebResponse(
            code = HttpStatus.OK.value(),
            status = HttpStatus.OK.reasonPhrase,
            data = message
        )
    }

    @GetMapping(
        value = ["/api/products"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun listProducts(
        @RequestParam(value = "size", defaultValue = "10") size: Int,
        @RequestParam(value = "page", defaultValue = "0") page: Int
    ): WebResponse<List<ProductResponse>> {
        val products = productService.list(ListProductRequest(page, size))
        return WebResponse(
            code = HttpStatus.OK.value(),
            status = HttpStatus.OK.reasonPhrase,
            data = products
        )
    }
}