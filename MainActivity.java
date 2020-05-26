package com.narcos.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Boolean ga=true;
  // Player Detail
   // 0-X
   // 1-O
    int activePlayer=0;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    // Meaning
    // 0-X
    // 1-O
    // 2-Null
    int[][] winPositions={{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}};
    public void playerTap(View view)
    {
        ImageView img=(ImageView) view;
        int tappedImage= Integer.parseInt(img.getTag().toString());
        if(!ga){
            reset(view);
        }
        if(gameState[tappedImage]==2 && ga)
        {
            gameState[tappedImage]=activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer ==0)
            {

                img.setImageResource(R.drawable.cross);
                activePlayer = 1;
                TextView status=findViewById(R.id.status);
                status.setText("O's Turn-Tap to Play");
            }
            else
            {   img.setImageResource(R.drawable.ze);
                activePlayer=0;
                TextView status=findViewById(R.id.status);
                status.setText("X's Turn-Tap to Play");
        }

img.animate().translationYBy(1000f).setDuration(50);

    }
        for(int[] winPosition: winPositions)
        {
          if(gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]] == gameState[winPosition[2]] && gameState[winPosition[0]] !=2)
          {String winnerstr;
          ga=false;
              if(gameState[winPosition[0]]==0)
              {
                  winnerstr ="X has won!";
              }
              else
              {   winnerstr="O has won!";
          }
              TextView status=findViewById(R.id.status);
              status.setText(winnerstr);
          }
        }

    }
    public void reset(View view){
        ga=true;
        activePlayer=0;
        for(int i=0;i<gameState.length;i++)
        {
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView12)).setImageResource(0);
        TextView status=findViewById(R.id.status);
        status.setText("Tap to Play");
    }

    public void resetgame(View view)
    {

        Toast.makeText(this, "Developed by Narcos", Toast.LENGTH_SHORT).show();
reset(view);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
