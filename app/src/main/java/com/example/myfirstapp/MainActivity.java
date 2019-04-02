package com.example.myfirstapp;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    public static final String EXTRA_TEXT  ="com.example.myfirstapp.EXTRA_TEXT";
    public static final String EXTRA_TEXT2 ="com.example.myfirstapp.EXTRA_TEXT2";
    public static final String EXTRA_TEXT3 ="com.example.myfirstapp.EXTRA_TEXT3";
    public static final String EXTRA_TEXT4 ="com.example.myfirstapp.EXTRA_TEXT4";
    public static final String EXTRA_TEXT5 ="com.example.myfirstapp.EXTRA_NUMBER";
    public static final String EXTRA_TEXT6 ="com.example.myfirstapp.EXTRA_NUMBER2";


    private Button btn2;
    private Button btn3;
    private TextView dateText;
    private ImageView imageview;
    private int GALLERY = 1, CAMERA = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestMultiplePermissions();

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
        imageview = (ImageView) findViewById(R.id.imageView);
        btn2=(Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPictureDialog();
            }
        });
        if(savedInstanceState!=null){
            EditText editText=(EditText)findViewById(R.id.isim);
            EditText editText2=(EditText)findViewById(R.id.soyisim);
            EditText editText3=(EditText)findViewById(R.id.dogumyeri);
            TextView editText4=(TextView)findViewById(R.id.tarihtext);
            EditText editText5=(EditText)findViewById(R.id.kimlik);
            EditText editText6=(EditText)findViewById(R.id.telno);

            editText.setText(savedInstanceState.getString("isim"));
            editText2.setText(savedInstanceState.getString("soyisim"));
            editText3.setText(savedInstanceState.getString("dogumyeri"));
            editText4.setText(savedInstanceState.getString("dogumtarihi"));
            editText5.setText(savedInstanceState.getString("kimlik"));
            editText6.setText(savedInstanceState.getString("telno"));
        }

    }

    private void showPictureDialog(){
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
        String[] pictureDialogItems = {
                "Galeriden seç",
                "Kameradan çek" };
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choosePhotoFromGallary();
                                break;
                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }

    public void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, GALLERY);
    }

    private void takePhotoFromCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == this.RESULT_CANCELED) {
            return;
        }
        if (requestCode == GALLERY) {
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
                    imageview.setImageBitmap(bitmap);

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Hata!", Toast.LENGTH_SHORT).show();
                }
            }

        } else if (requestCode == CAMERA) {
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            imageview.setImageBitmap(thumbnail);
        }
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
        EditText editText6=(EditText) findViewById(R.id.telno);
        String text6=editText6.getText().toString();


        intent.putExtra(EXTRA_TEXT,text);
        intent.putExtra(EXTRA_TEXT2,text2);
        intent.putExtra(EXTRA_TEXT3,text3);
        intent.putExtra(EXTRA_TEXT4,text4);
        intent.putExtra(EXTRA_TEXT5,text5);
        intent.putExtra(EXTRA_TEXT6,text6);

        imageview.buildDrawingCache();
        Bitmap image= imageview.getDrawingCache();
        Bundle extras = new Bundle();
        extras.putParcelable("imagebitmap", image);
        intent.putExtras(extras);

        startActivity(intent);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = "d/m/y: " + dayOfMonth + "/" + (month+1) + "/" + year;
        dateText.setText(date);
    }

    private void  requestMultiplePermissions(){
        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        // check if all permissions are granted
                        if (report.areAllPermissionsGranted()) {
                            Toast.makeText(getApplicationContext(), "All permissions are granted by user!", Toast.LENGTH_SHORT).show();
                        }

                        // check for permanent denial of any permission
                        if (report.isAnyPermissionPermanentlyDenied()) {
                            // show alert dialog navigating to Settings
                            //openSettingsDialog();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).
                withErrorListener(new PermissionRequestErrorListener() {
                    @Override
                    public void onError(DexterError error) {
                        Toast.makeText(getApplicationContext(), "Some Error! ", Toast.LENGTH_SHORT).show();
                    }
                })
                .onSameThread()
                .check();
    }

    @Override
    protected void onSaveInstanceState(Bundle outstate){
        super.onSaveInstanceState(outstate);

        outstate.putString("isim",findViewById(R.id.isim).toString());
        outstate.putString("soyisim",findViewById(R.id.soyisim).toString());
        outstate.putString("dogumyeri",findViewById(R.id.dogumyeri).toString());
        TextView text=(TextView)findViewById(R.id.tarihtext);
        outstate.putString("dogumtarihi",text.getText().toString());
        outstate.putString("kimliknumarasi",findViewById(R.id.kimlik).toString());


    }

}
