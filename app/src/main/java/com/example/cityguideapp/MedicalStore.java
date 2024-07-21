package com.example.cityguideapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.net.URL;
import java.util.List;

public class MedicalStore extends AppCompatActivity {
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        layout = findViewById(R.id.scroll_college);

        TextView nameView = findViewById(R.id.t1);

        nameView.setText("Medical Store");

        List<CityPlace> colleges = MainActivity.Instance.GetPlaces("pharmacy");

        for(CityPlace college : colleges) {
            addCard(college);
        }
    }

    private void addCard(CityPlace place) {
        final View view = getLayoutInflater().inflate(R.layout.entity_card, null);

        TextView nameView = view.findViewById(R.id.name);
        TextView addressView = view.findViewById(R.id.address);
        ImageView imageView = view.findViewById(R.id.img);

        try {
            URL url = new URL(place.imageUrl);
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            imageView.setImageBitmap(bmp);
        }
        catch (Exception e) {
            Log.e("Error", e.toString());
        }


        nameView.setText(place.name);
        addressView.setText(place.address);

        layout.addView(view);
    }
}