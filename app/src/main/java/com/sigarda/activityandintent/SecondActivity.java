package com.sigarda.activityandintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sigarda.activityandintent.models.Car;

public class SecondActivity extends AppCompatActivity {
    private TextView hasil,name,price,color;
    private LinearLayout car_container;
    private Button finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        hasil = findViewById(R.id.hasil);
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        color = findViewById(R.id.color);
        car_container = findViewById(R.id.car_container);
        finish = findViewById(R.id.finish);
        Intent i = getIntent();
        finish.setOnClickListener(send->{
            if(i.hasExtra("withresult")){
                Intent result = new Intent();
                Car car = (Car) i.getSerializableExtra("withresult");
                name.setText("Name : "+car.getName());
                price.setText("Price : "+car.getPrice());
                color.setText("Color : "+car.getColor());
                result.putExtra("result", car);
                setResult(Activity.RESULT_OK, result);
                finish();
            }
        });
        if(i.getExtras()!=null){
            if(i.hasExtra("dataku")){
                hasil.setText("get From Intent : "+i.getStringExtra("dataku"));
                car_container.setVisibility(View.GONE);
                hasil.setVisibility(View.VISIBLE);
            }
            else if(i.hasExtra("car")){
                car_container.setVisibility(View.VISIBLE);
                hasil.setVisibility(View.GONE);
                finish.setVisibility(View.GONE);
                Car car = (Car) i.getSerializableExtra("car");
                name.setText("Name : "+car.getName());
                price.setText("Price : "+car.getPrice());
                color.setText("Color : "+car.getColor());
            }
            else if(i.hasExtra("withresult")){
                car_container.setVisibility(View.VISIBLE);
                hasil.setVisibility(View.GONE);
                finish.setVisibility(View.VISIBLE);
                Car car = (Car) i.getSerializableExtra("withresult");
                name.setText("Name : "+car.getName());
                price.setText("Price : "+car.getPrice());
                color.setText("Color : "+car.getColor());
            }
        }

    }
}
