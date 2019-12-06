package com.example.duitku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.duitku.fragments.ResultFragment;

public class Main2Activity extends AppCompatActivity implements
        ResultFragment.OnFragmentInteractionListener{
    private ResultFragment resultFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        resultFragment = new ResultFragment();
    }

    @Override
    public void onTryAgainButtonClicked(String tag) {
        Intent  intent = new Intent(this, SisaUangActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Perhitungan Sisa Uang", Toast.LENGTH_SHORT).show();
    }
}
