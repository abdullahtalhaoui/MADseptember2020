package com.example.madlevel5task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_game.view.*
import java.text.SimpleDateFormat

class GameBacklogAdapter(private val gameBacklog: List<GameBacklog>) : RecyclerView.Adapter<GameBacklogAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        )
    }

    /**
     * Returns the size of the list
     */
    override fun getItemCount(): Int {
        return gameBacklog.size
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     */

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun databind(gameBacklog: GameBacklog) {
            itemView.tvGameTitle.text = gameBacklog.title
            itemView.tvPlatform.text = gameBacklog.platform
            val format = SimpleDateFormat("dd-MM-yyyy")
            itemView.tvDatum.text = format.format(gameBacklog.releaseDate)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(gameBacklog[position])
    }
}