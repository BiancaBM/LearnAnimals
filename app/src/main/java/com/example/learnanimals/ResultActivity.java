package com.example.learnanimals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private Button reloadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle b = getIntent().getExtras();
        int value = 0; // or other values
        if(b != null)
            value = b.getInt("score");

        TextView resultView = findViewById(R.id.resultView);
        resultView.setText("" + value);

        reloadBtn = findViewById(R.id.reloadBtn);

        reloadBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                GoToMainScreen();
            }
        });
    }

    private void GoToMainScreen(){
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }
}
