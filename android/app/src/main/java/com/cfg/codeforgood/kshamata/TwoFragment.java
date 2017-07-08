package com.cfg.codeforgood.kshamata;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;


public class TwoFragment extends Fragment {

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
