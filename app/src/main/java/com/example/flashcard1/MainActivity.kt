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
        val isShowingAnswers = findViewById<ImageView>(R.id.toggle123)
        val flashcard_question = findViewById<TextView>(R.id.flashcard_question)
        val flashcard_reponse = findViewById<TextView>(R.id.flashcard_reponse)
        val flashcard_reponse2 = findViewById<TextView>(R.id.flashcard_reponse2)
        val flashcard_reponse3 = findViewById<TextView>(R.id.flashcard_reponse3)
        val editButton = findViewById<ImageView>(R.id.edit_bouton)

        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            val data: Intent? = result.data
            if (result.resultCode == Activity.RESULT_OK && data != null) {
                val question = data.getStringExtra("question")
                val answer = data.getStringExtra("answer")
                val option1 = data.getStringExtra("option1")
                val option2 = data.getStringExtra("option2")

                // Mettre à jour les TextView dans MainActivity avec les nouvelles données
                flashcard_question.text = question
                flashcard_reponse.text = answer
                flashcard_reponse2.text = option1
                flashcard_reponse3.text = option2
            } else {
                Log.i("AddCardActivity", "Save operation cancelled or no data returned")
            }
        }


        editButton.setOnClickListener {
            val question = findViewById<TextView>(R.id.flashcard_question).text.toString()
            val answer = findViewById<TextView>(R.id.flashcard_reponse).text.toString()
            val option1 = findViewById<TextView>(R.id.flashcard_reponse2).text.toString()
            val option2 = findViewById<TextView>(R.id.flashcard_reponse3).text.toString()

            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("question", question)
            intent.putExtra("answer", answer)
            intent.putExtra("option1", option1)
            intent.putExtra("option2", option2)
            resultLauncher.launch(intent)
        }

        // Lancer MainActivity en attente d'un résultat
        isShowingAnswers.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            resultLauncher.launch(intent)
        }




    }
}