package com.example.connect3game;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Boolean isYellow = true;

    String[] gameStateYellow = new String[10];//make 2 arrays for each player and save the state in each then think
    String[] gameStateRed = new String[10];
    int counterOfDice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickImage(View view) {
        Log.i("Image", "Image selected");
        ImageView counter = (ImageView) view;

        counter.findViewById(R.id.imageView1);

        Log.i("tag", "" + counter.getTag());
        //[0,3,6],[1,4,7],[3,5,9],[0,1,2],[3,4,5],[6,7,8],[0,4,8],[2,4,6]

        int tag = Integer.parseInt(counter.getTag().toString());
        System.out.println(tag);

        if (counterOfDice == 9) {
            Toast.makeText(this, "Game Over!", Toast.LENGTH_SHORT).show();
            counterOfDice=0;
            GridLayout gridLayout = null;
            for(int i=0;i<gridLayout.getChildCount();i++){
                counter.setImageDrawable(null);
            }
        }
        else {
            if (isYellow) {
                gameStateYellow[tag] = "yellow";
                drawYellow(view);
                System.out.println(gameStateYellow[tag]);

            } else {
                gameStateRed[tag] = "red";
                drawRed(view);
                System.out.println(gameStateRed[tag]);
            }
            counterOfDice++;
        }


        System.out.println(counterOfDice);


    }

    public void drawYellow(View view) {
        isYellow = false;
        ImageView counter = (ImageView) view;
        counter.setTranslationY(-1500);
        counter.setImageResource(R.drawable.yellow);
        counter.animate().translationYBy(1500).setDuration(2000);
    }

    public void drawRed(View view) {
        isYellow = true;
        ImageView counter = (ImageView) view;
        counter.setTranslationY(-1500);
        counter.setImageResource(R.drawable.red);
        counter.animate().translationYBy(1500).setDuration(2000);
    }
}