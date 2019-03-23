package com.example.myfirstapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.sip.SipSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    public static final String EXTRA_TEXT  ="com.example.myfirstapp.EXTRA_TEXT";
    public static final String EXTRA_TEXT2 ="com.example.myfirstapp.EXTRA_TEXT2";
    public static final String EXTRA_TEXT3 ="com.example.myfirstapp.EXTRA_TEXT3";
    public static final String EXTRA_TEXT4 ="com.example.myfirstapp.EXTRA_TEXT4";
    public static final String EXTRA_TEXT5 ="com.example.myfirstapp.EXTRA_NUMBER";
    private Button btn3;
    private TextView dateText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn3=(Button)findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendActivity();
            }
        });
        dateText=findViewById(R.id.tarihtext);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

    }

    private void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    public void sendActivity(){
        Intent intent =new Intent(this,display.class);

        EditText editText1=(EditText) findViewById(R.id.isim);
        String text=editText1.getText().toString();
        EditText editText2=(EditText) findViewById(R.id.soyisim);
        String text2=editText2.getText().toString();
        EditText editText3=(EditText) findViewById(R.id.dogumyeri);
        String text3=editText3.getText().toString();
        TextView textView=(TextView) findViewById(R.id.tarihtext);
        String text4=textView.getText().toString();
        EditText editText5=(EditText) findViewById(R.id.kimlik);
        String text5=editText5.getText().toString();

        intent.putExtra(EXTRA_TEXT,text);
        intent.putExtra(EXTRA_TEXT2,text2);
        intent.putExtra(EXTRA_TEXT3,text3);
        intent.putExtra(EXTRA_TEXT4,text4);
        intent.putExtra(EXTRA_TEXT5,text5);


        startActivity(intent);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = "gün/ay/yıl: " + dayOfMonth + "/" + (month+1) + "/" + year;
        dateText.setText(date);
    }
}
