package com.example.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CourseList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList();

        ListItem listItem = new ListItem(
                "BLM1011",
                "AA",
                "Bilgisayar Bilimlerine Giriş 1",
                "99",
                "39"
        );
            listItems.add(listItem);

        ListItem listItem2 = new ListItem(
                "BLM1991",
                "AA",
                "İş Sağlığı ve Güvenliği",
                "45",
                "75"
        );
        listItems.add(listItem2);

        ListItem listItem3 = new ListItem(
                "MDB1031",
                "AA",
                "İleri İngilizce 1",
                "80",
                "74"
        );
        listItems.add(listItem3);

        ListItem listItem4 = new ListItem(
                "MAT1071",
                "AA",
                "Matematik 1",
                "180",
                "33"
        );
        listItems.add(listItem4);

        ListItem listItem5 = new ListItem(
                "FIZ1001",
                "AA",
                "Fizik 1",
                "150",
                "36"
        );
        listItems.add(listItem5);

        ListItem listItem6 = new ListItem(
                "MAT1320",
                "AA",
                "Lineer Cebir",
                "100",
                "65"
        );
        listItems.add(listItem6);

        adapter = new MyAdapter(listItems,this);
        recyclerView.setAdapter(adapter);
    }
}
