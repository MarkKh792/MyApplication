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

public class UpdateCargo extends AppCompatActivity {

    EditText caTrain_input1, caMarshrut_input1, caDay_input1, caPribil_input1, caYedet_input1, cargo_input1, weight_input1, caPrice_input1, caVagonov_input1, add_input1, addnt_input1;
    Button updateCargo_button, deleteCargo_button;

    private EditText text1, text2, text3, text4, text5, text6, text7, text8, text9;

    String IDCa, TrainCa, WayCa, DayCa, PribilCa, YedetCa, CargoCa, WeightCa, PriceCa, VagonovCa, AddCa, AddntCa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_cargo);

        caTrain_input1 = findViewById(R.id.caTrain_input);
        caMarshrut_input1 = findViewById(R.id.caMarshrut_input);
        caDay_input1 = findViewById(R.id.caDay_input);
        caPribil_input1 = findViewById(R.id.caPribil_input);
        caYedet_input1 = findViewById(R.id.caYedet_input);
        cargo_input1 = findViewById(R.id.cargo_input);
        weight_input1 = findViewById(R.id.weight_input);
        caPrice_input1 = findViewById(R.id.caPrice_input);
        caVagonov_input1 = findViewById(R.id.caVagonov_input);
        add_input1 = findViewById(R.id.add_input);
        addnt_input1 = findViewById(R.id.addnt_input);
        updateCargo_button = findViewById(R.id.updateCargo_button);
        deleteCargo_button = findViewById(R.id.deleteCargo_button);

        ActivityCompat.requestPermissions(UpdateCargo.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        text1 = findViewById(R.id.caTrain_input);
        text2 = findViewById(R.id.caMarshrut_input);
        text3 = findViewById(R.id.caDay_input);
        text4 = findViewById(R.id.caPribil_input);
        text5 = findViewById(R.id.caYedet_input);
        text6 = findViewById(R.id.cargo_input);
        text7 = findViewById(R.id.weight_input);
        text8 = findViewById(R.id.caPrice_input);
        text9 = findViewById(R.id.caVagonov_input);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(TrainCa);
        }

        updateCargo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateCargo.this);
                TrainCa = caTrain_input1.getText().toString().trim();
                WayCa = caMarshrut_input1.getText().toString().trim();
                DayCa = caDay_input1.getText().toString().trim();
                PribilCa = caPribil_input1.getText().toString().trim();
                YedetCa = caYedet_input1.getText().toString().trim();
                CargoCa = cargo_input1.getText().toString().trim();
                WeightCa = weight_input1.getText().toString().trim();
                PriceCa = caPrice_input1.getText().toString().trim();
                VagonovCa = caVagonov_input1.getText().toString().trim();
                AddCa = add_input1.getText().toString().trim();
                AddntCa = addnt_input1.getText().toString().trim();
                myDB.updateCargoData(IDCa, TrainCa, WayCa, DayCa, PribilCa, YedetCa, CargoCa, WeightCa, PriceCa, VagonovCa, AddCa, AddntCa);
            }
        });
        deleteCargo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("IDCa") && getIntent().hasExtra("TrainCa") && getIntent().hasExtra("WayCa") &&
                getIntent().hasExtra("DayCa") && getIntent().hasExtra("PribilCa")&&
                getIntent().hasExtra("YedetCa")&& getIntent().hasExtra("CargoCa")&&
                getIntent().hasExtra("WeightCa")&& getIntent().hasExtra("PriceCa")&&
                getIntent().hasExtra("VagonovCa")&& getIntent().hasExtra("AddCa")&& getIntent().hasExtra("AddntCa")){
            //Getting Data from Intent
            IDCa = getIntent().getStringExtra("IDCa");
            TrainCa = getIntent().getStringExtra("TrainCa");
            WayCa = getIntent().getStringExtra("WayCa");
            DayCa = getIntent().getStringExtra("DayCa");
            PribilCa = getIntent().getStringExtra("PribilCa");
            YedetCa = getIntent().getStringExtra("YedetCa");
            CargoCa = getIntent().getStringExtra("CargoCa");
            WeightCa = getIntent().getStringExtra("WeightCa");
            PriceCa = getIntent().getStringExtra("PriceCa");
            VagonovCa = getIntent().getStringExtra("VagonovCa");
            AddCa = getIntent().getStringExtra("AddCa");
            AddntCa = getIntent().getStringExtra("AddntCa");

            //Setting Intent Data
            caTrain_input1.setText(TrainCa);
            caMarshrut_input1.setText(WayCa);
            caDay_input1.setText(DayCa);
            caPribil_input1.setText(PribilCa);
            caYedet_input1.setText(YedetCa);
            cargo_input1.setText(CargoCa);
            weight_input1.setText(WeightCa);
            caPrice_input1.setText(PriceCa);
            caVagonov_input1.setText(VagonovCa);
            add_input1.setText(AddCa);
            addnt_input1.setText(AddntCa);
            Log.d("stev", TrainCa+" "+WayCa+" "+DayCa+" "+PribilCa+" "+YedetCa+" "+CargoCa+" "+WeightCa+" "+PriceCa+" "+VagonovCa+" "+AddCa+" "+AddntCa);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    public void createMyPDF_Cargo(View view){

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
        String myString8 = text8.getText().toString();
        String myString9 = text9.getText().toString();

        int x = 130, y=25;
        for (String line:myString.split("\n")){
            myPage.getCanvas().drawText(line, x, y, myPaint);
            y+=myPaint.descent()-myPaint.ascent();
        }
        myPage.getCanvas().drawText("Маршрут: " + myString2,10,50,myPaint);
        myPage.getCanvas().drawText("День: " + myString3,10,75,myPaint);
        myPage.getCanvas().drawText("Время прибытия: " + myString4,10,95,myPaint);
        myPage.getCanvas().drawText("Время отправления: " + myString5,10,115,myPaint);
        myPage.getCanvas().drawText("Наименование груза: " + myString6,10,135,myPaint);
        myPage.getCanvas().drawText("Масса груза: " + myString7,10,155,myPaint);
        myPage.getCanvas().drawText("Ценность груза: " + myString8,10,175,myPaint);
        myPage.getCanvas().drawText("Вагонов: " + myString9,10,195,myPaint);


        myPdfDocument.finishPage(myPage);

        String myFilePath = Environment.getExternalStorageDirectory().getPath() + "/Download/" + "РасписаниеГрузового.pdf";
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
        builder.setTitle("Удаление состава " + TrainCa + " из базы данных");
        builder.setMessage("Удалить состав " + TrainCa + " ?");
        builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateCargo.this);
                myDB.deleteOneCargoRow(IDCa);
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
