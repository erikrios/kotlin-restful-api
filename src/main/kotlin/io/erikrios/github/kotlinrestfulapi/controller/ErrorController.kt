package io.erikrios.github.kotlinrestfulapi.controller

import io.erikrios.github.kotlinrestfulapi.model.WebResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorController {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException): WebResponse<String> {
        return WebResponse(
            code = HttpStatus.BAD_REQUEST.value(),
            status = HttpStatus.BAD_REQUEST.name,
            data = constraintViolationException.message.toString()
        )
    }
}