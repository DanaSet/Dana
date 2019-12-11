package com.example.duitku;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    String[] tambah;
    ListView listTanggal;
    Menu menu;
    protected Cursor cursor;
    DataHelper dbKeuangan;
    public static Main2Activity main2Activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btnTambah = (Button)findViewById(R.id.btnTambah);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this,TambahTanggal.class);
                startActivity(i);
            }
        });
        main2Activity = this;
        dbKeuangan = new DataHelper(this);
        RefreshList();
    }

    protected void RefreshList() {
        SQLiteDatabase db = dbKeuangan.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM uang", null);
        tambah = new String[cursor.getCount()];
        cursor.moveToFirst();

        for (int cc=0; cc<cursor.getCount();cc++){
            cursor.moveToPosition(cc);
            tambah[cc] = cursor.getString(1).toString();
        }
        listTanggal = findViewById(R.id.listTanggal);
        listTanggal.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1, tambah));
        listTanggal.setSelected(true);
        listTanggal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = tambah[arg2];
                final CharSequence[] dialogItem = {"Detail"};
                AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                builder.setTitle("PIlihan");
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0:
                                Intent i = new Intent(getApplicationContext(), AddActivity.class);
                                i.putExtra("tanggal", selection);
                                startActivity(i);
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
        ((ArrayAdapter)listTanggal.getAdapter()).notifyDataSetInvalidated();
    }
}
