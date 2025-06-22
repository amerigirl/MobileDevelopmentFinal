package com.example.mckerracherclassfinal

import java.io.Serializable

data class OrderItem(
    val name: String,
    val description: String,
    val price: Double,
    var quantity: Int,
    val imageRes: Int
): Serializable