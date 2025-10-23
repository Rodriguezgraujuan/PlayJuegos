package com.example.playjuegos2

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jugador: Button = findViewById(R.id.button1)

        jugador.setOnClickListener {lanzarNewPlayer()}

        val btnPrefs: Button = findViewById(R.id.button2)
        btnPrefs.setOnClickListener {lanzarPreferences()}

        val btnPlay = findViewById<Button>(R.id.button)
        btnPlay.setOnClickListener {lanzarGame()}


    }

    fun lanzarNewPlayer(){
        val i= Intent(this, NewPlayer::class.java)
        startActivity(i)
    }

    fun lanzarPreferences(){
        val i = Intent(this, PreferencesActivity::class.java)
        startActivity(i)
    }

    fun lanzarGame(){
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        when (id) {
            R.id.action_buscar -> {
                Toast.makeText(this,"Búsqueda", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.action_show_chips -> {
                val i = Intent(this, ChipActivity::class.java)
                startActivity(i)
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}