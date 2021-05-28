package com.example.xyzclothes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

//Nama: Novika Lourdes Rosellini
//NIM: 2301901835

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    String type, color, size;

    //    String savetype, savecolor, savesize;
    String valuetipe, valuewarna, valueukuran;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences result= getSharedPreferences("SaveData",MODE_PRIVATE);

        valuetipe = result.getString("ValueTipe", null);
        valuewarna = result.getString("ValueWarna", null);
        valueukuran = result.getString("ValueUkuran", null);


         ArrayList<String> nama_tipe = new ArrayList<String>();
        ArrayList<String> nama_warna = new ArrayList<String>();
        ArrayList<String> nama_ukuran = new ArrayList<String>();

        spinner1=(Spinner)findViewById(R.id.tipee);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, nama_tipe);
        nama_tipe.add("Pick a type");
        nama_tipe.add("Shirt");
        nama_tipe.add("Pants");
        nama_tipe.add("Hat");
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);

        spinner2=(Spinner)findViewById(R.id.warnaa);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, nama_warna);
        nama_warna.add("Pick a color");
        nama_warna.add("Red");
        nama_warna.add("Green");
        nama_warna.add("Blue");
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        spinner3=(Spinner)findViewById(R.id.ukurann);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, nama_ukuran);
        nama_ukuran.add("Pick a size");
        nama_ukuran.add("S");
        nama_ukuran.add("M");
        nama_ukuran.add("L");
        nama_ukuran.add("XL");
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(this);

//        Intent intent = getIntent();
//        savetype = intent.getStringExtra("savetype");
//        savecolor = intent.getStringExtra("savecolor");
//        savesize = intent.getStringExtra("savesize");
//
//        type=String.valueOf(savetype);
//        color=String.valueOf(savecolor);
//        size=String.valueOf(savetype);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(parent.getId() == R.id.tipee)
        {
            type = parent.getItemAtPosition(position).toString();
//            Toast.makeText(parent.getContext(), type, Toast.LENGTH_SHORT).show();

        }
        if(parent.getId() == R.id.warnaa)
        {
            color = parent.getItemAtPosition(position).toString();
//            Toast.makeText(parent.getContext(), color, Toast.LENGTH_SHORT).show();

        }
        if(parent.getId() == R.id.ukurann)
        {
            size = parent.getItemAtPosition(position).toString();
//            Toast.makeText(parent.getContext(), size, Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void vieww(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("type", type);
        intent.putExtra("color", color);
        intent.putExtra("size", size);

        if(spinner1.getSelectedItemPosition() == 0 || spinner2.getSelectedItemPosition() == 0 || spinner3.getSelectedItemPosition() == 0)
        {
            Toast.makeText(view.getContext(),"You selected the default option", Toast.LENGTH_SHORT).show();
        }
        if(spinner1.getSelectedItemPosition() != 0 && spinner2.getSelectedItemPosition() != 0 && spinner3.getSelectedItemPosition() != 0)
        {
            startActivity(intent);
        }
    }

    public void loadd(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("type", valuetipe);
        intent.putExtra("color", valuewarna);
        intent.putExtra("size", valueukuran);


        if(valuetipe==null||valuewarna==null||valueukuran==null) {
            Toast.makeText(view.getContext(),"You have not save any customization", Toast.LENGTH_SHORT).show();

        }

        else{
            startActivity(intent);
        }

    }




}
