package br.com.jogodavelha

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val playerOne = arrayListOf<Int>()
    val playerTwo = arrayListOf<Int>()
    var currentPlayer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun play(position: Int, btnSelected: Button) {
        if (currentPlayer == 1) {
            btnSelected.text = "X"
            btnSelected.setBackgroundResource(R.color.player_1)
            playerOne.add(position)
            currentPlayer = 2
        } else {
            btnSelected.text = "0"
            btnSelected.setBackgroundResource(R.color.player_2)
            playerTwo.add(position)
            currentPlayer = 1
        }

        btnSelected.isClickable = false

        gameOver()
    }

    fun btnPosition(view: View) = when(view.id) {
        R.id.btn_game1 -> play(1, view as Button)
        R.id.btn_game2 -> play(2, view as Button)
        R.id.btn_game3 -> play(3, view as Button)
        R.id.btn_game4 -> play(4, view as Button)
        R.id.btn_game5 -> play(5, view as Button)
        R.id.btn_game6 -> play(6, view as Button)
        R.id.btn_game7 -> play(7, view as Button)
        R.id.btn_game8 -> play(8, view as Button)
        R.id.btn_game9 -> play(9, view as Button)
        else -> play(0, view as Button)
    }

    fun gameOver() {
        val row1 = arrayListOf(1, 2, 3)
        val row2 = arrayListOf(4, 5, 6)
        val row3 = arrayListOf(7, 8, 9)

        val column1 = arrayListOf(1, 4, 6)
        val column2 = arrayListOf(2, 5, 7)
        val column3 = arrayListOf(3, 6, 9)

        val diagonal1 = arrayListOf(1, 5, 9)
        val diagonal2 = arrayListOf(3, 5, 7)

        var winner = -1

        if (playerOne.containsAll(row1) || playerOne.containsAll(row2) || playerOne.containsAll(row3) ||
            playerOne.containsAll(column1) || playerOne.containsAll(column2) || playerOne.containsAll(column3) ||
            playerOne.containsAll(diagonal1) || playerOne.containsAll(diagonal2)) {
            winner = 1
        }

        if (playerTwo.containsAll(row1) || playerTwo.containsAll(row2) || playerTwo.containsAll(row3) ||
            playerTwo.containsAll(column1) || playerTwo.containsAll(column2) || playerTwo.containsAll(column3) ||
            playerTwo.containsAll(diagonal1) || playerTwo.containsAll(diagonal2)) {
            winner = 2
        }

        when(winner) {
            1 -> Toast.makeText(this, "O jogador 1 venceu!", Toast.LENGTH_LONG).show()
            2 -> Toast.makeText(this, "O jogador 2 venceu!", Toast.LENGTH_LONG).show()
        }
    }

    fun restartGame(view: View) {
        playerOne.clear()
        playerTwo.clear()
        setContentView(R.layout.activity_main)
    }
}
