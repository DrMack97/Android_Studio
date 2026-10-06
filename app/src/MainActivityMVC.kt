package org.proven.triler2627

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import java.util.Random

class MainActivityMVC : ComponentActivity() {

    private var modelGame = ModelGame()
    private lateinit var ivCube: Array<ImageView>
    private lateinit var btStart: Button
    private lateinit var tvResult: TextView
    private lateinit var listener: View.OnClickListener



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trilero_layout)

        // instanciar els elements de la Vista
        initElements()
        prepareListener()
        addElementsToListener()
    }

    private fun addElementsToListener() {
        btStart.setOnClickListener(listener)
        for (iv in ivCube) {
            iv.setOnClickListener(listener)
        }
   }

    private fun prepareListener() {
        listener = View.OnClickListener{ view ->
            if(view.id == btStart.id) {
                Log.d("TEST","Button " + view.id)
            }else{
                if(R.id.ivCube1 == view.id) {
                    Log.d("TEST","Cube 1")
                }else if(R.id.ivCube2 == view.id) {
                    Log.d("TEST","Cube 2")
                }else if(R.id.ivCube3 == view.id) {
                    Log.d("TEST","Cube 3")
                }
            }
        }
    }

    private fun initElements() {
        btStart = findViewById(R.id.btStart)
        ivCube = arrayOf(
            findViewById(R.id.ivCube1),
            findViewById(R.id.ivCube2),
            findViewById(R.id.ivCube3)
        )
    }

}