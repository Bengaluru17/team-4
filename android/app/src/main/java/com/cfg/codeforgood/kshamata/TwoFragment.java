package com.cfg.codeforgood.kshamata;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class TwoFragment extends Fragment implements View.OnClickListener {

    DatabaseReference mRef;
    EditText emp,sal1,sal2,key,goals;
    Button submit;
    ProgressDialog mProgress;

    public int satisfaction_rating;
    public TwoFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_two,container,false);


        emp = (EditText) myView.findViewById(R.id.current_employer);
        sal1 = (EditText) myView.findViewById(R.id.salary_when_she_joined);
        sal2 = (EditText) myView.findViewById(R.id.current_salary);
        key = (EditText)myView.findViewById(R.id.job_responisbilities);
        goals = (EditText) myView.findViewById(R.id.future_goals);



        mRef = FirebaseDatabase.getInstance().getReference().child("women");

        submit = (Button) myView.findViewById(R.id.submit11);
        submit.setOnClickListener(this);



        return myView;
    }

    @Override
    public void onClick(View v) {
        final String emp1 = emp.getText().toString();
        final String sal_j = sal1.getText().toString();
        final String sal_c = sal2.getText().toString();
        final String key1 = key.getText().toString();
        final String goals1 = goals.getText().toString();

        if (!TextUtils.isEmpty(emp1) && !TextUtils.isEmpty(sal_j) && !TextUtils.isEmpty(sal_c) && !TextUtils.isEmpty(key1) && !TextUtils.isEmpty(goals1)){

            final DatabaseReference newPost = mRef.push();

            newPost.child("employer_name").setValue(emp1);
            newPost.child("joining_salary").setValue(sal_j);
            newPost.child("current_salary").setValue(sal_c);
            newPost.child("key").setValue(key1);
            newPost.child("goals").setValue(goals1);

        }


        // implements your things
    }


    public void onRadioButtonClicked(View view){
        // Is the button now checked?


        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton3:
                if (checked) {
                    satisfaction_rating = 1;

                    break;
                }
            case R.id.radioButton4:
                if (checked) {
                    satisfaction_rating = 2;

                    break;
                }
            case R.id.radioButton5:
                if (checked) {
                    satisfaction_rating = 3;

                    break;
                }
            case R.id.radioButton6:
                if (checked) {
                    satisfaction_rating = 4;

                    break;
                }

            case R.id.radioButton7:
                if (checked)
                {
                    satisfaction_rating = 5;

                    break;
                }
        }
    }


}
