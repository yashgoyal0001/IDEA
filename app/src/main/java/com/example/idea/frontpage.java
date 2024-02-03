package com.example.idea;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

public class frontpage extends AppCompatActivity {
    ImageView applogo;
    Button fbtn;
    CheckBox cb;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontpage);
        fbtn = findViewById(R.id.frontbutton);
        cb = findViewById(R.id.checkBox);
        applogo = findViewById(R.id.imageView);
        builder = new AlertDialog.Builder(this);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomin);
        applogo.startAnimation(animation);

        fbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb.isChecked()){
                    Intent intent = new Intent(frontpage.this, signup.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    builder.setTitle("Term and Conditions").setMessage("If you want to continue with this application then click the content and then continue.")
                            .setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }
        });

    }
}