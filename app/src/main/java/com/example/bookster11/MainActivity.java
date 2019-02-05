package com.example.bookster11;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.view.animation.AlphaAnimation;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started.");

        ListView mListView = (ListView) findViewById(R.id.listView);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Bookster");
        setSupportActionBar(toolbar);
        fadeIn(toolbar);
        //toolbar.setSubtitle("Toolbar");




        //Create Category objects
        Category school = new Category("School", "Books, Calculators, map","15 ads", "drawable://" + R.drawable.book);
        Category electronics = new Category("Electronics", "phones, laptops, watches, etc.", "7 ads", "drawable://" + R.drawable.electronics);
        Category clothing = new Category("Clothing", "Shoes, Jeans, Dresses, etc.", "32 ads", "drawable://" + R.drawable.clothing);
        Category gaming = new Category("Gaming","Consoles, Games, Controllers, etc.", "3 ads", "drawable://" + R.drawable.gaming);
        Category food = new Category("Food", "KFC, Subway, Marios, Pita Pit, Rituals", "10 ads", "drawable://" + R.drawable.food);

        //Add the categories objects to an ArrayList
        final ArrayList<Category> categoryList = new ArrayList<>();
        categoryList.add(school);
        categoryList.add(electronics);
        categoryList.add(clothing);
        categoryList.add(gaming);
        categoryList.add(food);




        CategoryListAdapter adapter = new CategoryListAdapter(this, R.layout.adapter_view_layout, categoryList);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent myintent = new Intent(view.getContext(), SchoolActivity.class);
                    startActivityForResult(myintent, 0);
                }
            }
        });
    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Respond to menu item clicks
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
//            case R.id.miCompose:
//                Toast.makeText(
//                        getApplicationContext(),
//                        "You clicked the compose button.",
//                        Toast.LENGTH_SHORT)
//                        .show();
//                return true;
            case R.id.miProfile:
                Toast.makeText(
                        getApplicationContext(),
                        "Please login to view profile.",
                        Toast.LENGTH_SHORT)
                        .show();
                return true;
//            case R.id.action_settings:
//                Toast.makeText(
//                        getApplicationContext(),
//                        "You clicked the settings button.",
//                        Toast.LENGTH_SHORT)
//                        .show();
//                return true;
//            case R.id.action_login:
//                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
//                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void fadeIn(View view) {
        // Create an AlphaAnimation variable
        // 0.0f makes the view invisible
        // 1.0f makes the view fully visible
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        // Set out long you want the animation to be. * Measured in milliseconds *
        // 1000 milliseconds = 1 second
        anim.setDuration(1500);
        // Start the animation on our passed in view
        view.startAnimation(anim);
        /*  After the animation is complete we want to make sure we set the visibility of the view
            to VISIBLE. Otherwise it will go back to being INVISIBLE due to our previous lines
            that set the view to INVISIBLE */
        view.setVisibility(View.VISIBLE);
    }


}

