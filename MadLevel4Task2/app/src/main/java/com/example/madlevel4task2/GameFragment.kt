package com.example.madlevel4task2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class GameFragment : Fragment() {
    private val mainScope = CoroutineScope(Dispatchers.Main)
    private lateinit var gameRepository: GameRepository
    var hand= "Rock"
    var computerHand= "Scissors"
    var randInt: Int= 1
    var winnaar= "x"

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gameRepository = GameRepository(requireContext())

        ivPaper.setOnClickListener{
            hand= "Paper"
            ivYou.setImageResource(R.drawable.paper)
            computerTurn()
        }
        ivRock.setOnClickListener{
            hand= "Rock"
            ivYou.setImageResource(R.drawable.rock)
            computerTurn()
        }
        ivScissors.setOnClickListener{
            hand= "Scissors"
            ivYou.setImageResource(R.drawable.scissors)
            computerTurn()
        }

    }
    private fun computerTurn(){
        randInt=(1..3).random()

        if (randInt==1){
            ivComputer.setImageResource(R.drawable.scissors)
            computerHand="Scissors"
        }
        if (randInt==2){
            ivComputer.setImageResource(R.drawable.rock)
            computerHand="Rock"
        }
        if (randInt==3){
            ivComputer.setImageResource(R.drawable.paper)
            computerHand="Paper"
        }
        checkWinner()
    }

    private fun checkWinner() {
        if (hand=="Paper"){
            if (computerHand=="Paper"){
                winnaar="Draw"
                tvWinner.text="Draw"
            }
            if (computerHand=="Scissors"){
                winnaar="Computer Wins!"
                tvWinner.text="Computer Wins!"
            }
            if (computerHand=="Rock"){
                winnaar="You Win!"
                tvWinner.text="You Win!"
            }
        }
        if (hand=="Rock"){
            if (computerHand=="Rock"){
                winnaar="Draw"
                tvWinner.text="Draw"
            }
            if (computerHand=="Paper"){
                winnaar="Computer Wins!"
                tvWinner.text="Computer Wins!"
            }
            if (computerHand=="Scissors"){
                winnaar="You Win!"
                tvWinner.text="You Win!"
            }
        }
        if (hand=="Scissors"){
            if (computerHand=="Scissors"){
                winnaar="Draw"
                tvWinner.text="Draw"
            }
            if (computerHand=="Rock"){
                winnaar="Computer Wins!"
                tvWinner.text="Computer Wins!"
            }
            if (computerHand=="Paper"){
                winnaar="You Win!"
                tvWinner.text="You Win!"
            }
        }
        var dateTime: Long = System.currentTimeMillis()
        mainScope.launch {
            val statistic = Game(
                date = dateTime,
                winner = winnaar,
                computerHand = computerHand,
                playerHand = hand
            )
            withContext(Dispatchers.IO){
                gameRepository.insertStatistic(statistic)
            }
        }


    }


}