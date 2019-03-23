package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Bitmap;

public class display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();
        String text  = intent.getStringExtra(MainActivity.EXTRA_TEXT);
        String text2 = intent.getStringExtra(MainActivity.EXTRA_TEXT2);
        String text3 = intent.getStringExtra(MainActivity.EXTRA_TEXT3);
        String text4 = intent.getStringExtra(MainActivity.EXTRA_TEXT4);
        String text5 = intent.getStringExtra(MainActivity.EXTRA_TEXT5);

        TextView textView1 = (TextView) findViewById(R.id.isimt);
        TextView textView2 = (TextView) findViewById(R.id.soyisimt);
        TextView textView3 = (TextView) findViewById(R.id.dogumyerit);
        TextView textView4 = (TextView) findViewById(R.id.dogumtarihit);
        TextView textView5 = (TextView) findViewById(R.id.kimlikt);

        textView1.setText(text);
        textView2.setText(text2);
        textView3.setText(text3);
        textView4.setText(text4);
        textView5.setText(text5);

        ImageView image=(ImageView)findViewById(R.id.imageView2);
        Bundle extras = getIntent().getExtras();
        Bitmap bmp = (Bitmap) extras.getParcelable("imagebitmap");
        image.setImageBitmap(bmp );

    }
}
