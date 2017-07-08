package com.cfg.codeforgood.kshamata;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class RegisterActivity extends AppCompatActivity {
    private EditText name,email,pwd;
    private Button registerButton;

    private ProgressDialog mProgress;
    private FirebaseAuth mAuth;
    private DatabaseReference mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        name = (EditText) findViewById(R.id.name_field);
        email = (EditText) findViewById(R.id.email_field);
        pwd = (EditText) findViewById(R.id.password_field);

        registerButton = (Button) findViewById(R.id.submit_button);

        mAuth = FirebaseAuth.getInstance();
        mProgress = new ProgressDialog(this);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRegister();
            }
        });



    }

    private void startRegister() {
        final String username = name.getText().toString();
        String mail = email.getText().toString();
        String password = pwd.getText().toString();


        if(!TextUtils.isEmpty(username) && !TextUtils.isEmpty(mail) && !TextUtils.isEmpty(password)){

            mProgress.setMessage("Signing up..");
            mProgress.show();
            mAuth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){

                        String UID = mAuth.getCurrentUser().getUid();

                        DatabaseReference current_user_db = mRef.child(UID);

                        current_user_db.child("name").setValue(username);
                        current_user_db.child("image").setValue("default");

                        mProgress.dismiss();

                        Intent mainIntnet = new Intent(RegisterActivity.this,Women_profie.class);
                        mainIntnet.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(mainIntnet);


                    }
                }
            });

        }


    }

}
