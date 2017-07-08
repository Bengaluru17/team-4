package com.example.dimpledoshi.kshamata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText  edUsername;EditText edPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edUsername = (EditText) findViewById(R.id.editText);
        edPassword= (EditText)findViewById(R.id.editText2);

    }
    public void disp(View view){
        String uname  = edUsername.getText().toString();
        String pass = edPassword.getText().toString();
        if(uname.equals("dd") && pass.equals("12"))
        {
            Intent intent = new Intent(this,main2.class);
            intent.putExtra("username",edUsername.getText().toString());
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Invalid Usename password pair.", Toast.LENGTH_SHORT).show();
        }
    }


    }

