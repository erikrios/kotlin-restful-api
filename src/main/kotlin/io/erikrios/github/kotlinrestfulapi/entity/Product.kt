package io.erikrios.github.kotlinrestfulapi.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "products")
data class Product(
    @Id
    val id: String,

    @Column(name = "name")
    val name: String,

    @Column(name = "price")
    val price: Long,

    @Column(name = "quantity")
    val quantity: Int,

    @Column(name = "created_at")
    val createdAt: Date,

    @Column(name = "updated_at")
    val updatedAt: Date?
)
