package io.erikrios.github.kotlinrestfulapi.repository

import io.erikrios.github.kotlinrestfulapi.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, String>