package com.example.duitku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.duitku.util.Sisa;
public class SisaUangActivity extends AppCompatActivity {
    public EditText etU, etM, etK, etT, etUr;
    public Button tombol;
    public TextView hasil;
    private onFragments
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sisa_uang);
        etU = (EditText) findViewById(R.id.etUang);
        etM = (EditText) findViewById(R.id.etMakan);
        etK = (EditText) findViewById(R.id.etKebutuhan);
        etM = (EditText) findViewById(R.id.etTabungan);
        etM = (EditText) findViewById(R.id.etUrgent);
        tombol = (Button) findViewById(R.id.btnOke);
        hasil = (TextView) findViewById(R.id.txthasil);

        tombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungSisa();
            }
        });

        Button
    }

    public void SetUpView(){

    }

    public void hitungSisa(){
        int angka1 = Integer.parseInt(etU + etT.getText().toString());
        int angka2 = Integer.parseInt(etM + etK + etUr.getText().toString());
        int yaitu = angka1 * angka2;

        hasil.setText("Luasnya adalah " +yaitu);
    }
}
