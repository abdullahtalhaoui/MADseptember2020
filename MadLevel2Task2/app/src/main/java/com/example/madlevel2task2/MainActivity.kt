package com.example.madlevel2task2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel2task2.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_question.*

class MainActivity : AppCompatActivity() {

    private val questions = arrayListOf<Question>()

    private val questionAdapter = QuestionAdapter(questions)

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.rvQuestions.adapter = questionAdapter
        binding.rvQuestions.layoutManager = LinearLayoutManager(
            this@MainActivity,
            RecyclerView.VERTICAL,
            false
        )

        for (i in Question.QUESTIONS_VALUES.indices) {
            questions.add(Question.QUESTIONS_VALUES[i])
        }
        questionAdapter.notifyDataSetChanged()
        createItemTouchHelper().attachToRecyclerView(rvQuestions)
    }


    /**
     * Create a touch helper to recognize when a user swipes an item from a recycler view.
     * An ItemTouchHelper enables touch behavior (like swipe and move) on each ViewHolder,
     * and uses callbacks to signal when a user is performing these actions.
     */
    private fun createItemTouchHelper(): ItemTouchHelper {

        // Callback which is used to create the ItemTouch helper. Only enables left swipe.
        // Use ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) to also enable right swipe.
        val callback = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

            // Enables or Disables the ability to move items up and down.
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            // Callback triggered when a user swiped an item.
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                if (direction == ItemTouchHelper.LEFT) {
                    if (questions[position].iscorrect==false) {
                        questions.removeAt(position)
                    }
                    else{  Snackbar.make(rvQuestions, getString(R.string.incorrect), Snackbar.LENGTH_SHORT).show()}
                }
                if (direction == ItemTouchHelper.RIGHT) {
                    if (questions[position].iscorrect==true) {
                        questions.removeAt(position)
                    }
                    else{  Snackbar.make(rvQuestions,  getString(R.string.incorrect), Snackbar.LENGTH_SHORT).show()}
                }
                questionAdapter.notifyDataSetChanged()
            }
        }
            return ItemTouchHelper(callback)
        }


    }

