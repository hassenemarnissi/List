package com.example.domain.result

sealed class Result<out T>
class Success<T>(val value: T) : Result<T>()
class Failure(val message: String? = null) : Result<Nothing>()