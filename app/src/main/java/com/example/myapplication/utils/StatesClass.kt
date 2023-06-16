package com.example.myapplication.utils

import com.example.myapplication.data.model.ResultResponse

sealed class StatesClass {
    class Success(val character: List<ResultResponse>?) : StatesClass()
    class ServerError(val message: String? = null) : StatesClass()
    class Loading: StatesClass()
    class Empty: StatesClass()
}