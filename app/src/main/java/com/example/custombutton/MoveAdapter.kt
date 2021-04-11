package com.example.custombutton

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.custombutton.model.dataPokemon.Move
import kotlinx.android.synthetic.main.movedata_layout.view.*


/**
 * Adapter to populate the Moves on the second Fragment
 */

class MoveAdapter(var moves : List<Move>) : RecyclerView.Adapter<MoveAdapter.ViewHolder>(){




    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var data : TextView = itemView.movesText
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.movedata_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
    return moves.size
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.data.text = moves[position].move.name
    }



}