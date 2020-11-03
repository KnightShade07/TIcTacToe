package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView playerStatus;
    private Button [] buttonArray = new Button[9];
    private Button resetGame;

    private int p1Score, p2Score, squareCount;
    boolean currentPlayer;

    int [] gameStatus = {2,2,2,2,2,2,2,2};

    int[][] winningRowsAndColumns = {
            {0,1,2}, {3,4,5}, {6,7,8},//rows.
            {0,3,6}, {1,4,7}, {2,5,8},//columns.
            {0,4,8}, {2,4,6}//Diagonals
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resetGame = (Button) findViewById(R.id.btnNewGame);
    }
}