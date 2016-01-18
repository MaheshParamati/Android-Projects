package com.projects.kartheek.contactmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class Activity_List extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__list);
        String[] listitems=new String[100];
        String entirecontent="";
        try {
            FileInputStream fi= openFileInput("Contact.txt");
            int content;
            while ((content = fi.read()) != -1) {

                // convert to char and display it
                System.out.print((char) content);
                entirecontent=entirecontent+Character.toString((char)content);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
      //  String[] line=entirecontent.split("\n");


     //   String[] entry=entirecontent.split("\n");
      listitems=entirecontent.split("\n");
        int i=0;
  /*      for(String each_line: entry)
        {
            String[] each=each_line.split("\t");
            String fname=each[0];
            String lname=each[1];
            String no=each[2];
            String email=each[3];
            String text=fname+"\t"+lname+"\t"+no;
            listitems[i]=text;
            i++;
        }
*/
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.forlist, listitems);
        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewonclick, int position, long id) {

         //       TextView textView= (TextView) viewonclick;
         //       Intent t=new Intent(getBaseContext(),Activity_AddContact.class);
         //       t.putExtra("Transfer",textView.getText().toString());
         //       startActivity(t);
            }
        });
    }
    public  void addContact(View view)
    {
        Intent add= new Intent(this,Activity_AddContact.class);
        startActivity(add);


    }
}
