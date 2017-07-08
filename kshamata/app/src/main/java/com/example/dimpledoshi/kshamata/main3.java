package com.example.dimpledoshi.kshamata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Dimple Doshi on 08-07-2017.
 */

public class main3 extends AppCompatActivity {
    private Spinner spinner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

    }
    public void disp3(View view ) {
        spinner1 = (Spinner) findViewById(R.id.spinner);
        Toast.makeText(this,
                "OnClickListener : " +
                        "\nSpinner 1 : "+ String.valueOf(spinner1.getSelectedItem()) ,
                Toast.LENGTH_SHORT).show();
        Intent i=new Intent(this,MapsActivity.class);
        startActivity(i);
    }
}