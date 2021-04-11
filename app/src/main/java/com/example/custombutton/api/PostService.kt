package com.example.custombutton.api

import com.example.custombutton.model.PokemonPojo
import com.example.custombutton.model.PostData
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part


/**
 * Call to get the image
 */

interface PostService {

    @Multipart
    @POST("upload")
    suspend fun uploadToServer(@Part img : MultipartBody.Part) : PostData
}