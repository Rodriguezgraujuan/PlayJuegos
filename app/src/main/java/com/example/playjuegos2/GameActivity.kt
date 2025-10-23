package com.example.playjuegos2

import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class GameActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)

        val cbGame1 = findViewById<CheckBox>(R.id.cb_game_name1)
        val cbGame2 = findViewById<CheckBox>(R.id.cb_game_name2)
        val cbGame3 = findViewById<CheckBox>(R.id.cb_game_name3)
        val cbGame4 = findViewById<CheckBox>(R.id.cb_game_name4)
        val cbGame5 = findViewById<CheckBox>(R.id.cb_game_name5)
        val cbGame6 = findViewById<CheckBox>(R.id.cb_game_name6)

        val fab = findViewById<FloatingActionButton>(R.id.fabEnviar)

        fab.setOnClickListener {
            val selectedGames = mutableListOf<String>()

            if (cbGame1.isChecked) selectedGames.add(cbGame1.text.toString())
            if (cbGame2.isChecked) selectedGames.add(cbGame2.text.toString())
            if (cbGame3.isChecked) selectedGames.add(cbGame3.text.toString())
            if (cbGame4.isChecked) selectedGames.add(cbGame4.text.toString())
            if (cbGame5.isChecked) selectedGames.add(cbGame5.text.toString())
            if (cbGame6.isChecked) selectedGames.add(cbGame6.text.toString())

            val message = if (selectedGames.isEmpty()) {
                "No seleccionaste ningún juego"
            } else {
                "Seleccionaste: ${selectedGames.joinToString(", ")}"
            }

            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
    }
}