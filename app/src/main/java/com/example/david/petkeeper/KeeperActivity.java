package com.example.david.petkeeper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class KeeperActivity extends AppCompatActivity {

    private ImageView petImageView;
    private TextView petNameView;
    private TextView petBioView;
    private Bundle extras;
    private EditText petNameEdit;
    private EditText nickNameEdit;
    private EditText breedEdit;
    private EditText bioEdit;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keeper);

        petImageView = (ImageView) findViewById(R.id.petImageId);
        petNameView = (TextView) findViewById(R.id.nameEditId);
        petBioView = (EditText) findViewById(R.id.bioEditId);
        petNameEdit = (EditText) findViewById(R.id.nameEditId);
        nickNameEdit = (EditText) findViewById(R.id.nickNameEditId);
        breedEdit = (EditText) findViewById(R.id.breedEditId);
        bioEdit = (EditText) findViewById(R.id.bioEditId);
        saveButton = (Button) findViewById(R.id.saveButtonId);

        extras = getIntent().getExtras();
        setUp(extras.getString("animal"));

        // Save Pet
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Save pet info
                SharedPreferences sharedPref = getSharedPreferences("pet", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("name", petNameEdit.getText().toString());
                editor.putString("nickname", nickNameEdit.getText().toString());
                editor.putString("breed", breedEdit.getText().toString());
                editor.putString("bio", bioEdit.getText().toString());
                editor.apply();

                //DEBUGGING
                //Log.d("Pet Name:", sharedPref.getString("name", ""));

                // Toast alerts user that data is saved
                Toast.makeText(KeeperActivity.this, "Pet was saved successfully", Toast.LENGTH_LONG).show();

                // Exit to main activity
                startActivity(new Intent(KeeperActivity.this, MainActivity.class));
            }
        }); // saveButton onClick

    } // onCreate()

    public void setUp(String pet) {
        if (pet.equals("dog")) {
            petImageView.setImageDrawable(getResources().getDrawable(R.drawable.dog));
        } else if (pet.equals("cat")) {
            petImageView.setImageDrawable(getResources().getDrawable(R.drawable.cat));
        }
    } // setUp()


} // KeeperActivity


