package com.example.custombutton

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.custombutton.model.PokemonPojo
import com.example.custombutton.model.Results
import com.example.custombutton.util.Fetchdata
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cardview.view.*

/**
 * Adapter to display all Pokemon character on the FirstFragment
 */

class RecyclerAdapter(var pokemon : ArrayList<Results>, var nodelist : PokemonClick) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){


 //set all the widget on the ViewHolder Class

   inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {

        var textView : TextView = itemView.pokemonName
        var imageView : ImageView = itemView.pokemonImage
         var idDisplay : TextView = itemView.displayId
        init {
             itemView.setOnClickListener(this)
        }

       override fun onClick(v: View?) {
           var id  = Fetchdata.getId(pokemon[adapterPosition].url)
           nodelist.onnodeClick(id)
       }

   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.cardview,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pokemon.size
    }


 //Bind all functionality and variable to the ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var id  = Fetchdata.getId(pokemon[position].url)
        holder.idDisplay.text = id
      holder.textView.text = pokemon[position].name
      Picasso.get().load("https://pokeres.bastionbot.org/images/pokemon/${id}.png").into(holder.imageView)

    }



}