package io.erikrios.github.kotlinrestfulapi.auth

import io.erikrios.github.kotlinrestfulapi.error.UnauthorizedException
import io.erikrios.github.kotlinrestfulapi.repository.ApiKeyRepository
import org.springframework.stereotype.Component
import org.springframework.ui.ModelMap
import org.springframework.web.context.request.WebRequest
import org.springframework.web.context.request.WebRequestInterceptor

@Component
class ApiKeyInterceptor(val apiKeyRepository: ApiKeyRepository) : WebRequestInterceptor {
    override fun preHandle(request: WebRequest) {
        val apiKey = request.getHeader("Api-Key")
        apiKey?.let {
            if (!apiKeyRepository.existsById(it))
                throw UnauthorizedException("Permission denied. Api key not valid.")
        }
            ?: throw UnauthorizedException("Permission denied. Api key not provided. Please put API-KEY in request headers.")
    }

    override fun postHandle(request: WebRequest, model: ModelMap?) {
        // nothing
    }

    override fun afterCompletion(request: WebRequest, ex: Exception?) {
        // nothing
    }
}