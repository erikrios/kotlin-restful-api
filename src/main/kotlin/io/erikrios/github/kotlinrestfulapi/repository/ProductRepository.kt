package io.erikrios.github.kotlinrestfulapi.repository

import io.erikrios.github.kotlinrestfulapi.entity.Products
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Products, String>