package com.example.myfirstapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getIncomingIntent();
    }

    private void getIncomingIntent(){
            String head=getIntent().getStringExtra("head");
            String detail=getIntent().getStringExtra("detail");
            String ogrSayi=getIntent().getStringExtra("ogrSayi");
            String ortalama=getIntent().getStringExtra("ortalama");

            setComing(head,detail,ogrSayi,ortalama);

    }

    private void setComing(String head,String detail, String ogrSayi,String ortalama){
        TextView text1=findViewById(R.id.courseHead);
        TextView text2=findViewById(R.id.courseOgrSayi);
        TextView text3=findViewById(R.id.courseOrtalama);
        TextView text4=findViewById(R.id.courseDetail);

        text1.setText("Ders Kodu: " + head);
        text2.setText("Alan öğrenci sayısı: " + ogrSayi);
        text3.setText("Ders not ortalaması: " + ortalama);
        text4.setText("Dersin adı: " + detail);
    }

}
