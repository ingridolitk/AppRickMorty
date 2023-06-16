package com.example.myapplication.data.model

sealed class ApiResult {
    class Success(val result: List<ResultResponse>?) : ApiResult()
    class ServerError(val message: String? = null) : ApiResult()
}