package com.projects.kartheek.contactmanager;
import android.content.Context;

import java.io.*;
/**
 * Created by Kartheek on 01-11-2015.
 */
public class SaveContact {
    public SaveContact()
    {}

    public void insert(String first,String last,String phone, String email) throws Exception
    {

        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Kartheek\\AndroidStudioProjects\\ContactManager\\app\\src\\main\\java\\com\\projects\\kartheek\\contactmanager\\Contacts.txt")));
        writer.println();
        System.out.println(first + "\t" + last + "\t" + phone + "\t" + email);
        writer.close();

    }

public static void main(String args[])throws Exception
{}
}