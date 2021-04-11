package com.example.custombutton.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PokemonProfile (

    @Expose
    @SerializedName("height")
    val height: String? = null,

    @Expose
    @SerializedName("name")
    val name: String? = null,

    @Expose
    @SerializedName("id")
    val id: String? = null
){
        override fun toString(): String {
            return "User(name=$name height=$height id=$id)"
        }
}

