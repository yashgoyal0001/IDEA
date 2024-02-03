package com.example.idea;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Authentication extends AppCompatActivity {
    TextView tvMessage;
    ImageButton btLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        tvMessage = findViewById(R.id.message);
        btLogin = findViewById(R.id.startbtn);

        BiometricManager  manager = BiometricManager.from(this);
        switch (manager.canAuthenticate()){
            case BiometricManager.BIOMETRIC_SUCCESS:
                tvMessage.setText("Click on Start Button");
                break;
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                tvMessage.setText("Device does not support Biometric");
                btLogin.setVisibility(View.GONE);
                break;
            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                tvMessage.setText("Authentication Failed");
                btLogin.setVisibility(View.GONE);
                break;
        }
        BiometricPrompt prompt = new BiometricPrompt(this, ContextCompat.getMainExecutor(this), new BiometricPrompt.AuthenticationCallback() {

            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
            }
             @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                 tvMessage.setText("Authentication Sucessful");
                 //Toast.makeText(getApplicationContext(), "Successfully Done", Toast.LENGTH_SHORT).show();
                 Intent intent = new Intent(Authentication.this, SplashScreen.class);
                 startActivity(intent);
                 finish();
             }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }
        });
        BiometricPrompt.PromptInfo info = new BiometricPrompt.PromptInfo.Builder().setTitle("Biometric").setNegativeButtonText("Cancel").build();
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prompt.authenticate(info);
            }
        });
        prompt.authenticate(info);
    }
}