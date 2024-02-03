package com.example.idea;

import android.content.Context;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class WriteData {
    public static void writeToFile(Context context, String data, String filename) {
        File file = new File(context.getFilesDir(), filename);
        if (file.exists()){
            Toast.makeText(context.getApplicationContext(), "Account Already Exist", Toast.LENGTH_SHORT).show();
        }
        else {
            try {
                FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos);
                outputStreamWriter.write(data);
                outputStreamWriter.close();
                Toast.makeText(context, "Account Created", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                Toast.makeText(context, "Exception in Writing data", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
