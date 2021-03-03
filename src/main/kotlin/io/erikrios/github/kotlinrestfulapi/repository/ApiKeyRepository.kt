package io.erikrios.github.kotlinrestfulapi.repository

import io.erikrios.github.kotlinrestfulapi.entity.ApiKey
import org.springframework.data.jpa.repository.JpaRepository

interface ApiKeyRepository : JpaRepository<ApiKey, String>