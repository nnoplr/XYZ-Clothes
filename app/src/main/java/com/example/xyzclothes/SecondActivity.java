package com.example.xyzclothes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tipe2, warna2, ukuran2;
    ImageView gambar;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        gambar=(ImageView)findViewById(R.id.gambar);

        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        String color = intent.getStringExtra("color");
        String size = intent.getStringExtra("size");

        if(type.equals("Shirt")&&color.equals("Red")){
            gambar.setImageResource(R.drawable.redshirt);
        }

        else if(type.equals("Shirt")&&color.equals("Blue")){
            gambar.setImageResource(R.drawable.blueshirt);
        }

        else if(type.equals("Shirt")&&color.equals("Green")){
            gambar.setImageResource(R.drawable.greenshirt);
        }

        else if(type.equals("Pants")&&color.equals("Red")){
            gambar.setImageResource(R.drawable.redpants);
        }

        else if(type.equals("Pants")&&color.equals("Blue")){
            gambar.setImageResource(R.drawable.bluepants);
        }
        else if(type.equals("Pants")&&color.equals("Green")){
            gambar.setImageResource(R.drawable.greenpants);
        }
        else if(type.equals("Hat")&&color.equals("Red")){
            gambar.setImageResource(R.drawable.redhat);
        }
        else if(type.equals("Hat")&&color.equals("Blue")){
            gambar.setImageResource(R.drawable.bluehat);
        }
        else if(type.equals("Hat")&&color.equals("Green")){
            gambar.setImageResource(R.drawable.greenhats);
        }



        tipe2 = findViewById(R.id.tipe2);
        warna2 = findViewById(R.id.warna2);
        ukuran2 = findViewById(R.id.ukuran2);

        tipe2.setText(type);
        warna2.setText(color);
        ukuran2.setText(size);

    }

    public void savee(View view) {
//        String savetype = tipe2.getText().toString();
//        String savecolor = warna2.getText().toString();
//        String savesize = ukuran2.getText().toString();

        sharedPreferences = getSharedPreferences("SaveData",MODE_PRIVATE);


        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("ValueTipe",tipe2.getText().toString());
        editor.putString("ValueWarna",warna2.getText().toString());
        editor.putString("ValueUkuran",ukuran2.getText().toString());

        editor.apply();

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//        intent.putExtra("savetype", savetype);
//        intent.putExtra("savecolor", savecolor);
//        intent.putExtra("savesize", savesize);


        startActivity(intent);
    }


}
