package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button giris;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        giris=findViewById(R.id.button5);

        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

    private void login(){
        String s1,s2;
        EditText e1=findViewById(R.id.editText);
        EditText e2=findViewById(R.id.editText2);

        Intent intent =new Intent(this,Main2Activity.class);

        s1=e1.getText().toString();
        s2=e2.getText().toString();

        if(s1.equals("admin") && s2.equals("password")){
            startActivity(intent);
        }else{
            Toast.makeText(getApplication().getBaseContext(),"Bilgileri kontrol ediniz",Toast.LENGTH_SHORT).show();
        }
    }


}
