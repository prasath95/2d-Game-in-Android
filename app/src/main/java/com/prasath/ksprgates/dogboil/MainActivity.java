package com.prasath.ksprgates.dogboil;

import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String cpuchoice,mychoice;
    int score=0;
    String s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button btnleft=(Button)findViewById(R.id.left);
        Button btnright=(Button)findViewById(R.id.right);
        Button buttonstart=(Button)findViewById(R.id.buttonstart);
        final  ImageView imageView=(ImageView)findViewById(R.id.imageview);
        final TextView textView=(TextView)findViewById(R.id.textView);
        final TextView textView1=(TextView)findViewById(R.id.textView2);
        final TextView tv3=(TextView)findViewById(R.id.textView3);

        btnleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mychoice="left";
                calculate();
          //      textView.setText(score);
           //       Drawable po=imageView.getDrawable();
           //     String hh=po.getCurrent().toString();
           //     Toast.makeText(MainActivity.this, hh, Toast.LENGTH_SHORT).show();
                textView.setText(String.valueOf(score));
                textView1.setText(s);



            }
        });

        btnright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mychoice="right";
                calculate();
             //   textView.setText(score);
                textView.setText(String.valueOf(score));

            }
        });



        buttonstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Handler handler = new Handler();
                final Random random = new Random();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        int y = random.nextInt(2);

                        if(y==0)
                        {
                            cpuchoice="left";
                           imageView.setImageResource(R.drawable.l);

                        }
                        else if(y==1)
                        {
                            cpuchoice="right";
                            imageView.setImageResource(R.drawable.r);

                        }

                        handler.postDelayed(this, 1200);
                    }
                };
                handler.post(runnable);

            }
        });




    }

    private void calculate() {

        if(mychoice.equals("right") && cpuchoice.equals("right"))
        {
            score+=1;
         //   Toast.makeText(this, "Win", Toast.LENGTH_SHORT).show();
            s = "Win";
            ImageView imageView=findViewById(R.id.imageview);
            imageView.setImageResource(R.drawable.successrunright);
            AnimationDrawable runcat=(AnimationDrawable)imageView.getDrawable();
            runcat.start();
        }
        else if(mychoice.equals("right") && cpuchoice.equals("left"))
        {
            score-=1;
            s = "Loss";
         //   Toast.makeText(this, "lose", Toast.LENGTH_SHORT).show();
            ImageView imageView=findViewById(R.id.imageview);
            imageView.setImageResource(R.drawable.rightfail);
            AnimationDrawable runcat=(AnimationDrawable)imageView.getDrawable();
            runcat.start();
        }
        else if(mychoice.equals("left") && cpuchoice.equals("left"))
        {
            score+=1;
         //   Toast.makeText(this, "Win", Toast.LENGTH_SHORT).show();
           s = "Win";
            ImageView imageView=findViewById(R.id.imageview);
            imageView.setImageResource(R.drawable.successrun);
            AnimationDrawable runcat=(AnimationDrawable)imageView.getDrawable();
            runcat.start();
        }
        else if(mychoice.equals("left") && cpuchoice.equals("right"))
        {
            score-=1;
        //    Toast.makeText(this, "lose", Toast.LENGTH_SHORT).show();
             s = "Loss";
            ImageView imageView= findViewById(R.id.imageview);
            imageView.setImageResource(R.drawable.leftfail);
            AnimationDrawable runcat=(AnimationDrawable)imageView.getDrawable();
            runcat.start();
        }
    }
}
