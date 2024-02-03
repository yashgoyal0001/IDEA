package com.example.idea;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class login extends AppCompatActivity {
    TextView forgot_password, create_new_account;
    EditText account_number, password;
    Button login_btn;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        create_new_account = findViewById(R.id.goto_signup_page);
        forgot_password = findViewById(R.id.forgot_password);
        account_number = findViewById(R.id.acc_number);
        password = findViewById(R.id.password);
        login_btn = findViewById(R.id.login_btn);
        builder = new AlertDialog.Builder(this);

        create_new_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, signup.class);
                startActivity(intent);
                finish();
            }
        });

        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(login.this, "Not write code", Toast.LENGTH_SHORT).show();
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(account_number.getText().toString().equals("") || password.getText().toString().equals("")){
                    builder.setTitle("Information Empty").setMessage("Kindly fill the given information").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else{
                    String readdata = ReadData.readFromFile(getApplicationContext(), account_number.getText().toString());
                    File file = new File(getFilesDir(), account_number.getText().toString());
                    if (file.exists()){
                        if (readdata.contains(password.getText().toString())){
                            Intent intent = new Intent(login.this, MainActivity.class);
                            intent.putExtra("id", account_number.getText().toString());
                            startActivity(intent);
                            finish();
                        }
                        else {
                            Toast.makeText(login.this, "Check password again...", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(login.this, "Account not Exist, Please create new account", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}