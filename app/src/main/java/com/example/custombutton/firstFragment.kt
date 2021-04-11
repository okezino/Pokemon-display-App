package com.example.custombutton

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.custombutton.util.Fetchdata
import kotlinx.android.synthetic.main.fragment_blank.*
import kotlinx.android.synthetic.main.fragment_blank.view.*

/**
 * This is the Home Fragment that display all the Pokemon Characters
 * Declaration of all Variables needed
 * Viewmodel to call lifedata
 * nextPokemonPage  is  the offset number for the Next Page
 * prevPokemonPage  is the offset number for Previous Pokemon Page
 * limit this gives the current limit of pokemon to be displayed on the screen
 * offset this gives the current offset of the pokemon data
 */

class FirstFragment : Fragment(),PokemonClick {

    lateinit var Viewmodel : MainViewModel
             var nextPokemonPage : Int? = null
             var prevPokemonPage : Int? = null
             var limit : Int = 20
             var offset : Int = 0



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * calling the instance of the View_model to get All pokemonPojo data
         * and inflating the data to the RecyclerView instance created
         *
         * Set the offset of the next and Previous page keeping the limit constant at 20 unless  its change from the UI
         */

        Viewmodel = ViewModelProvider(this).get(MainViewModel::class.java)
        Viewmodel.getData().observe(viewLifecycleOwner, Observer {

            recyclerView.adapter = RecyclerAdapter(it.results,this)
            recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)


            it.next?.let {

             nextPokemonPage =  Fetchdata.getPageOffset(it)
            }

            it.previous?.let {
               prevPokemonPage =  Fetchdata.getPageOffset(it)
            }



        })
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =  inflater.inflate(R.layout.fragment_blank, container, false)

        /**
         * the next button calls the pokemonPojo data using the next offset value {nextPokemonPage }
         * Inflate the Recycler view with updated Value
         * Update the  next,prev and current offset value
         *make the Visibility of the Prev button vissible if other wise
         */

        view.next.setOnClickListener{


            Viewmodel.getNextdata(limit,nextPokemonPage!!).observe(viewLifecycleOwner, Observer {


                recyclerView.adapter = RecyclerAdapter(it.results,this)
                recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

                it.next?.let {

                    nextPokemonPage =  Fetchdata.getPageOffset(it)
                    offset = nextPokemonPage!! - limit
                }

                it.previous?.let {
                    prevPokemonPage =  Fetchdata.getPageOffset(it)
                }
            })

            view.prev.isVisible = true

        }

        /**
         * the prev button calls the pokemonPojo data using the prev offset value {prevPokemonPage }
         * Inflate the Recycler view with updated Value
         * Update the  next,prev and current offset value
         *
         */

        view.prev.setOnClickListener {


            Viewmodel.getNextdata(limit, prevPokemonPage!!).observe(viewLifecycleOwner, Observer {
                recyclerView.adapter = RecyclerAdapter(it.results, this)
                recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

                it.next?.let {
                    nextPokemonPage = Fetchdata.getPageOffset(it)
                    offset = nextPokemonPage!! - limit
                }

                it.previous?.let {
                    prevPokemonPage = Fetchdata.getPageOffset(it)
                }
            })


        }

        /**
         * the limit button calls the pokemonPojo data using the current offset value {offset }
         * Inflate the Recycler view with updated Value
         * Update the  next,prev and current offset value
         *
         */


        view.btn_limit.setOnClickListener {

            var limitvalue = inputLimit.text.toString()
            var valid = Fetchdata.validOffsetInput(limitvalue)

            if (valid) {
                limit = inputLimit.text.toString().toInt()


                Viewmodel.getNextdata(limit, offset).observe(viewLifecycleOwner, Observer {


                    recyclerView.adapter = RecyclerAdapter(it.results, this)
                    recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

                    it.next?.let {

                        nextPokemonPage = Fetchdata.getPageOffset(it)
                    }

                    it.previous?.let {
                        prevPokemonPage = Fetchdata.getPageOffset(it)
                    }
                })

            } else {
                inputLimit.text.clear()
                inputLimit.setError("0 or empty field is not allowed")
            }


        }




        return view
    }

    /**
     *Override the onnode_Click button
     * using the Id to view each Pokemon character in the Second Fragment
     */

    override fun onnodeClick(id: String) {
        val action = FirstFragmentDirections.firstCall().setHold(id)
        Navigation.findNavController(requireView()).navigate(action)
    }

}