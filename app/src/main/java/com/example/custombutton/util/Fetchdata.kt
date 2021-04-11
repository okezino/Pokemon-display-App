package com.example.custombutton.util

import androidx.core.text.isDigitsOnly

object Fetchdata  {

    /**
     * Logic to get the OffsetValue from the url
     * label@ substring(41..url.lastIndex) pick the String from the 41 index  till the Last
     * takeWhile { it != '&' }.toInt()  takes the String from @label pick each character and stop when it meets '&' and convert to Int
     *
     */

    fun getPageOffset(url : String) : Int{
        return url.substring(41..url.lastIndex).takeWhile { it != '&' }.toInt()
    }

    /**
     * Logic to get the Id of Pokemon from the Url
     * substring(34..url.lastIndex -1) take the strings from the 34th index till the index before the Last
     */

    fun getId(url : String) : String{
        return url.substring(34..url.lastIndex -1)
    }

    fun validOffsetInput(value : String) : Boolean{
        return !(value == "0" || value == "")
    }


}