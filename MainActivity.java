package com.example.elavi.braintrainer;

import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
         Button gobutton;
    int locationofanswers;
    TextView resulttextview;
    TextView sumtextview;
    TextView scoretextview;
    TextView timertextview;
    int score=0;
    int noofquestions=0;
    Button playagainbutton;
    Button brainbutton;
    ConstraintLayout gamelayout;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
         public void playagain(View view)
         {
             score=0;
             noofquestions=0;
             timertextview.setText("10");
             scoretextview.setText(Integer.toString(score)+"/"+Integer.toString(noofquestions));
             playagainbutton.setVisibility(View.INVISIBLE);
             resulttextview.setText("");
             new CountDownTimer(25050,1000)
             {

                 @Override
                 public void onTick(long l) {
                     timertextview.setText(String.valueOf(l/1000)+"s");
                 }

                 @Override
                 public void onFinish() {
                     resulttextview.setText("Done!");
                     playagainbutton.setVisibility(View.VISIBLE);
                     Toast.makeText(getApplicationContext(),"The Score is "+(Integer.toString(score)+"/"+Integer.toString(noofquestions)),Toast.LENGTH_LONG).show();
                 }
             }.start();

         }
         ArrayList<Integer> al=new ArrayList<>();
         public void chooseanswer(View view) {
             if (Integer.toString(locationofanswers).equals((view.getTag().toString())))
             {
                 score++;
                 resulttextview.setText("Correct!");
             }
             else
             {

                resulttextview.setText("Wrong :(");
             }
             noofquestions++;
             scoretextview.setText(Integer.toString(score)+"/"+Integer.toString(noofquestions));
             newQuestion();
         }

         public void newQuestion()
         {
             Random rand=new Random();
             int a=rand.nextInt(21);
             int b=rand.nextInt(21);
             button0=findViewById(R.id.button0);
             button1=findViewById(R.id.button1);
             button2=findViewById(R.id.button2);
             button3=findViewById(R.id.button3);

             sumtextview.setText(Integer.toString(a)+ " + "+ Integer.toString(b));
             locationofanswers=rand.nextInt(4);
             al.clear();
             for(int i=0;i<4;i++)
             {
                 if(i==locationofanswers)
                 {
                     al.add(a+b);
                 }
                 else
                 {
                     int wronganswer=rand.nextInt(41);
                     if(wronganswer==(a+b))
                     {
                         while(wronganswer==a+b) {
                             wronganswer = rand.nextInt(41);
                         }
                     }
                     al.add(wronganswer);
                 }//close of the else part
             }//end of the for loop
             button0.setText(Integer.toString(al.get(0)));
             button1.setText(Integer.toString(al.get(1)));
             button2.setText(Integer.toString(al.get(2)));
             button3.setText(Integer.toString(al.get(3)));
         }

         public void start(View view)
         {
             gobutton.setVisibility(View.INVISIBLE);
             playagain(findViewById(R.id.timertextview));
             gamelayout.setVisibility(View.VISIBLE);
             //playagain(findViewById(R.id.timertextview));
            // gamelayout.setVisibility(View.VISIBLE);

         }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         sumtextview=findViewById(R.id.sumtextview);
        gobutton=findViewById(R.id.brainbutton);
        resulttextview=findViewById(R.id.resulttextview);
        scoretextview=findViewById(R.id.scoretextview);
        timertextview=findViewById(R.id.timertextview);
        playagainbutton=findViewById(R.id.playagainbutton);
        brainbutton=findViewById(R.id.brainbutton);
        brainbutton.setVisibility(View.VISIBLE);
        gamelayout=findViewById(R.id.gamelayout);
        gamelayout.setVisibility(View.INVISIBLE);
    }
}
