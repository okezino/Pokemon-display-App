package com.example.custombutton.model

data class PokemonPojo(
    var count:Int,
    var next:String?,
    var previous:String?,
    var results:ArrayList<Results>
)