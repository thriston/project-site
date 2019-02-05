package com.example.bookster11;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class SchoolActivity extends AppCompatActivity {

    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);

        name = "School";


    }


}
