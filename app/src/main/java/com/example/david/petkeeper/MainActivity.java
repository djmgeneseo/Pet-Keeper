package com.example.david.petkeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView dogView;
    private ImageView catView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dogView = (ImageView) findViewById(R.id.dogId);
        catView = (ImageView) findViewById(R.id.catId);

        dogView.setOnClickListener(this); // this means it's registered to our custom
                                          // onClickListener, described in this activity
        catView.setOnClickListener(this);

    } // onCreate

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
    }
} // MainActivity
