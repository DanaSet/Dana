package com.example.duitku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddActivity extends AppCompatActivity {
    TextView tvTanggal;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    String date;

    private EditText etUang;
    private EditText etKebutuhan;
    private EditText etMakan;
    private EditText etUrgent;
    private EditText etTabungan;
    private TextView tvSisa;
    private Button btnHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        tvTanggal = findViewById(R.id.tvTanggal);
        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy");

        date = simpleDateFormat.format(calendar.getTime());

        tvTanggal.setText(date);

        etUang = findViewById(R.id.etUang);
        etKebutuhan = findViewById(R.id.etKebutuhan);
        etMakan = findViewById(R.id.etMakan);
        etUrgent = findViewById(R.id.etUrgent);
        etTabungan =findViewById(R.id.etTabungan);
        tvSisa = findViewById(R.id.tvSisa);
        btnHitung = findViewById(R.id.btnHitung);



        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(etUang.getText().toString());
                int b = Integer.parseInt(etKebutuhan.getText().toString());
                int c = Integer.parseInt(etMakan.getText().toString());
                int d = Integer.parseInt(etUrgent.getText().toString());
                int e = Integer.parseInt(etTabungan.getText().toString());
                int hasil = a-b-c-d+e;
                tvSisa.setText(Integer.toString(hasil));
            }
        });

    }
}
