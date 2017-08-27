package com.example.jmush.android_session8_assignment_81;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ListView listView;
    Button btnAsc, btnDsc;
    ArrayAdapter<String> adapter;
    static ArrayList<String> data_source;
    String[] Months={"Jan","Feb","March","April","May","June","July","August","September"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAsc= (Button) findViewById(R.id.btnAscend);
        btnDsc= (Button) findViewById(R.id.btnDescend);
        listView=(ListView)findViewById(R.id.list_item);
        data_source=new ArrayList<String>(Arrays.asList(Months));
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data_source);
        listView.setAdapter(adapter);
        btnAsc.setOnClickListener(this);
        btnDsc.setOnClickListener(this);

    }
    // Comparator for Ascending Order
    public static Comparator<String> StringAscComparator = new Comparator<String>() {

        public int compare(String app1, String app2) {

            String stringName1 = app1;
            String stringName2 = app2;

            return stringName1.compareToIgnoreCase(stringName2);
        }
    };

    //Comparator for Descending Order
    public static Comparator<String> StringDescComparator = new Comparator<String>() {

        public int compare(String app1, String app2) {

            String stringName1 = app1;
            String stringName2 = app2;

            return stringName2.compareToIgnoreCase(stringName1);
        }
    };

    @Override
    public void onClick(View v) {

            switch(v.getId()) {
                case R.id.btnAscend :
                    Collections.sort(data_source, StringAscComparator);
                    Toast.makeText(MainActivity.this, "Sorting in Ascending Order", Toast.LENGTH_LONG).show();
                    break;
                case R.id.btnDescend :
                    Collections.sort(data_source, StringDescComparator);
                    Toast.makeText(MainActivity.this, "Sorting in Descending Order", Toast.LENGTH_LONG).show();
                    break;
            }
            adapter.notifyDataSetChanged();

        }
}