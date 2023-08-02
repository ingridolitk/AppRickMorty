package com.example.myapplication.home.data.mapper

import com.example.myapplication.home.data.model.CharactersResponse
import com.example.myapplication.home.domain.model.Characters
import com.example.myapplication.utils.Mapper

class CharactersMapper : Mapper<CharactersResponse, Characters> {
    override fun map(source: CharactersResponse): Characters {
        return Characters(
            info = source.info,
            results = source.results
        )
    }
}