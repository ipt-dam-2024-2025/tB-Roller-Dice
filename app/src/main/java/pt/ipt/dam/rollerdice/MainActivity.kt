package pt.ipt.dam.rollerdice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // add some action to our button
        findViewById<Button>(R.id.btRollDice).setOnClickListener {
            rollTheDice()
        }

    }


    /**
     * randomly assigns a value to the dice
     */
    private fun rollTheDice() {
        /*
        Algorithm
        1. create a random number between 1 to 6 [1;6]
        2. use the random number to show the dice on screen
        3. write the random number on screen (on the TextView)
         */

        // 1.
        val diceValue = Random().nextInt(6) + 1 // [0;6]

        // 2.
        val imageToShow = when (diceValue) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else->R.drawable.empty_dice
        }
        // assign the 'image' to the ImageView
        findViewById<ImageView>(R.id.imageViewDice).setImageResource(imageToShow)

        // 3.
        findViewById<TextView>(R.id.textViewDiceNumber).text = diceValue.toString()
    }


}