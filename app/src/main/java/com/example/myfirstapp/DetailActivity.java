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
        if( getIntent().hasExtra("head") && getIntent().hasExtra("detail") ){
            String head=getIntent().getStringExtra("head");
            String detail=getIntent().getStringExtra("detail");

            setComing(head,detail);
        }
    }

    private void setComing(String head, String detail){
        TextView text1=findViewById(R.id.courseHead);
        TextView text2=findViewById(R.id.courseDetail);

        text1.setText(head);
        text2.setText(detail);
    }

}
