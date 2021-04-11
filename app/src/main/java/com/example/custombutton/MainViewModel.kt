package com.example.custombutton

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.custombutton.api.MyRetrofitBuilder
import com.example.custombutton.model.PokemonPojo
import com.example.custombutton.model.PokemonProfile
import com.example.custombutton.model.PostData
import com.example.custombutton.model.dataPokemon.PokemonData
import com.example.custombutton.repository.Mainrepository
import okhttp3.MultipartBody

class MainViewModel : ViewModel(){


    /**
     * Return the Pokemon Datafor each particular pokemon Call to populate the second Fragment
     */

    fun getPokemonData(_userId: String) : LiveData<PokemonData>{
        return Mainrepository.getPokemonData(_userId)
    }

    fun cancelJob(){
        Mainrepository.canceljob()
    }

    /**
     * Returns Live data for the Pokemojo use to set the First Data on the UI
     */
  fun getData(): LiveData<PokemonPojo> {
         return  Mainrepository.getallPokemon()
  }

    /**
     * Return Live data using
     * @param limit use to set the size of the data
     * @param offset use to set the Initial value to start with on thw list of PokemonPojo
     */
  fun getNextdata(limit: Int, offset : Int)  : LiveData<PokemonPojo>{
      return  Mainrepository.getNextPage(limit,offset)
  }

    /**
     * Return Live data using
     * @param img from the  fragment
     */

    fun uploadImage(img : MultipartBody.Part) : LiveData<PostData>{
        return Mainrepository.uploadImage(img)
    }



}