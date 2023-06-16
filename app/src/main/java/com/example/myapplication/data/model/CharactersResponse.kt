package com.example.myapplication.data.model

data class CharactersResponse(
    val info: InfoResponse,
    val results: List<ResultResponse>
)