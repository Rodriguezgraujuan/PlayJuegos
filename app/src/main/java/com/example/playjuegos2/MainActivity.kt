package com.example.playjuegos2

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()

        if (id ==R.id.action_buscar){
            Toast.makeText(this,"Búsqueda", Toast.LENGTH_LONG).show();
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}