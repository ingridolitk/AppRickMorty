package com.example.myapplication.home.data.model

data class CharactersResponse(
    val info: InfoResponse,
    val results: List<ResultResponse>
)