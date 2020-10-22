package com.example.madlevel4task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_game_history.view.*
import java.util.*


class GameAdapter(private val games: List<Game>) : RecyclerView.Adapter<GameAdapter.ViewHolder>(){
    /**
     * Creates and returns a ViewHolder object, inflating a standard layout called simple_list_item_1.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_game_history, parent, false)
        )
    }

    /**
     * Returns the size of the list
     */
    override fun getItemCount(): Int {
        return games.size
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(games[position])
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun databind(statistic:Game) {
            var dateTime= Date(statistic.date)
            itemView.tvDate.text = dateTime.toString()
            itemView.tvWinLoseItem.text = statistic.winner

            if(statistic.playerHand== "Rock"){
                itemView.ivYouHand.setImageResource(R.drawable.rock)
            }
            if(statistic.playerHand== "Scissors"){
                itemView.ivYouHand.setImageResource(R.drawable.scissors)
            }
            if(statistic.playerHand== "Paper"){
                itemView.ivYouHand.setImageResource(R.drawable.paper)
            }
            if(statistic.computerHand== "Rock"){
                itemView.ivComputerHand.setImageResource(R.drawable.rock)
            }
            if(statistic.computerHand== "Scissors"){
                itemView.ivComputerHand.setImageResource(R.drawable.scissors)
            }
            if(statistic.computerHand== "Paper"){
                itemView.ivComputerHand.setImageResource(R.drawable.paper)
            }

        }
    }



}