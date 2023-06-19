package com.example

import com.example.myapplication.data.model.InfoResponse
import com.example.myapplication.data.model.LocationResponse
import com.example.myapplication.data.model.OriginResponse
import com.example.myapplication.data.model.ResultResponse
import com.example.myapplication.domain.model.Characters

object CharactersFactory {

    fun mockCharacters(): Characters {
        val infoResponse = InfoResponse(1,
            "next", 1, 2)
        val result = ResultResponse("created", listOf(""), "gender", 1,
            "image", location = LocationResponse("name", "url"), "name",
            origin = OriginResponse("name", "url"), "species", "status", "type", "url")

        val listResult = listOf(result)

        return Characters(infoResponse, listResult)
    }
}