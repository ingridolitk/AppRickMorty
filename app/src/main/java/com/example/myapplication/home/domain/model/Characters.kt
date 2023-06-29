package com.example.myapplication.home.domain.model

import com.example.myapplication.data.model.InfoResponse
import com.example.myapplication.data.model.ResultResponse

data class Characters (
    val info: InfoResponse,
    val results: List<ResultResponse>
    )