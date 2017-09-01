package com.example.david.petkeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

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


    } // onCreate()

    public void setUp(String pet) {
        if (pet.equals("dog")) {
            petImageView.setImageDrawable(getResources().getDrawable(R.drawable.dog));
        } else if (pet.equals("cat")) {
            petImageView.setImageDrawable(getResources().getDrawable(R.drawable.cat));
        }
    } // setUp()

} // KeeperActivity


