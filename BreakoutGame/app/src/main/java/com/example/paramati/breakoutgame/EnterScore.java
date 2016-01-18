package com.example.paramati.breakoutgame;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class EnterScore extends AppCompatActivity { // This activity is for entering the username for score display

    EditText Name;

    String c;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_score);
        Intent l= getIntent();   // getting the intent of the previous activity
        TextView ass =(TextView)findViewById(R.id.textView);
        Bundle gt=getIntent().getExtras();
        c=gt.getString("Transfer");   // getting the intent value and storing it in a string written by Mahesh Paramati
        System.out.println(c);
        ass.setText("Your Score is "+l.getStringExtra("Transfer"));  // setting the textview with the score obtained
        Name = (EditText)findViewById(R.id.editText);
        Name.setHint("Enter your Name");
        final Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String entirecontent ="";
                entirecontent= Name.getText().toString()+"\t"+c+"\n";  // delimiting the content based on \t
                System.out.println(entirecontent);
                try {     // this concept of storing into the file is done by kartheek anumolu kxa152730

                    FileOutputStream fout = openFileOutput("Scor.txt", MODE_APPEND);
                    System.out.println("hai u have entered the file");
                    fout.write(entirecontent.getBytes());
                    //   System.out.println(entirecontent);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent q = new Intent(EnterScore.this, HighScore_Display.class);
                startActivity(q);  // starting the next activity
            }
        });



    }

}
