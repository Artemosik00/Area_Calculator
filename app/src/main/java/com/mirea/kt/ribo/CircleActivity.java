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

public class CircleActivity extends AppCompatActivity implements View.OnClickListener{
    private String shareText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_circle);

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
            EditText etEnterSide = findViewById(R.id.etEnterRadius);

            String radius = etEnterSide.getText().toString();
            Double intRadius = Double.parseDouble(radius);

            Double resultArea = 3.14 * (intRadius*intRadius) ;
            tvResultArea.setText(String.format("Площадь окружности: %s", resultArea));

            Double resultPerimeter = 2 * intRadius * 3.14;
            tvResultPerimeter.setText(String.format("Периметр окружности: %s", resultPerimeter));
            shareText = "Площадь окружности : "+resultArea + "\n" + "Периметр окружности : "+resultPerimeter;
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