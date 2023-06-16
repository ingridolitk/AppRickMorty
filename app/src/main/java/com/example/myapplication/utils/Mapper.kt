package com.example.myapplication.utils

interface Mapper<S,T> {
    fun map(source: S): T
}