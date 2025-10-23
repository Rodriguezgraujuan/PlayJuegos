package com.example.playjuegos2

import android.animation.ObjectAnimator
import android.animation.AnimatorSet
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ChipActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chips)
        supportActionBar?.hide()

        val chipGroupPlataformas: ChipGroup = findViewById(R.id.chipGroup)
        chipGroupPlataformas.isSingleSelection = true

        val chipGroupGeneros: ChipGroup = findViewById(R.id.chipGroup2)
        for (i in 0 until chipGroupGeneros.childCount) {
            val chip = chipGroupGeneros.getChildAt(i) as? Chip
            chip?.setOnClickListener {
                Toast.makeText(this, "Género: ${chip.text}", Toast.LENGTH_SHORT).show()
            }
        }

        val fab: FloatingActionButton = findViewById(R.id.fab)
        val blockHint: View = findViewById(R.id.blockHint)

        fab.setOnClickListener {
            fab.translationY = 0f

            val up = ObjectAnimator.ofFloat(fab, "translationY", -160f).apply {
                duration = 300
                interpolator = AccelerateDecelerateInterpolator()
            }

            val stay = ObjectAnimator.ofFloat(fab, "translationY", -160f).apply {
                duration = 1000 // tiempo que quieres que se quede arriba
            }

            val down = ObjectAnimator.ofFloat(fab, "translationY", 0f).apply {
                duration = 300
                interpolator = AccelerateDecelerateInterpolator()
            }

            val set = AnimatorSet()
            set.playSequentially(up, stay, down)
            set.start()

            blockHint.alpha = 0f
            blockHint.visibility = View.VISIBLE
            blockHint.animate()
                .alpha(1f)
                .setDuration(300)
                .start()

            Handler(Looper.getMainLooper()).postDelayed({
                blockHint.animate()
                    .alpha(0f)
                    .setDuration(300)
                    .withEndAction { blockHint.visibility = View.GONE }
                    .start()
            }, 1600)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?) = false
}
