package com.example.idea;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadData {
    public static String readFromFile(Context context, String filename){
        StringBuilder sb = new StringBuilder();
        File f = new File(context.getFilesDir(), filename);
        if (f.exists()){
            try {
                //Toast.makeText(context, "You are in read function", Toast.LENGTH_SHORT).show();
                FileInputStream fin = context.openFileInput(filename);
                InputStreamReader inputStreamReader = new InputStreamReader(fin);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line;
                while((line = bufferedReader.readLine()) != null){
                    sb.append(line).append("\n");
                }
                fin.close();
            } catch (IOException e) {
                Toast.makeText(context, "Exception occur", Toast.LENGTH_SHORT).show();;
            }
        }
        else{
            Toast.makeText(context, "Account not Exist, Please create new account", Toast.LENGTH_SHORT).show();
        }

        return sb.toString();
    }
}
