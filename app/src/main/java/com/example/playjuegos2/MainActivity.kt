package com.example.playjuegos2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jugador: Button = findViewById(R.id.button1)

        jugador.setOnClickListener {lanzarNewPlayer()}
    }

    fun lanzarNewPlayer(){
        val i= Intent(this, NewPlayer::class.java)
        startActivity(i)
    }
}