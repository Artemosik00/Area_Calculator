package com.mirea.kt.ribo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RectangleActivity extends AppCompatActivity implements View.OnClickListener {
    private String shareText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rectangle);

        Button btnShare = findViewById(R.id.btnShare);
        btnShare.setOnClickListener(this);
        Button btnCount = findViewById(R.id.btnCount);
        btnCount.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnCount){
            TextView tvResultArea = findViewById(R.id.resultArea);
            TextView tvResultPerimeter = findViewById(R.id.resultPerimeter);

            EditText etEnterSideA = findViewById(R.id.etEnterSideA);
            EditText etEnterSideB = findViewById(R.id.etEnterSideB);

            String sideA = etEnterSideA.getText().toString();
            String sideB = etEnterSideB.getText().toString();

            Integer intSideA = Integer.parseInt(sideA);
            Integer intSideB = Integer.parseInt(sideB);


            Integer resultArea = intSideA*intSideB;
            tvResultArea.setText(String.format("Площадь прямоугольника: %s", resultArea));

            Integer resultPerimeter = 2*intSideA*intSideB;
            tvResultPerimeter.setText(String.format("Периметр прямоугольника: %s", resultPerimeter));
            shareText = "Площадь прямоугольника : "+resultArea + "\n" + "Периметр прямоугольника : "+resultPerimeter;
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