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

public class signup extends AppCompatActivity {

    TextView login;
    Button create_btn;
    EditText name, account_number, phone_no, password, confirm_password;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        login = findViewById(R.id.goto_login_page);
        create_btn = findViewById(R.id.create_acc_btn);
        name = findViewById(R.id.username);
        account_number = findViewById(R.id.acc_number);
        phone_no = findViewById(R.id.phone_number);
        password = findViewById(R.id.password);
        confirm_password = findViewById(R.id.confirm_password);
        builder = new AlertDialog.Builder(this);
        create_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().equals("") || account_number.getText().toString().equals("") || phone_no.getText().toString().equals("") ||password.getText().toString().equals("") ||confirm_password.getText().toString().equals("")){
                    builder.setTitle("Information Required").setMessage("Kindly fill the given information").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }else{
                    if (password.getText().toString().equals(confirm_password.getText().toString())){
                        WriteData.writeToFile(getApplicationContext(),name.getText().toString() + account_number.getText().toString() + phone_no.getText().toString() +  password.getText().toString() , account_number.getText().toString());
                        String readdata = ReadData.readFromFile(getApplicationContext(),account_number.getText().toString());
                        if (readdata.contains(name.getText().toString()) && readdata.contains(account_number.getText().toString()) &&  readdata.contains(phone_no.getText().toString()) && readdata.contains(password.getText().toString())){
                            Intent intent = new Intent(signup.this, MainActivity.class);
                            intent.putExtra("id", account_number.getText().toString());
                            startActivity(intent);
                           // Toast.makeText(signup.this, "Going to home page", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else {
                            Toast.makeText(signup.this, "Already Exist, Please Login", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(signup.this, "Password not same", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup.this, login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}