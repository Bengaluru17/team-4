package com.example.dimpledoshi.kshamata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Dimple Doshi on 08-07-2017.
 */

public class main2 extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView tv = (TextView) findViewById(R.id.textView2);
        tv.setText("Kshamata seeks to promote an enabling environment where the survivors of trafficking, or those who are vulnerable to it, is able to choose and participate in her economic and social integration through a series of interventions leading to her empowerment and sustainable future!");
        //tv.setText(getIntent().getExtras().getString("username")+"!");
    }
    public void disp2(View view)
    {
        Intent intent = new Intent(this,main3.class);
        startActivity(intent);
    }
}
