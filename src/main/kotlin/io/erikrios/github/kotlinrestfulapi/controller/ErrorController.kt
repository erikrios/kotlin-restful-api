package io.erikrios.github.kotlinrestfulapi.controller

import io.erikrios.github.kotlinrestfulapi.error.BadRequestException
import io.erikrios.github.kotlinrestfulapi.error.NotFoundException
import io.erikrios.github.kotlinrestfulapi.error.UnauthorizedException
import io.erikrios.github.kotlinrestfulapi.model.WebResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException): WebResponse<String> {
        return WebResponse(
            code = HttpStatus.BAD_REQUEST.value(),
            status = HttpStatus.BAD_REQUEST.reasonPhrase,
            data = constraintViolationException.message.toString()
        )
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = [NotFoundException::class])
    fun notFound(notFoundException: NotFoundException): WebResponse<String> {
        return WebResponse(
            code = HttpStatus.NOT_FOUND.value(),
            status = HttpStatus.NOT_FOUND.reasonPhrase,
            data = notFoundException.message.toString()
        )
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = [BadRequestException::class])
    fun badRequest(badRequestException: BadRequestException): WebResponse<String> {
        return WebResponse(
            code = HttpStatus.BAD_REQUEST.value(),
            status = HttpStatus.BAD_REQUEST.reasonPhrase,
            data = badRequestException.message.toString()
        )
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = [UnauthorizedException::class])
    fun unauthorized(unauthorizedException: UnauthorizedException): WebResponse<String> {
        return WebResponse(
            code = HttpStatus.UNAUTHORIZED.value(),
            status = HttpStatus.UNAUTHORIZED.reasonPhrase,
            data = unauthorizedException.message
        )
    }
}