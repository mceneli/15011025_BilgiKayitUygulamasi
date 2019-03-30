package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class display extends AppCompatActivity {

    private Button btn4;
    String text6;
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
        text6 = intent.getStringExtra(MainActivity.EXTRA_TEXT6);

        TextView textView1 = (TextView) findViewById(R.id.isimt);
        TextView textView2 = (TextView) findViewById(R.id.soyisimt);
        TextView textView3 = (TextView) findViewById(R.id.dogumyerit);
        TextView textView4 = (TextView) findViewById(R.id.dogumtarihit);
        TextView textView5 = (TextView) findViewById(R.id.kimlikt);
        TextView textView6 = (TextView) findViewById(R.id.telnot);


        textView1.setText(text);
        textView2.setText(text2);
        textView3.setText(text3);
        textView4.setText(text4);
        textView5.setText(text5);
        textView6.setText(text6);

        ImageView image=(ImageView)findViewById(R.id.imageView2);
        Bundle extras = getIntent().getExtras();
        Bitmap bmp = (Bitmap) extras.getParcelable("imagebitmap");
        image.setImageBitmap(bmp );

        btn4=(Button)findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goActivity();
            }
        });
    }

    public void call(View v) {
        Uri number= Uri.parse("tel:"+ text6);
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(callIntent);
    }

    public void goActivity(){
        Intent intent =new Intent(this,CourseList.class);
        startActivity(intent);
    }
}
