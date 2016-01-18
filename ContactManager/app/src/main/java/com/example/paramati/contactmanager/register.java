package com.example.paramati.contactmanager;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class register extends AppCompatActivity {

    EditText fn,ln,pn,email;
    Button s;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("0");
        super.onCreate(savedInstanceState);
        System.out.println("1");
        setContentView(R.layout.activity_register);
        fn=(EditText)findViewById(R.id.firstname);
        ln=(EditText)findViewById(R.id.lastname);
        pn=(EditText)findViewById(R.id.phonenumber);
        email=(EditText)findViewById(R.id.emailid);
        System.out.println("2");
        s=(Button)findViewById(R.id.save);
        System.out.println("3");
        s.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                System.out.println("save button clicked");
                message = fn.getText().toString();
                try {
                    // FileOutputStream fout1 = new FileOutputStream("C:\\Users\\paramati\\AndroidStudioProjects\\ContactManager\\contactlist.txt");
                    FileOutputStream fout = openFileOutput("C:\\Users\\paramati\\AndroidStudioProjects\\ContactManager\\contactlist.txt", MODE_WORLD_WRITEABLE);
                    System.out.println("File created");
                    OutputStreamWriter out = new OutputStreamWriter(fout);
                    out.write(message);
                    System.out.println("wrote into the file");
                    out.flush();
                    Toast.makeText(getBaseContext(), "Data Saved", Toast.LENGTH_LONG).show();
                    System.out.println("Toasted");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
//        s.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.println("save button clicked");
//                content = fn.getText().toString();
//                try {
//                   // FileOutputStream fout1 = new FileOutputStream("C:\\Users\\paramati\\AndroidStudioProjects\\ContactManager\\contactlist.txt");
//                    FileOutputStream fout = openFileOutput("C:\\Users\\paramati\\AndroidStudioProjects\\ContactManager\\contactlist.txt", MODE_WORLD_WRITEABLE);
//                    System.out.println("File created");
//                    OutputStreamWriter out = new OutputStreamWriter(fout);
//                    out.write(content);
//                    System.out.println("wrote into the file");
//                    out.flush();
//                    Toast.makeText(getBaseContext(), "Data Saved", Toast.LENGTH_LONG).show();
//                    System.out.println("Toasted");
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });


    }

}
