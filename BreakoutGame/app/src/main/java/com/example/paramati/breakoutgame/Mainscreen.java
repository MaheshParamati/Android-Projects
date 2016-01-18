package com.example.paramati.breakoutgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class Mainscreen extends AppCompatActivity {


    float seekstatus=2;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);


        final SeekBar seek=(SeekBar) findViewById(R.id.seekBar);
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekstatus = (float)progress / 10;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
   public void callgameactivity(View view)
   {

       Intent a = new Intent(getBaseContext(), BreakoutGame.class);

       a.putExtra("seekstatus", ("" + seekstatus));

       startActivity(a);

   }
    public void tohighscore(View view)
    {
        Intent a = new Intent(Mainscreen.this, HighScore_Display.class);
        startActivity(a);
    }
}
