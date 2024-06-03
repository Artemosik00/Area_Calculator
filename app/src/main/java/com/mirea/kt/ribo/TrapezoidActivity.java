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

public class TrapezoidActivity extends AppCompatActivity implements View.OnClickListener {
    private String shareText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_trapezoid);
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
            EditText etEnterSideC = findViewById(R.id.etEnterSideC);
            EditText etEnterSideD = findViewById(R.id.etEnterSideD);
            EditText etEnterHeight = findViewById(R.id.etEnterHeight);

            String sideA = etEnterSideA.getText().toString();
            String sideB = etEnterSideB.getText().toString();
            String sideC = etEnterSideC.getText().toString();
            String sideD = etEnterSideD.getText().toString();
            String Height = etEnterHeight.getText().toString();


            Double intSideA = Double.parseDouble(sideA);
            Double intSideB = Double.parseDouble(sideB);
            Double intSideC = Double.parseDouble(sideC);
            Double intSideD = Double.parseDouble(sideD);
            Double intHeight = Double.parseDouble(Height);


            Double resultArea = ((intSideB+intSideD)*intHeight)/2;
            tvResultArea.setText(String.format("Площадь трапеции: %s", resultArea));

            Double resultPerimeter = (intSideA+intSideB+intSideC+intSideD);
            tvResultPerimeter.setText(String.format("Периметр трапеции: %s", resultPerimeter));
            shareText = "Площадь трапеции : "+resultArea + "\n" + "Периметр трапеции : "+resultPerimeter;

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