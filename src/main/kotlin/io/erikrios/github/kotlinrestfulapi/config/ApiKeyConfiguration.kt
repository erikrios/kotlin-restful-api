package io.erikrios.github.kotlinrestfulapi.config

import io.erikrios.github.kotlinrestfulapi.entity.ApiKey
import io.erikrios.github.kotlinrestfulapi.repository.ApiKeyRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class ApiKeyConfiguration(val apiKeyRepository: ApiKeyRepository) : ApplicationRunner {

    private val apiKey = "SECRET"

    override fun run(args: ApplicationArguments?) {
        if (!apiKeyRepository.existsById(apiKey)) {
            val entity = ApiKey(apiKey)
            apiKeyRepository.save(entity)
        }
    }
}