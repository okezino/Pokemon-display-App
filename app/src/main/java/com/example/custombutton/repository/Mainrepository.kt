package com.example.custombutton.repository

import androidx.lifecycle.LiveData
import com.example.custombutton.api.MyRetrofitBuilder
import com.example.custombutton.model.PokemonPojo
import com.example.custombutton.model.PokemonProfile
import com.example.custombutton.model.PostData
import com.example.custombutton.model.Results
import com.example.custombutton.model.dataPokemon.PokemonData
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import okhttp3.MultipartBody

object Mainrepository {
        var task : CompletableJob? = null

    /**
     * getallPokemon() func, Triggers  the network call and returns a Live Data of the PokemonPojo Class
     *
     * An instance of a CompletableJob  is a created to track the Thread created by the Coroutine
     *
     */

    fun getallPokemon() : LiveData<PokemonPojo> {
           task = Job()
        return object : LiveData<PokemonPojo>(){
            override fun onActive() {
                super.onActive()
                task?.let {
                    CoroutineScope(IO + it).launch {
                        val allPokemon = MyRetrofitBuilder.apiService.getAllPokemon()

                        withContext(Main){
                            value = allPokemon
                            it.complete()
                        }
                    }
                }
            }
        }
    }

    /**
     * getPokemonData() func, Triggers  the network call and returns a Live Data of the PokemonData Class with UserId of the pokemon
     *@param userId
     * An instance of a CompletableJob  is a created to track the Thread created by the Coroutine
     *
     */

    fun getPokemonData(userId : String) : LiveData<PokemonData>{

        task = Job()

        return object : LiveData<PokemonData>(){

            override fun onActive() {
                super.onActive()
                task?.let {theTask ->

                    // Creating a Background  thread to make our network call

                    CoroutineScope(IO + theTask).launch {
                        val pokemonSingledata = MyRetrofitBuilder.apiService.getPokemonData(userId)

                        //Switching from the created Thread to the Main thread

                        withContext(Main){
                            value = pokemonSingledata
                            theTask.complete()
                        }
                    }

                }
            }

        }
    }

    /**
     * getNextPage() func, Triggers  the network call and returns a Live Data of the PokemonPojo Class
     *@param limit
     * @param offset
     *
     * With the limit set as 20, the offset paramete is passed by either a next or previous button call from the Ui
     * with the offset value, a list of PokemonPojo class is returned
     * An instance of a CompletableJob  is a created to track the Thread created by the Coroutine
     *
     */

    fun getNextPage(limit : Int, offset : Int): LiveData<PokemonPojo> {
        task = Job()

        return object : LiveData<PokemonPojo>(){
            override fun onActive() {
                super.onActive()

                task?.let {task ->

                        // Creating a Background  thread to make our network call
                    CoroutineScope(IO + task).launch {
                        val nextpage = MyRetrofitBuilder.apiService.getNextPage(limit, offset)

                        //Switching from the created Thread to the Main thread
                        withContext(Main){
                            value = nextpage

                            task.complete()
                        }
                    }

                }
            }
        }
    }

    /**
     * upload image from the Api
     * @param img this is the file from the view_model to return the LiveData
     */
    fun uploadImage(img : MultipartBody.Part) : LiveData<PostData>{
        task = Job()

        return object : LiveData<PostData>(){
            override fun onActive() {
                super.onActive()
                task?.let {task ->
                    CoroutineScope(Main + task).launch{
                       val  postResponse = MyRetrofitBuilder.postService.uploadToServer(img)


                        withContext(Main){
                            value = postResponse

                            task.complete()
                        }

                    }
                }
            }
        }

    }

    /**
     * Function to cancel Jobs
     */

       fun  canceljob(){
           task?.cancel()
       }
}