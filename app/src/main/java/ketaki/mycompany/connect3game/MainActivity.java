package ketaki.mycompany.connect3game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
// 0=yellow, 1=red, -1=empty;
int[] array={2,2,2,2,2,2,2,2,2};
int[][] winners ={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
boolean gameactive = true;
int activeplayer=0;


   public void drop(View view)
   {
       ImageView counter = (ImageView) view;
       int tappedcounter = Integer.parseInt(counter.getTag().toString());

       if(array[tappedcounter]==2 && gameactive) {

           array[tappedcounter] = activeplayer;


           counter.setTranslationY(-1500);
           if (activeplayer == 0) {
               counter.setImageResource(R.drawable.yellow);
               activeplayer = 1;

           } else {
               counter.setImageResource(R.drawable.red);
               activeplayer = 0;
           }
           counter.animate().translationYBy(1500).setDuration(300);

           for (int[] winners : winners) {
               if (array[winners[0]] == array[winners[1]] && array[winners[1]] == array[winners[2]] && array[winners[0]] != 2) {

                   gameactive= false;
                   String win = "";
                   if (activeplayer == 1)
                       win = "Yellow";
                   else
                       win = "Red";


                   TextView textView = (TextView) findViewById(R.id.textView);
                       Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
                     textView.setText(win + " has won !");
                      playAgainButton.setVisibility(View.VISIBLE);
                      textView.setVisibility(View.VISIBLE);



               }
           }
       }
   }
   public void playAgain (View view)
   {
       TextView textView = (TextView) findViewById(R.id.textView);
       Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
       playAgainButton.setVisibility(View.INVISIBLE);
       textView.setVisibility(View.INVISIBLE);
       GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
       for(int i=0; i<gridLayout.getChildCount(); i++) {
           ImageView counter = (ImageView)gridLayout.getChildAt(i);
           counter.setImageDrawable(null);
       }
          for(int x=0; x<array.length; x++)
          {
              array[x]=2;
          }
        gameactive = true;
       activeplayer=0;
   }







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
