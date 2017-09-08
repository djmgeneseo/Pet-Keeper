package com.example.david.petkeeper;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    ActionBar actionBar;
    private ImageView dogView;
    private ImageView catView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Nav Bar
        actionBar = getSupportActionBar();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayoutId);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                actionBar.setTitle(getResources().getString(R.string.app_name));
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                actionBar.setTitle(getResources().getString(R.string.app_name));
            }
        };

        mDrawerLayout.addDrawerListener(mDrawerToggle);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        LinearLayout row1 = (LinearLayout) findViewById(R.id.row1);

        row1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.closeDrawers();
                Toast.makeText(MainActivity.this, "Pet House Selected", Toast.LENGTH_SHORT).show();
            }
        }); // row1 onClick()

        // Dog or Cat home select screen
        dogView = (ImageView) findViewById(R.id.dogId);
        catView = (ImageView) findViewById(R.id.catId);

        dogView.setOnClickListener(this); // this means onClick is registered to our custom
                                          // onClickListener, described in this activity
        catView.setOnClickListener(this);

    } // onCreate

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    // Home Screen
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dogId:
//                Toast.makeText(MainActivity.this, "Dog", Toast.LENGTH_SHORT).show();
                // go to second activity
                Intent dogIntent = new Intent(MainActivity.this, KeeperActivity.class);
                dogIntent.putExtra("animal", "dog");
                startActivity(dogIntent);
                break;

            case R.id.catId:
//                Toast.makeText(MainActivity.this, "Cat", Toast.LENGTH_SHORT).show();
                // go to second activity
                Intent catIntent = new Intent(MainActivity.this, KeeperActivity.class);
                catIntent.putExtra("animal", "cat");
                startActivity(catIntent);
                break;

        } // switch
    } // onClick()
} // MainActivity
