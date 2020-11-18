package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView playerStatus;
    private Button [] buttonArray = new Button[10];
    private Button btnNewGame;
    //This variable keeps track of the buttons and is
    //incremented when a button is pressed.
    //when btnCount = 9, the game will stop.
    private int btnCount;
    boolean currentPlayer;
    //This array keeps track of the empty, unmarked buttons.
    int [] gameStatus = {2,2,2,2,2,2,2,2,2,2};
    //2D array that will be used to keep track
    //of the winning rows and columns for HW3.
    int[][] winningCombinations = {
            {0,1,2}, {3,4,5}, {6,7,8},//rows.
            {0,3,6}, {1,4,7}, {2,5,8},//columns.
            {0,4,8}, {2,4,6}//Diagonals
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerStatus = findViewById(R.id.playerText);
        btnNewGame = findViewById(R.id.btnNewGame);
        playerStatus.setText("Welcome to TicTacToe! To get started, click a square!\n"
        + " The game starts as X!");
        btnArrayClickListener();
    }

    @Override
    public void onClick(View v) {
        if (IsButtonPressed((Button) v)) return;
        changeTurns(v);
    }

    /**
     * This method uses a for loop to listen for when
     * the buttons on the TicTacToe Board have been clicked.
     */
    private void btnArrayClickListener() {
        for (int i = 1; i < buttonArray.length; i++){
            String buttonID = "btn_" + i;
            int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttonArray[i] = findViewById(resourceID);
            buttonArray[i].setOnClickListener(this);
        }
        btnCount = 0;
        currentPlayer = true;
    }

    /**
     * This method uses the currentPlayer boolean in order to change turns in games
     * of TicTacToe.
     * currentPlayer set to true = player 1.
     * currentPlayer set to false = player 2.
     * @param v - The view of the android phone.
     */
    public void changeTurns(View v) {
        String btnID = v.getResources().getResourceEntryName((v.getId()));
        int gameStatusTracker = Integer.parseInt(btnID.substring(btnID.length()-1));
        if (currentPlayer){
            ((Button)v).setText("X");
            playerStatus.setText("It is now O's Turn.");
            gameStatus[gameStatusTracker] = 0;
            currentPlayer = false;

        }
        else{
            ((Button)v).setText("O");
            playerStatus.setText("It is now X's Turn.");
            gameStatus[gameStatusTracker] = 1;
            currentPlayer = true;
        }
        btnCount++;
    }

    /**
     * This method checks if a button has been pressed,
     * and if it has, make it unchangeable.
     * @param v The button to be pressed.
     *
     */

    public boolean IsButtonPressed(Button v) {
        if (!v.getText().toString().equals("")){
            return true;
        }
        return false;
    }

    /**
     * This method uses a for loop to loop through the different TicTacToe
     * Buttons, and resets their text so that the players can start a new game.
     *
     * The playerStatus.setText on line 119 makes sure that the playerText gets reset back to X
     * if the players decide to restart early for any reason.
     */
    public void clearButtons(View v){
        btnCount = 0;
        currentPlayer = true;
        for (int i = 1; i < buttonArray.length; i++){
            gameStatus[i] = 2;
            buttonArray[i].setText("");
        }
        playerStatus.setText("It is now X's Turn.");


    }

    public void checkWinner(){
        
    }

}