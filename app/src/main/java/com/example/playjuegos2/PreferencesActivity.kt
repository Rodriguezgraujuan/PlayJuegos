package com.example.playjuegos2

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PreferencesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.preferences)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupJuegos)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val fab = findViewById<FloatingActionButton>(R.id.fabEnviar)

        ratingBar.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener { ratingBar, rating, fromUser ->
            seekBar.progress = rating.toInt()
        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                ratingBar.rating = progress.toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) { }

            override fun onStopTrackingTouch(seekBar: SeekBar) { }
        })



        fab.setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId

            if (selectedId == -1) {
                Toast.makeText(this, "No has pulsado ninguna opción", Toast.LENGTH_SHORT).show()
            } else {
                val selectedButton = findViewById<RadioButton>(selectedId)
                val juego = selectedButton.text
                val puntosSeekBar = seekBar.progress
                val estrellas = ratingBar.rating

                val mensaje = "$juego Puntuación: $puntosSeekBar"
                Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
            }
        }
    }
}
