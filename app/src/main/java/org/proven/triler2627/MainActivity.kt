package org.proven.triler2627

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import java.util.Random

class MainActivity : ComponentActivity() {
    private val TAG = "TRILERO"

    private lateinit var ivCube1: ImageView
    private lateinit var ivCube2: ImageView
    private lateinit var ivCube3: ImageView
    private lateinit var btStart: Button
    private lateinit var tvResult: TextView

    private lateinit var listener: View.OnClickListener

    private var positionBall = 0
    private var playing = false

    private lateinit var tvScore: TextView
    private var wins = 0
    private var losses = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trilero_layout)

        /*bStart.setOnClickListener {
           bStart.setText("Prem aquí ....")
        }*/
        // obtinc la referència dels elements del layout
        instantiateElements()
        // instancio el listener
        prepareListener()
        // afegeixo el listener als elements
        addListenerToElements()
    }

    private fun instantiateElements() {
        ivCube1 = findViewById(R.id.ivCube1)
        ivCube2 = findViewById(R.id.ivCube2)
        ivCube3 = findViewById(R.id.ivCube3)
        btStart = findViewById(R.id.btStart)
        tvResult = findViewById(R.id.tvResult)
        tvScore = findViewById(R.id.tvScore)
        updateScore()
    }
    private fun updateScore() {
        tvScore.text = "Wins: $wins   Losses: $losses"
    }

    private fun prepareListener() {
        listener = View.OnClickListener { view ->
            when (view.id) {
                R.id.btStart -> {
                    initGame()
                }
                R.id.ivCube1 -> {
                    if (playing) {
                        playing = false
                        if (positionBall == 0) {
                            wins++
                            tvResult.text = "YOU WIN!!!"
                            ivCube1.setImageResource(R.drawable.levantaok)
                        } else {
                            losses++
                            tvResult.text = "YOU LOSE!!!"
                            ivCube1.setImageResource(R.drawable.levantafail)
                        }
                        btStart.visibility = View.VISIBLE
                    }
                    updateScore()
                }
                R.id.ivCube2 -> {
                    if (playing) {
                        playing = false
                        if (positionBall == 1) {
                            wins++
                            tvResult.text = "YOU WIN!!!"
                            ivCube2.setImageResource(R.drawable.levantaok)
                        } else {
                            losses++
                            tvResult.text = "YOU LOSE!!!"
                            ivCube2.setImageResource(R.drawable.levantafail)
                        }
                        btStart.visibility = View.VISIBLE
                    }
                    updateScore()
                }
                R.id.ivCube3 -> {
                    if (playing) {
                        playing = false
                        if (positionBall == 2) {
                            wins++
                            tvResult.text = "YOU WIN!!!"
                            ivCube3.setImageResource(R.drawable.levantaok)
                        } else {
                            losses++
                            tvResult.text = "YOU LOSE!!!"
                            ivCube3.setImageResource(R.drawable.levantafail)
                        }
                        btStart.visibility = View.VISIBLE
                    }
                    updateScore()
                }
            }
        }
    }

    private fun initGame() {
        // Reiniciar els cubilets
        ivCube1.setImageResource(R.drawable.cubilete)
        ivCube2.setImageResource(R.drawable.cubilete)
        ivCube3.setImageResource(R.drawable.cubilete)

        // Generar número aleatori (0 a 2)
        val rand = Random()
        positionBall = rand.nextInt(3)
        Log.d(TAG, "RandomGenerado: $positionBall")

        playing = true
        btStart.visibility = View.INVISIBLE
        tvResult.text = "You are Playing!!!"
    }

    private fun addListenerToElements() {
        ivCube1.setOnClickListener(listener)
        ivCube2.setOnClickListener(listener)
        ivCube3.setOnClickListener(listener)
        btStart.setOnClickListener(listener)
    }

}