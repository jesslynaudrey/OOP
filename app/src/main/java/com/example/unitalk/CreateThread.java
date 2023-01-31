package com.example.unitalk;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Scanner;
import java.io.*;
import java.sql.*;

public class CreateThread extends AppCompatActivity {
//    EditText myInput;
//    MyDBHandler DBHandler;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        EditText title = findViewById(R.id.title);
//        EditText content = findViewById(R.id.content);
//    }


    EditText editTitle, editContent;
    TextView result;
    ImageButton buttonPost;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    String hasilJudul, hasilKonten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_thread);

        editTitle = (EditText) findViewById(R.id.title);
        editContent = (EditText) findViewById(R.id.content);
        result = (TextView) findViewById(R.id.result);
        buttonPost = (ImageButton) findViewById(R.id.post);
    /*
        Submit Button
    */
        buttonPost.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                hasilJudul = editTitle.getText().toString();
                hasilKonten = editContent.getText().toString();
                if(hasilJudul.isEmpty()){
                    Toast.makeText(CreateThread.this, "Masukan Judul!", Toast.LENGTH_SHORT).show();
                }else if(hasilKonten.isEmpty()){
                    Toast.makeText(CreateThread.this, "Masukan Konten!", Toast.LENGTH_SHORT).show();
                }else{
                    database.child("Thread").push().setValue(new ModelThread(hasilJudul, hasilKonten));
                    openActivityView();
                }
            }

        });

    /*
        Reset Button
    */
//        buttonReset.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                editName.setText("");
//                editPassword.setText("");
//                result.setText("");
//                editName.requestFocus();
//            }
//        });
    }

    public void openActivityView() {
        Intent intent = new Intent(CreateThread.this, MainActivity.class);
//        intent.putExtra("message_key1", hasilJudul);
//        intent.putExtra("message_key2", hasilKonten);
        startActivity(intent);
        finish();
    }
}