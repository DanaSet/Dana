package com.example.duitku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.widget.Toast;

public class AddActivity<onFragmentInteractionListener> extends AppCompatActivity {
    Cursor cursor;
    DataHelper dbKeuangan;

    TextView tvTanggal;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    String date;
    private onFragmentInteractionListener mListener;

    private EditText etUang;
    private EditText etKebutuhan;
    private EditText etMakan;
    private EditText etUrgent;
    private EditText etTabungan;
    private TextView tvSisa;
    private Button btnHitung;
    private Button btnOk;
    private Button btnSimpan;
    private Button btnDelete;

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
        btnOk=findViewById(R.id.btnOk);
        btnSimpan=findViewById(R.id.btnSimpan);
        btnDelete=findViewById(R.id.btnDelete);


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

        SQLiteDatabase db = dbKeuangan.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM uang WHERE tanggal = ''" + getIntent().getStringExtra("tvTanggal"),null);
        cursor.moveToFirst();

        if(cursor.getCount() > 0 ){
            cursor.moveToPosition(0);
            etUang.setText(cursor.getString(0).toString());
            etKebutuhan.setText(cursor.getString(1).toString());
            etMakan.setText(cursor.getString(2).toString());
            etUrgent.setText(cursor.getString(3).toString());
            etTabungan.setText(cursor.getString(4).toString());
        }

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbKeuangan.getWritableDatabase();
                db.execSQL("UPDATE uang SET uang = '"+ etUang.getText().toString() +"', uang_kebutuhan = '" + etKebutuhan.getText().toString()+ "', uang_makan = '" +etMakan.getText().toString()+ "', uang_urgent ='" +etUrgent.getText().toString()+ "'tabungan ='" +etTabungan.getText().toString() + "'");
                Toast.makeText(getApplicationContext(),"Selesai disimpan", Toast.LENGTH_SHORT).show();
                Main2Activity.main2Activity.RefreshList();
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbKeuangan.getWritableDatabase();
                db.execSQL("DELETE FROM uang WHERE tanggal ='" + getIntent().getStringExtra("tanggal") +"'");
                Toast.makeText(getApplicationContext(),"Data Telah Dihapus", Toast.LENGTH_SHORT).show();
                Main2Activity.main2Activity.RefreshList();
                finish();
            }
        });
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void handleOut(View view) {
        Intent intent =  new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
