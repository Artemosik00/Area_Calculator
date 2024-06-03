package com.mirea.kt.ribo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ListOfFigures extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_of_figures);

        ImageView squareImageView = findViewById(R.id.squareImage);
        ImageView rectangleImageView = findViewById(R.id.rectangleImage);
        ImageView triangleImageView = findViewById(R.id.triangleImage);
        ImageView rhombImageView = findViewById(R.id.rhombImage);
        ImageView trapezoidImageView = findViewById(R.id.trapezoidImage);
        ImageView circleImageView = findViewById(R.id.circleImage);

        squareImageView.setOnClickListener(this);
        rectangleImageView.setOnClickListener(this);
        triangleImageView.setOnClickListener(this);
        rhombImageView.setOnClickListener(this);
        trapezoidImageView.setOnClickListener(this);
        circleImageView.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.squareImage){
            Intent squareIntent = new Intent(this,SquareActivity.class);
            startActivity(squareIntent);
        }
        if (v.getId()==R.id.rectangleImage){
            Intent rectangleIntent = new Intent(this,RectangleActivity.class);
            startActivity(rectangleIntent);
        }
        if (v.getId()==R.id.triangleImage){
            Intent triangleIntent = new Intent(this,TriangleActivity.class);
            startActivity(triangleIntent);
        }
        if (v.getId()==R.id.rhombImage){
            Intent rhombIntent = new Intent(this,RhombActivity.class);
            startActivity(rhombIntent);
        }
        if (v.getId()==R.id.trapezoidImage){
            Intent trapezoidIntent = new Intent(this,TrapezoidActivity.class);
            startActivity(trapezoidIntent);
        }
        if (v.getId()==R.id.circleImage){
            Intent circleIntent = new Intent(this,CircleActivity.class);
            startActivity(circleIntent);
        }

    }
}