package com.example.data.common.safecall
import com.example.domain.result.Success
import com.example.domain.result.Failure
import com.example.domain.result.Result

inline fun <T> safeApiCall(
    caller: String,
    className: String,
    block: () -> T?
): Result<T> {
    return try {
        Success(block() ?: throw IllegalStateException("API returned null"))
    } catch (e: Exception) {
        Failure("[$className::$caller] An unexpected error occurred: ${e.message}")
    }
}