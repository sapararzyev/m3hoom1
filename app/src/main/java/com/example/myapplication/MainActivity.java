package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button send;
    EditText editTextTo,editTextSubject,editTextMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTo = (EditText) findViewById(R.id.editext1);
        editTextSubject = (EditText) findViewById(R.id.editext2);
        editTextMessage = (EditText) findViewById(R.id.editext3);
        send = findViewById(R.id.btn_b);

        openEmail();
        }

    private void openEmail() {
        send.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/html");
            intent.putExtra(Intent.EXTRA_EMAIL, editTextTo.getText().toString());
            intent.putExtra(Intent.EXTRA_SUBJECT, editTextSubject.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT, editTextMessage.getText().toString());
            startActivity(Intent.createChooser(intent, "Send Email"));
        });
    }
}

