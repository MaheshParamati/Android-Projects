package com.projects.kartheek.contactmanager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class Activity_AddContact extends ActionBarActivity {
      EditText fname,lname,phone,Email;
 String Mod_fname="",Mod_lname="",Mod_phone="",Mod_email="";



    protected void onCreate(Bundle savedInstanceState)
    {
       final SaveContact s= new SaveContact();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__add_contact);
      /*  Intent g=getIntent();
        String data=g.getStringExtra("Transfer");
        String[] br= data.split("\t");
        Mod_fname=br[0];
        Mod_lname=br[1];
        Mod_phone=br[2];
        Mod_email=br[3];

        fname.setText(Mod_fname);
        lname.setText(Mod_lname);
        phone.setText(Mod_phone);
        Email.setText(Mod_email);


*/
        final Button save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                fname = (EditText) findViewById(R.id.editText);
                lname = (EditText) findViewById(R.id.editText2);
                phone = (EditText) findViewById(R.id.editText3);
                Email = (EditText) findViewById(R.id.editText4);

                String first=fname.getText().toString();
                String last=lname.getText().toString();
                String number=phone.getText().toString();
                String email=Email.getText().toString();
                String Combined=first+"\t"+last+"\t"+number+"\t"+email+"\n";

                try {
                    System.out.println("Starts here");
                //    OutputStreamWriter outputStreamWriter  = new OutputStreamWriter(openFileOutput("Contacts.txt", Context.MODE_PRIVATE));
                //    outputStreamWriter.write(first+"\t"+last+"\t"+phone+"\t"+email);
                //    outputStreamWriter.close();
                //    System.out.println("Reached here");
                  FileOutputStream fou = openFileOutput("Contact.txt",Context.MODE_APPEND);
                 //   OutputStreamWriter os = new OutputStreamWriter(fou);
                   fou.write(Combined.getBytes());
                    System.out.println(first + "\t" + last + "\t" + number + "\t" + email);
            //        os.flush();
             //       os.close();
                    Toast.makeText(getBaseContext(),"Data Saved",Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                fname.setText("");
                lname.setText("");
                phone.setText("");
                Email.setText("");
                finish();

            }
        });

    }}