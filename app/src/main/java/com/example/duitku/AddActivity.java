package com.example.duitku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import android.widget.Button;

public class AddActivity extends AppCompatActivity {
    TextView tvTanggal;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    String date;
    private onFragmentInteractionListener mListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        tvTanggal = findViewById(R.id.tvTanggal);
        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy");

        date = simpleDateFormat.format(calendar.getTime());

        tvTanggal.setText(date);
    }
}
