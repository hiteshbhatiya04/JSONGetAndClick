package com.example.hitesh.jsongetandclick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ShowDetails extends AppCompatActivity {

    TextView nam,dob,spouse,child,disc,country,height;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        //ArrayList<HashMap<String,String>> hh = (ArrayList<HashMap<String, String>>) getIntent().getSerializableExtra("det");
        String name= getIntent().getStringExtra("na");
        String dbb= getIntent().getStringExtra("db");
        String hei= getIntent().getStringExtra("he");
        String contry= getIntent().getStringExtra("co");
        String sps= getIntent().getStringExtra("sp");
        String chil= getIntent().getStringExtra("ch");
        String discr= getIntent().getStringExtra("di");

        nam = (TextView)findViewById(R.id.act_name);
        dob = (TextView)findViewById(R.id.act_dob);
        spouse = (TextView)findViewById(R.id.act_spouse);
        child = (TextView)findViewById(R.id.act_child);
        country = (TextView)findViewById(R.id.act_country);
        height = (TextView)findViewById(R.id.act_height);
        disc = (TextView)findViewById(R.id.act_disc);

        nam.setText(name);
        dob.setText(dbb);
        spouse.setText(sps);
        child.setText(chil);
        country.setText(contry);
        height.setText(hei);
        disc.setText(discr);
    }
}
