package com.example.tuangb.customdialog;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
   final String[] color ={"Red","Blue","Black"};
   private  String coloCheck="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showDatePicker(View view){
        //B1 lấy ngày tháng năm hiện tại
        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);
        int currentMonth = cal.get(Calendar.MONTH);
        int currtentDay = cal.get(Calendar.DAY_OF_MONTH);

        //B2 xây dựng datepicker dialog
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                Toast.makeText(MainActivity.this, "Date"+year+"/"+(month+1)+"/"+day, Toast.LENGTH_SHORT).show();

            }
        },currentYear,currentMonth,currentYear);
        //B3 hiện thị và xử lí khi thay đổi date
        dialog.show();
    }
    public void showTimpickerDialog(View view){

        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                Toast.makeText(MainActivity.this, "Bây giờ là "+i+":"+i1
                        , Toast.LENGTH_SHORT).show();
            }
        },hour,minute,false);
        // bước 3 hiện thị và xử lí khi người dùng thay đổi thời gian
        timePickerDialog.show();
    }
    public void showSpinerProgress(View view){

    }
    public void showHorizontalProgress(View view){

    }
    public void showAlert(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //bước 2 :
        builder.setTitle("Cảnh báo");
        builder.setMessage("NetWork dissconected");
        builder.setPositiveButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }
    public void showCustomAlert (View view){


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Mã màu");
        builder.setSingleChoiceItems(color,0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                coloCheck = color[i];

            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "da chon"+coloCheck, Toast.LENGTH_SHORT).show();
            }
        });
    builder.show();

    }
    public void showListItem(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Chon mau");
        builder.setItems(color, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String select = color[i].toString();
                Toast.makeText(MainActivity.this,"da chon màu " +select, Toast.LENGTH_SHORT).show();

            }
        });
        builder.show();
        }

    }


