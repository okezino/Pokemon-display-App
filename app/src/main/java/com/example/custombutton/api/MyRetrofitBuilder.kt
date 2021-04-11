package com.example.custombutton.api

import com.example.custombutton.util.Const
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


/**
 * Creating a singleton of the Retrofit Object that is use to make the Network calls
 */

object MyRetrofitBuilder {

    val retrofitBuilder : Retrofit.Builder by lazy {
        Retrofit.Builder().baseUrl(Const.BASE_URL).addConverterFactory(GsonConverterFactory.create())
    }

    private val retrofitBuilder2 : Retrofit.Builder by lazy {
        Retrofit.Builder().baseUrl(Const.POST_URL).addConverterFactory(GsonConverterFactory.create())
    }

    val apiService : ApiService by lazy {
      retrofitBuilder.build()
          .create(ApiService::class.java)
    }

    val postService : PostService by lazy {
        retrofitBuilder2.build()
                .create(PostService::class.java)
    }
}

