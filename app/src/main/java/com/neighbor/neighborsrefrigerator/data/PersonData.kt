package com.neighbor.neighborsrefrigerator.data

import java.util.*

data class PersonData(
    val uId: Int,
    val fbUID: String,
    val email: String,
    val nickname: String,
    val homeAddr: String,
    val reportPoint: Int = 0,
    val createdAt: Date
)
