package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //0=Yellow,1=Red,;
    int activePlayer = 0;
    int gameState[] = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int count=0;
    int winingPositions[][] = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {6, 4, 2}}; // Winning position.
    boolean gameOn = true;


//    public void x() {
//int count=0;
//        for (int i = 0; i < gameState.length; i++) {
//            if (gameState[i] == 2) {
//                count++;
//            }
//            if(count==0)
//            {
//                String print=String.valueOf(count);
//                Toast.makeText(this, print, Toast.LENGTH_SHORT).show();
//            }
//            else
//            {
//                count=0;
//            }
//        }
//
//    }

























    public void dropIn(View x) {

        Button press = (Button) findViewById(R.id.button);
        TextView text = (TextView) findViewById(R.id.textView2);
        for (int i = 0; i < gameState.length; i++)
        {
            if (gameState[i] == 2)


            {
                count++;
            }
        }
            if(count==1)
            {
                text.setText( "NO ONE HAS WON");
                text.setVisibility(View.VISIBLE);
                press.setVisibility(View.VISIBLE);



            }
            else
            {
                count=0;
            }

                     ImageView counter = (ImageView) x;
                     int tapCounter = Integer.parseInt(counter.getTag().toString());       //geting the tap value from the image.


                     if (gameState[tapCounter] == 2 && gameOn) {
                         counter.setTranslationY(-1500);                                     //vanishing the image


                         gameState[tapCounter] = activePlayer;


                         if (activePlayer == 0) {
                             counter.setImageResource(R.drawable.yellow);
                             counter.animate().translationYBy(1500).rotation(3600).setDuration(300);
                             activePlayer = 1;
                         } else {
                             counter.setImageResource(R.drawable.red);
                             counter.animate().translationYBy(1500).rotation(3600).setDuration(300);
                             activePlayer = 0;
                         }
                         for (int y[] : winingPositions) {
                             if (gameState[y[0]] == gameState[y[1]] && gameState[y[1]] == gameState[y[2]] && gameState[y[0]] != 2)
                             {
                                 gameOn = false;
                                 String winner = "";
                                 if (gameState[y[0]] == 1) {
                                     winner = "RED";
                                 } else {
                                     winner = "YELLOW";
                                 }

                                 text.setText(winner + "\tHAS WON");
                                 text.setVisibility(View.VISIBLE);
                                 press.setVisibility(View.VISIBLE);


                             }


                         }

                     }



                 }


  public void playAgain(View v)
    {
        Button press = (Button) findViewById(R.id.button);
        TextView text = (TextView) findViewById(R.id.textView2);
        text.setVisibility(View.INVISIBLE);
        press.setVisibility(View.INVISIBLE);
        androidx.gridlayout.widget.GridLayout g = (androidx.gridlayout.widget.GridLayout) findViewById(R.id.gridLayout1);

        for (int i = 0; i < g.getChildCount(); i++) {
            ImageView child = (ImageView) g.getChildAt(i);
            child.setImageDrawable(null);

        }
        for(int i=0;i<gameState.length;i++)
        {
            gameState[i]=2;

        }
         activePlayer = 0;




        gameOn = true;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}