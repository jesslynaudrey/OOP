package com.example.unitalk;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Comment extends AppCompatActivity {

    EditText buatKomen;
    TextView isiKomen;
    ImageButton buatSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

//        buatKomen = findViewById(R.id.ketikKomen);
        isiKomen = findViewById(R.id.isiKomen);
        buatSend = findViewById(R.id.send);

        buatSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isiKomen.setText(buatKomen.getText().toString());

            }
        });

    }
}