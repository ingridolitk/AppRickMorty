package com.example.myapplication.home.domain.model

import com.example.myapplication.home.data.model.InfoResponse
import com.example.myapplication.home.data.model.ResultResponse

data class Characters (
    val info: InfoResponse,
    val results: List<ResultResponse>
    )