package com.example.mymadproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class calculateapp extends AppCompatActivity {

    private String weddingcake = "";
    private String birthdaycake = "";
    private String specialoffer = "";

    private ArrayList<String> data = new ArrayList<String>();
    private ArrayList<String> data1 = new ArrayList<String>();
    private ArrayList<String> data2 = new ArrayList<String>();
    private ArrayList<String> data3 = new ArrayList<String>();

    private TableLayout table ;

    EditText ed1;

    CheckBox ch1,ch2,ch3;

    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculateapp);

        ch1 = findViewById(R.id.chk1);
        ch2 = findViewById(R.id.chk2);
        ch3 = findViewById(R.id.chk3);

        ed1 = findViewById(R.id.txtsub);

        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = 0 ;
                for(int a=0;a<data3.size();a++)
                {
                    sum = sum+Integer.parseInt(data3.get(a).toString());
                }
                ed1.setText(String.valueOf(sum));
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Assign();
            }
        });
    }

    public void Assign(){
        if(ch1.isChecked()){
            final TableRow row = new TableRow(this);
            final TextView t1 = new TextView(this);
            final TextView t2 = new TextView(this);
            final TextView t3 = new TextView(this);
            final TextView t4 = new TextView(this);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Required Quantity");

            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);

            builder.setPositiveButton("ok", (Dialog,which) -> {

                String wcake = ch1.getText().toString();
                int cakeprice = 6000;

                weddingcake = input.getText().toString();

                int tot = cakeprice * Integer.parseInt(weddingcake);

                data.add(wcake);
                data1.add(String.valueOf(cakeprice));
                data2.add(String.valueOf(weddingcake));
                data3.add(String.valueOf(tot));

                TableLayout table = (TableLayout) findViewById(R.id.tb1);

                String total;

                for (int i = 0; i< data.size(); i++) {
                    String cakename = data.get(i);
                    String prc = data1.get(i);
                    String qty = data2.get(i);
                    total = data3.get(i);

                    t1.setText(cakename);
                    t2.setText(prc);
                    t3.setText(qty);
                    t4.setText(total);

                }

                row.addView(t1);
                row.addView(t2);
                row.addView(t3);
                row.addView(t4);
                table.addView(row);

            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();

        }

        else if(ch2.isChecked()){
            final TableRow row = new TableRow(this);
            final TextView t1 = new TextView(this);
            final TextView t2 = new TextView(this);
            final TextView t3 = new TextView(this);
            final TextView t4 = new TextView(this);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Required Quantity");

            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);

            builder.setPositiveButton("ok", (Dialog,which) -> {

                String bcake = ch2.getText().toString();
                int cakeprice = 3000;

                birthdaycake = input.getText().toString();

                int tot = cakeprice * Integer.parseInt(birthdaycake);

                data.add(bcake);
                data1.add(String.valueOf(cakeprice));
                data2.add(String.valueOf(birthdaycake));
                data3.add(String.valueOf(tot));

                TableLayout table = (TableLayout) findViewById(R.id.tb1);

                String total;

                for (int i = 0; i< data.size(); i++) {
                    String cakename = data.get(i);
                    String prc = data1.get(i);
                    String qty = data2.get(i);
                    total = data3.get(i);

                    t1.setText(cakename);
                    t2.setText(prc);
                    t3.setText(qty);
                    t4.setText(total);

                }

                row.addView(t1);
                row.addView(t2);
                row.addView(t3);
                row.addView(t4);
                table.addView(row);

            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();

        }

        else if(ch3.isChecked()){
            final TableRow row = new TableRow(this);
            final TextView t1 = new TextView(this);
            final TextView t2 = new TextView(this);
            final TextView t3 = new TextView(this);
            final TextView t4 = new TextView(this);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Required Quantity");

            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);

            builder.setPositiveButton("ok", (Dialog,which) -> {

                String special = ch3.getText().toString();
                int cakeprice = 1500 ;

                specialoffer = input.getText().toString();

                int tot = cakeprice * Integer.parseInt(specialoffer);

                data.add(special);
                data1.add(String.valueOf(cakeprice));
                data2.add(String.valueOf(specialoffer));
                data3.add(String.valueOf(tot));

                TableLayout table = (TableLayout) findViewById(R.id.tb1);

                String total;

                for (int i = 0; i< data.size(); i++) {
                    String cakename = data.get(i);
                    String prc = data1.get(i);
                    String qty = data2.get(i);
                    total = data3.get(i);

                    t1.setText(cakename);
                    t2.setText(prc);
                    t3.setText(qty);
                    t4.setText(total);

                }

                row.addView(t1);
                row.addView(t2);
                row.addView(t3);
                row.addView(t4);
                table.addView(row);

            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();

        }





    }
}