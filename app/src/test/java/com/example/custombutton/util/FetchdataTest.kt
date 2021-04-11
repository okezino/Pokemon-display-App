package com.example.custombutton.util

import org.junit.Test

import org.junit.Assert.*

class FetchdataTest {

    var url = "https://pokeapi.co/api/v2/pokemon?offset=300&limit=100"
    var uritest = "https://pokeapi.co/api/v2/pokemon?offset=100&limit=100"
    var pokemon34 = "https://pokeapi.co/api/v2/ability/34/"
    var pokemon100 = "https://pokeapi.co/api/v2/ability/100/"
    var pokemon1000 = "https://pokeapi.co/api/v2/ability/1000/"
    var input1 = ""
    var input2 = "0"
    var input3 = "23"

    @Test
    fun getPageOffset() {

        assertEquals(300,Fetchdata.getPageOffset(url))
        assertEquals(100,Fetchdata.getPageOffset(uritest))
    }

    @Test
    fun getId() {
        assertEquals("34",Fetchdata.getId(pokemon34))
        assertEquals("100",Fetchdata.getId(pokemon100))
        assertEquals("1000",Fetchdata.getId(pokemon1000))
    }

    @Test
    fun validOffsetInput() {
        assertTrue(Fetchdata.validOffsetInput(input3))
        assertFalse(Fetchdata.validOffsetInput(input1))
        assertFalse(Fetchdata.validOffsetInput(input2))
    }
}