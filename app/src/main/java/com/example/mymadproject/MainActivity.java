package com.example.mymadproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.mymadproject.Database.DBHandler;

public class MainActivity extends AppCompatActivity {

    EditText ordertype, ordername, weight, quantity, ordereddate,  price;
    Button submit,  cancel;
    RadioButton cashondelivery, cardpayment;
    String paymentmethod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ordertype = findViewById(R.id.orderTypeIn1);
        ordername = findViewById(R.id.OrdernameIn1);
        weight = findViewById(R.id.WeightIn1);
        quantity = findViewById(R.id.QuantityIn1);
        ordereddate = findViewById(R.id.OrderedDateIn1);
        price = findViewById(R.id.PriceIn1);
        submit =  findViewById(R.id.btnSubmit1);
        cancel =  findViewById(R.id.btnCancel1);
        cashondelivery = findViewById(R.id.CashOnRadio1);
        cardpayment = findViewById(R.id.CardPayment1);

        submit.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(cashondelivery.isChecked()){
                    paymentmethod = "Cash on Delivery";

                }
                else{
                    paymentmethod = "Card Payment";
                }

               DBHandler dbHandler = new DBHandler(getApplicationContext());
               long newID = dbHandler.addinfo(ordertype.getText().toString(),ordername.getText().toString(),weight.getText().toString(),quantity.getText().toString(),ordereddate.getText().toString(),price.getText().toString(),paymentmethod);
                Toast.makeText(MainActivity.this, "Order Added. Order ID:"+ newID, Toast.LENGTH_SHORT).show();


                Intent i = new Intent(getApplicationContext(),CakeMart.class);
                 startActivity(i);
                 ordertype.setText(null);
                 ordername.setText(null);
                 weight.setText(null);
                 quantity.setText(null);
                 ordereddate.setText(null);
                 cashondelivery.setChecked(true);
                 cardpayment.setChecked(false);
            }
        });


    }
}