package com.cfg.codeforgood.kshamata;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class TwoFragment extends Fragment {

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

        emp = (EditText) container.findViewById(R.id.current_employer);
        sal1 = (EditText) container.findViewById(R.id.salary_when_she_joined);
        sal2 = (EditText) container.findViewById(R.id.current_salary);
        key = (EditText)container.findViewById(R.id.job_responisbilities);
        goals = (EditText) container.findViewById(R.id.future_goals);



        mRef = FirebaseDatabase.getInstance().getReference().child("women");

        submit = (Button) container.findViewById(R.id.submit);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


        return inflater.inflate(R.layout.fragment_two, container, false);
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
