package com.sigarda.activityandintent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sigarda.activityandintent.models.Car;

public class MainActivity extends AppCompatActivity {
    private Button pindah, withdata,withobject,withresult,dialnumber;
    private TextView hasil,name,price,color;
    private LinearLayout car_container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pindah = findViewById(R.id.pindah);
        withdata = findViewById(R.id.withdata);
        withobject = findViewById(R.id.withobject);
        withresult = findViewById(R.id.withresult);
        dialnumber = findViewById(R.id.dialnumber);
        car_container = findViewById(R.id.car_container);
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        color = findViewById(R.id.color);
        pindah.setOnClickListener(pindah->{
            Intent i = new Intent(this,SecondActivity.class);
            startActivity(i);
        });
        withdata.setOnClickListener(send->{
            Intent i = new Intent(this,SecondActivity.class);
            i.putExtra("dataku","Belajar Activity dan Intent");
            startActivity(i);
        });
        withobject.setOnClickListener(send->{
            Car car = new Car();
            car.setName("Land Rover Velar");
            car.setColor("White");
            car.setPrice("2.000.000.000");
            Intent i = new Intent(this,SecondActivity.class);
            i.putExtra("car",car);
            startActivity(i);
        });
        dialnumber.setOnClickListener(send->{
            Uri number = Uri.parse("tel:085733347719");
            Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
            startActivity(callIntent);
        });
        withresult.setOnClickListener(send->{
            Car car = new Car();
            car.setName("Land Rover Velar");
            car.setColor("White");
            car.setPrice("3.000.000.000");
            Intent i = new Intent(this,SecondActivity.class);
            i.putExtra("withresult",car);
            startActivityForResult(i,12);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 12) {

            if (resultCode == Activity.RESULT_OK) {
                if(data!=null) {
                    car_container.setVisibility(View.VISIBLE);
                    Car car = (Car) data.getSerializableExtra("result");
                    name.setText("Name : "+car.getName());
                    price.setText("Price : "+car.getPrice());
                    color.setText("Color : "+car.getColor());
                }
            }
        }

    }
}