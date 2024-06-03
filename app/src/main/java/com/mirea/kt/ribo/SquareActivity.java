package com.mirea.kt.ribo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SquareActivity extends AppCompatActivity implements View.OnClickListener{

    private String shareText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_square);

        Button btnCount = findViewById(R.id.btnCount);
        Button btnShare = findViewById(R.id.btnShare);
        btnCount.setOnClickListener(this);
        btnShare.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnCount){
            TextView tvResultArea = findViewById(R.id.resultArea);
            TextView tvResultPerimeter = findViewById(R.id.resultPerimeter);
            EditText etEnterSide = findViewById(R.id.etEnterSide);
            String side = etEnterSide.getText().toString();
            Integer intSide = Integer.parseInt(side);

            Integer resultArea = intSide*intSide;
            tvResultArea.setText(String.format("Площадь квадрта: %s", resultArea));

            Integer resultPerimeter = intSide*4;
            tvResultPerimeter.setText(String.format("Периметр квадрата: %s", resultPerimeter));

            shareText = "Площадь квадрата : "+resultArea + "\n" + "Периметр квадрата : "+resultPerimeter;
        }
        if (v.getId()==R.id.btnShare){
            if (!shareText.isEmpty()){
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT,shareText);
                startActivity(shareIntent);
            }

        }

    }
}