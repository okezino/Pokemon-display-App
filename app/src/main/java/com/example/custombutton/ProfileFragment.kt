package com.example.custombutton

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*


class ProfileFragment : Fragment() {

    lateinit var Viewmodel : MainViewModel
    private val args : ProfileFragmentArgs by navArgs()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

            // Inflate the layout for this fragment
            val view = inflater.inflate(R.layout.fragment_profile, container, false)
            Viewmodel = ViewModelProvider(this).get(MainViewModel::class.java)
            Viewmodel.getPokemonData(args.hold).observe(viewLifecycleOwner, Observer {

                /**
                 * Using the PokemonData Class gotten to populate the UI
                  */

            // populating the Images from the api to the UI
            Picasso.get().load(it.sprites.back_default).into(view.firstPokemon)
            Picasso.get().load(it.sprites.back_shiny).into(view.secondPokemon)
            Picasso.get().load(it.sprites.front_default).into(view.thirdPokemon)
            Picasso.get().load(it.sprites.front_shiny).into(view.forthPokemon)

                //Declaring and populating the  recycler view for the MoveAdapter
                recycler_Move.adapter = MoveAdapter(it.moves)
                recycler_Move.layoutManager = GridLayoutManager(requireContext(),3)


                // Populating the Abilities data on the view
            view.firstAbility.text = it.abilities[0].ability.name
            view.secondAbility.text = it.abilities[1].ability.name


            // Populating the PokemonStat
            var pokeStats = ""
            for (i in it.stats){
                pokeStats += "${i.stat.name}_${i.base_stat}  "
            }
             view.pokemonStat.text = pokeStats

            //Populating the Height/Weight/Specie
            view.heightDisplay.text = "Height: ${ it.height }"
            view.weightDisplay.text = "Weight: ${it.weight}"
            view.typeDisplay.text = "Type: ${it.types[0].type.name}"




            // Set the images background

            Picasso.get().load("https://pokeres.bastionbot.org/images/pokemon/${args.hold}.png").into(view.bg_image)

        })


        return view
    }

}