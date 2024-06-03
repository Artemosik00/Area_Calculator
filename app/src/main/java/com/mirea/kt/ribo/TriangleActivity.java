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

public class TriangleActivity extends AppCompatActivity implements View.OnClickListener {
    private String shareText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_triangle);

        Button btnCount = findViewById(R.id.btnCount);
        Button btnShare = findViewById(R.id.btnShare);
        btnShare.setOnClickListener(this);
        btnCount.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnCount){
            TextView tvResultArea = findViewById(R.id.resultArea);
            TextView tvResultPerimeter = findViewById(R.id.resultPerimeter);

            EditText etEnterSideA = findViewById(R.id.etEnterSideA);
            EditText etEnterSideB = findViewById(R.id.etEnterSideB);
            EditText etEnterSideC = findViewById(R.id.etEnterSideC);
            EditText etEnterHeight = findViewById(R.id.etEnterHeight);

            String sideA = etEnterSideA.getText().toString();
            String sideB = etEnterSideB.getText().toString();
            String sideC = etEnterSideC.getText().toString();
            String Height = etEnterHeight.getText().toString();


            Double intSideA = Double.parseDouble(sideA);
            Double intSideB = Double.parseDouble(sideB);
            Double intSideC = Double.parseDouble(sideC);
            Double intHeight = Double.parseDouble(Height);

            if (((intSideA+intSideB)>=intSideC) && ((intSideB+intSideC)>=intSideA) && ((intSideA+intSideC)>=intSideB)){
                Double resultArea = (intSideC*intHeight)/2;
                tvResultArea.setText(String.format("Площадь прямоугольника: %s", resultArea));

                Double resultPerimeter = (intSideA+intSideB+intSideC);
                tvResultPerimeter.setText(String.format("Периметр прямоугольника: %s", resultPerimeter));

                shareText = "Площадь тругольника : "+resultArea + "\n" + "Периметр треугольника : "+resultPerimeter;
            }else {
                Toast.makeText(this,"Такого треугольника не существует",Toast.LENGTH_LONG).show();
            }

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