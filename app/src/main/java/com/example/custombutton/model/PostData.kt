package com.example.custombutton.model

data class PostData(
    val message: String,
    val payload: Payload,
    val status: Int
)

data class Payload(
    val downloadUri: String,
    val fileId: String,
    val fileName: String,
    val fileType: String,
    val uploadStatus: Boolean
)