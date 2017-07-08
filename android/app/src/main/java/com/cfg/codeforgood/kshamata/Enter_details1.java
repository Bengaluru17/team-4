package com.cfg.codeforgood.kshamata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Enter_details1 extends AppCompatActivity {
    DatabaseReference mRef;
    EditText name, dob, education;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_details1);

        name = (EditText) findViewById(R.id.person);
        dob = (EditText) findViewById(R.id.editText2);
        education = (EditText) findViewById(R.id.editText);
        mRef = FirebaseDatabase.getInstance().getReference().child("women");
    }
}
