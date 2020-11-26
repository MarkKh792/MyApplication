package com.example.dbpoezdov;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class UpdateChed extends AppCompatActivity {

    EditText ChTrain_input1, ChMarshrut_input1, ChDay_input1, ChPribil_input1, ChYedet_input1, ChWay_input1, ChPlatform_input1, ChVagonov_input1, ChMest_input1;
    Button UpdateCh_button, DeleteCh_button;

    private EditText text1, text2, text3, text4, text5, text6, text7;

    String IDCh, TrainCh, WayCh, DayCh, PribilCh, YedetCh, PutCh, PlatformCh, VagonCh, MestCh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_ched);

        ChTrain_input1 = findViewById(R.id.ChTrain_input);
        ChMarshrut_input1 = findViewById(R.id.ChMarshrut_input);
        ChDay_input1 = findViewById(R.id.ChDay_input);
        ChPribil_input1 = findViewById(R.id.ChPribil_input);
        ChYedet_input1 = findViewById(R.id.ChYedet_input);
        ChWay_input1 = findViewById(R.id.ChWay_input);
        ChPlatform_input1 = findViewById(R.id.ChPlatform_input);
        ChVagonov_input1 = findViewById(R.id.ChVagonov_input);
        ChMest_input1 = findViewById(R.id.ChMest_input);
        UpdateCh_button = findViewById(R.id.UpdateCh_button);
        DeleteCh_button = findViewById(R.id.DeleteCh_button);

        ActivityCompat.requestPermissions(UpdateChed.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        text1 = findViewById(R.id.ChTrain_input);
        text2 = findViewById(R.id.ChMarshrut_input);
        text3 = findViewById(R.id.ChDay_input);
        text4 = findViewById(R.id.ChPribil_input);
        text5 = findViewById(R.id.ChYedet_input);
        text6 = findViewById(R.id.ChWay_input);
        text7 = findViewById(R.id.ChPlatform_input);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(TrainCh);
        }

        UpdateCh_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateChed.this);
                TrainCh = ChTrain_input1.getText().toString().trim();
                WayCh = ChMarshrut_input1.getText().toString().trim();
                DayCh = ChDay_input1.getText().toString().trim();
                PribilCh = ChPribil_input1.getText().toString().trim();
                YedetCh = ChYedet_input1.getText().toString().trim();
                PutCh = ChWay_input1.getText().toString().trim();
                PlatformCh = ChPlatform_input1.getText().toString().trim();
                VagonCh = ChVagonov_input1.getText().toString().trim();
                MestCh = ChMest_input1.getText().toString().trim();
                myDB.updateChedData(IDCh, TrainCh, WayCh, DayCh, PribilCh, YedetCh, PutCh, PlatformCh, VagonCh, MestCh);
            }
        });
        DeleteCh_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("IDCh") &&  getIntent().hasExtra("WayCh") && getIntent().hasExtra("DayCh") &&
                getIntent().hasExtra("PribilCh") && getIntent().hasExtra("YedetCh")&&
                getIntent().hasExtra("PutCh")&& getIntent().hasExtra("PlatformCh")&&
                getIntent().hasExtra("VagonCh")&& getIntent().hasExtra("MestCh")){
            //Getting Data from Intent
            IDCh = getIntent().getStringExtra("IDCh");
            TrainCh = getIntent().getStringExtra("TrainCh");
            WayCh = getIntent().getStringExtra("WayCh");
            DayCh = getIntent().getStringExtra("DayCh");
            PribilCh = getIntent().getStringExtra("PribilCh");
            YedetCh = getIntent().getStringExtra("YedetCh");
            PutCh = getIntent().getStringExtra("PutCh");
            PlatformCh = getIntent().getStringExtra("PlatformCh");
            VagonCh = getIntent().getStringExtra("VagonCh");
            MestCh = getIntent().getStringExtra("MestCh");

            //Setting Intent Data
            ChTrain_input1.setText(TrainCh);
            ChMarshrut_input1.setText(WayCh);
            ChDay_input1.setText(DayCh);
            ChPribil_input1.setText(PribilCh);
            ChYedet_input1.setText(YedetCh);
            ChWay_input1.setText(PutCh);
            ChPlatform_input1.setText(PlatformCh);
            ChVagonov_input1.setText(VagonCh);
            ChMest_input1.setText(MestCh);
            Log.d("stev", TrainCh+" "+WayCh+" "+DayCh+" "+PribilCh+" "+YedetCh+" "+PutCh+" "+PlatformCh+" "+VagonCh+" "+MestCh);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    public void createMyPDF(View view){

        PdfDocument myPdfDocument = new PdfDocument();
        PdfDocument.PageInfo myPageInfo = new PdfDocument.PageInfo.Builder(300,600,1).create();
        PdfDocument.Page myPage = myPdfDocument.startPage(myPageInfo);

        Paint myPaint = new Paint();
        String myString = text1.getText().toString();
        String myString2 = text2.getText().toString();
        String myString3 = text3.getText().toString();
        String myString4 = text4.getText().toString();
        String myString5 = text5.getText().toString();
        String myString6 = text6.getText().toString();
        String myString7 = text7.getText().toString();

        int x = 130, y=25;
        for (String line:myString.split("\n")){
            myPage.getCanvas().drawText(line, x, y, myPaint);
            y+=myPaint.descent()-myPaint.ascent();
        }
        myPage.getCanvas().drawText("Маршрут: " + myString2,10,50,myPaint);
        myPage.getCanvas().drawText("День: " + myString3,10,75,myPaint);
        myPage.getCanvas().drawText("Время прибытия: " + myString4,10,95,myPaint);
        myPage.getCanvas().drawText("Время отправления: " + myString5,10,115,myPaint);
        myPage.getCanvas().drawText("Номер пути: " + myString6,10,135,myPaint);
        myPage.getCanvas().drawText("Номер платформе: " + myString7,10,155,myPaint);


        myPdfDocument.finishPage(myPage);

        String myFilePath = Environment.getExternalStorageDirectory().getPath() + "/Download/" + "Расписание.pdf";
        File myFile = new File(myFilePath);
        try {
            myPdfDocument.writeTo(new FileOutputStream(myFile));
            Toast.makeText(this, "Добавлено в PDF", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){

        }

        myPdfDocument.close();
    }


    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Удалить заказ " + TrainCh + " ?");
        builder.setMessage("Вы действительно хотите удалить заказ " + TrainCh + " ?");
        builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateChed.this);
                myDB.deleteOneChedRow(IDCh);
                finish();
            }
        });
        builder.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}
