package com.example.mymadproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.mymadproject.Database.DBHandler;

import java.util.List;

public class MyApplication2 extends AppCompatActivity {

    EditText ordertype, ordername, weight, quantity;
    Button update, delete, search;
    RadioButton cardpayment, cashondelivery;
    String paymentmethod;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_application2);

        ordertype = findViewById(R.id.InputOrdersE1);
        ordername = findViewById(R.id.EnterOrdeR3);
        weight    = findViewById(R.id.We1ght5);
        quantity  = findViewById(R.id.QuntyInput1);
        update    = findViewById(R.id.UPdateW);
        delete    = findViewById(R.id.DELetEq);
        cardpayment = findViewById(R.id.CardRadio6);
        cashondelivery = findViewById(R.id.CashRaDio5);
        search    =  findViewById(R.id.SearchMe);

        // search added details
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DBHandler dbHandler = new DBHandler(getApplicationContext());
                List order = dbHandler.readAllInfo(ordername.getText().toString());

                if(order.isEmpty()){
                    Toast.makeText(MyApplication2.this, "No Order", Toast.LENGTH_SHORT).show();
                    ordername.setText(null);
                }
                else{
                    Toast.makeText(MyApplication2.this, "Order Found!"+order.get(1).toString(), Toast.LENGTH_SHORT).show();
                    ordertype.setText(order.get(0).toString());
                    ordername.setText(order.get(1).toString());
                    weight.setText(order.get(2).toString());
                    quantity.setText(order.get(3).toString());
                    if (order.get(4).toString().equals("Cash on Delivery")){
                        cashondelivery.setChecked(true);
                    }
                    else{
                        cardpayment.setChecked(true);
                    }
                }
            }
        });

        //update details
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cashondelivery.isChecked()){
                    paymentmethod = "Cash on Delivery";

                }
                else{
                    paymentmethod = "Card Payment";
                }
                DBHandler dbHandler = new DBHandler(getApplicationContext());

                Boolean status = dbHandler.updateInfo(ordertype.getText().toString(),ordername.getText().toString(),weight.getText().toString(),quantity.getText().toString(),paymentmethod);
                if(status){
                    Toast.makeText(MyApplication2.this, "Order Updated", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MyApplication2.this, "Update Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //delete details
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHandler dbHandler = new DBHandler(getApplicationContext());
                dbHandler.deleteInfo(ordername.getText().toString());

                Toast.makeText(MyApplication2.this, "Order Deleted", Toast.LENGTH_SHORT).show();

                ordertype.setText(null);
                ordername.setText(null);
                weight.setText(null);
                quantity.setText(null);
                cashondelivery.setChecked(false);
                cardpayment.setChecked(false);

            }
        });



       update.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(getApplicationContext(),calculateapp.class);
               startActivity(i);
          }
       });





    }
}