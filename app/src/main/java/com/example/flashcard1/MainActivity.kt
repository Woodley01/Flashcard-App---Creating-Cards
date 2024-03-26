package com.example.flashcard1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val isShowingAnswers = findViewById<ImageView>(R.id.pluscircle)
        val Question_flashcard = findViewById<TextView>(R.id.flashcard_Question)
        val Answer_flashcard = findViewById<TextView>(R.id.flashcard_Answer)
        val editButton = findViewById<ImageView>(R.id.edit_bouton)



        Question_flashcard.setOnClickListener {
            Question_flashcard.visibility = View.INVISIBLE
            Answer_flashcard.visibility = View.VISIBLE

        }
        Answer_flashcard.setOnClickListener {
            Question_flashcard.visibility = View.VISIBLE
            Answer_flashcard.visibility = View.INVISIBLE

        }

        isShowingAnswers.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            val data: Intent? = result.data
            if (result.resultCode == Activity.RESULT_OK && data != null) {
                val question = data.getStringExtra("question")
                val answer = data.getStringExtra("answer")

                // Mettre à jour les TextView dans MainActivity avec les nouvelles données
                Question_flashcard.text = question
                Answer_flashcard.text = answer
            } else {
                Log.i("AddCardActivity", "Save operation cancelled or no data returned")
            }
        }

// Lancer MainActivity en attente d'un résultat
        isShowingAnswers.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            resultLauncher.launch(intent)
        }




    }
}