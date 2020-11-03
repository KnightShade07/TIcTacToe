package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
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
        //loop for the buttons/squares to listen for when they've been clicked.
        for (int i = 0; i < buttonArray.length; i++){
            String buttonID = "btn_" + i;
            int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttonArray[i] = (Button) findViewById(resourceID);
            buttonArray[i].setOnClickListener(this);
        }
        squareCount = 0;
        currentPlayer = true;
    }

    @Override
    public void onClick(View v) {
        //function to check if a button has been pressed, and if it has, make it uneditable.
        if (!((Button)v).getText().toString().equals("")){
            return;
        }
        String btnID = v.getResources().getResourceEntryName((v.getId()));
        int gameStatusTracker = Integer.parseInt(btnID.substring(btnID.length()-1, btnID.length()));
    }
}