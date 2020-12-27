package com.example.connect3game;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    boolean isYellow = true;

    String[] gameStateYellow = {"null", "null", "null", "null", "null", "null", "null", "null", "null"};//make 2 arrays for each player and save the state in each then think
    String[] gameStateRed = {"null", "null", "null", "null", "null", "null", "null", "null", "null"};
    int[][] winningPosition = {{0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 4, 8}, {2, 4, 6}};
    String message;
    int counterOfDice = 0;
    boolean isGameActive=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setVisibility(View.INVISIBLE);
    }

    public void clickImage(View view) {
        Log.i("Image", "Image selected");
        ImageView counter = (ImageView) view;
        if(isGameActive) {

            counter.findViewById(R.id.imageView1);

            Log.i("tag", "" + counter.getTag());
            //

            int tag = Integer.parseInt(counter.getTag().toString());
//        System.out.println(tag);


            if (isYellow) {
                gameStateYellow[tag] = "yellow";
                drawYellow(view);

            } else {
                gameStateRed[tag] = "red";
                drawRed(view);
            }

            counterOfDice++;
            for (int[] winningPositions : winningPosition) {
                if (gameStateYellow[winningPositions[0]].equals("yellow") && gameStateYellow[winningPositions[1]].equals("yellow") && gameStateYellow[winningPositions[2]].equals("yellow")) {
                    if (!isYellow) {
                        message = "Yellow";
                        Toast.makeText(this, message + " has won!", Toast.LENGTH_SHORT).show();
                        enableButtonsAndTextView();
                        isGameActive = false;

                    }


                } else if (gameStateRed[winningPositions[0]].equals("red") && gameStateRed[winningPositions[1]].equals("red") && gameStateRed[winningPositions[2]].equals("red")) {
                    if (isYellow) {
                        message = "Red";
                        Toast.makeText(this, message + " has won!", Toast.LENGTH_SHORT).show();
                        enableButtonsAndTextView();
                        isGameActive = false;
                    }

                }


            }
        }


    }

    public void enableButtonsAndTextView(){
        TextView editText = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);
        editText.setText(String.format("%s has won!", message));
        editText.setVisibility(View.VISIBLE);
        button.setVisibility(View.VISIBLE);
    }

    public void playAgain(View view) {


        androidx.gridlayout.widget.GridLayout gridLayout = findViewById(R.id.gridLayout);
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            ImageView counter1 = (ImageView) gridLayout.getChildAt(i);
            counter1.setImageDrawable(null);
        }
        TextView editText = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);
        editText.setVisibility(View.INVISIBLE);
        button.setVisibility(View.INVISIBLE);



        gameStateYellow = new String[]{"null", "null", "null", "null", "null", "null", "null", "null", "null"};//make 2 arrays for each player and save the state in each then think
        gameStateRed = new String[]{"null", "null", "null", "null", "null", "null", "null", "null", "null"};
        isGameActive=true;
    }

    public void drawYellow(View view) {
        isYellow = false;
        ImageView counter = (ImageView) view;
        counter.setTranslationY(-1500);
        counter.setImageResource(R.drawable.yellow);
        counter.animate().translationYBy(1500).setDuration(300);
    }

    public void drawRed(View view) {
        isYellow = true;
        ImageView counter = (ImageView) view;
        counter.setTranslationY(-1500);
        counter.setImageResource(R.drawable.red);
        counter.animate().translationYBy(1500).setDuration(300);
    }
}