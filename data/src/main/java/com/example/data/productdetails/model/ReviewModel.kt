package com.example.data.productdetails.model

data class ReviewModel(
    val rating: Int,
    val comment: String,
    val date: String,
    val reviewerName: String,
    val reviewerEmail: String
)