package com.example.unitalk;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ViewThreadActivity extends AppCompatActivity {

    TextView strJudul, strKonten;
    ImageButton buttonComment, buttonLike;
    CreateThread t1 = new CreateThread();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_thread);

        strJudul = findViewById(R.id.judul);
        strKonten = findViewById(R.id.konten);
        buttonComment =  (ImageButton) findViewById(R.id.comment);

        Intent intent = getIntent();
        String Judul = intent.getStringExtra("message_key1");
        String Konten = intent.getStringExtra("message_key2");

        strJudul.setText(Judul);
        strKonten.setText(Konten);
        buttonComment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openComment();

            }
        });
    }

    public void customClick(View view) {
        buttonLike =  (ImageButton) findViewById(R.id.like);
        buttonLike.setSelected(!buttonLike.isSelected());

        if (buttonLike.isSelected()) {
            buttonLike.setSelected(true);
        } else {
            buttonLike.setSelected(false);
        }
        Toast.makeText(this, "like", Toast.LENGTH_SHORT).show();
    }

    public void openComment() {
        Intent intent = new Intent(this, Comment.class);
        startActivity(intent);
    }
}