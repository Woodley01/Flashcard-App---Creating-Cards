package com.example.flashcard1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val editTextField =findViewById<EditText>(R.id.editTextField)
        val editTextField1 =findViewById<EditText>(R.id.editTextField1)
        val Answers = findViewById<ImageView>(R.id.icone_X)
        val Savebouton = findViewById<ImageView>(R.id.icone_save)

        Answers.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        Savebouton.setOnClickListener {
            val question = editTextField.text.toString()
            val answer = editTextField1.text.toString()

            val intent = Intent()
            intent.putExtra("question", question)
            intent.putExtra("answer", answer)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}