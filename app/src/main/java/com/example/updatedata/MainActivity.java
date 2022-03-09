package com.example.updatedata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.updatedata.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    String number1, number2, number3, number4;
    EditText ett1, ett2, ett3, ett4, ett5, ett6, ett7, ett8, ett9, ett10, ett11;
    Button btna, btnb, btnc, go;
    FirebaseDatabase database;
    DatabaseReference check1, check2, check3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ett1 = (EditText)findViewById(R.id.et1);
        ett2 = (EditText)findViewById(R.id.et2);
        ett3 = (EditText)findViewById(R.id.et3);
        ett4 = (EditText)findViewById(R.id.et4);
        ett5 = (EditText)findViewById(R.id.et5);
        ett6 = (EditText)findViewById(R.id.et6);
        ett7 = (EditText)findViewById(R.id.et7);
        ett8 = (EditText)findViewById(R.id.et8);
        ett9 = (EditText)findViewById(R.id.et9);
        ett10 = (EditText)findViewById(R.id.et10);
        ett11 = (EditText)findViewById(R.id.et11);
        btna = (Button)findViewById(R.id.btn1);
        btnb = (Button)findViewById(R.id.btn2);
        btnc = (Button)findViewById(R.id.btn3);
        go = (Button)findViewById(R.id.tb2);


        database = FirebaseDatabase.getInstance();

        check1 = database.getReference("BANK").child("MERCHANTS");
        check2 = database.getReference("BANK").child("OLDINALLY CUSTOMERS");
        check3 = database.getReference("MERCHANTS CUSTOMERS");

        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number1 = ett1.getText().toString();
                check1.child(number1).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String balance = snapshot.child("account balance").getValue().toString();
                        String name = snapshot.child("account name").getValue().toString();
                        String number = snapshot.child("account number").getValue().toString();
                             ett2.setText(name);
                             ett3.setText(number);
                             ett4.setText(balance);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });
        btnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number2 = ett5.getText().toString();
                check2.child(number2).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String balance = snapshot.child("account balance").getValue().toString();
                        String name = snapshot.child("account name").getValue().toString();
                        String number = snapshot.child("account number").getValue().toString();
                        ett6.setText(name);
                        ett7.setText(number);
                        ett8.setText(balance);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number3 = ett9.getText().toString();
                number4 = ett10.getText().toString();
                check3.child(number3).child(number4).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String bil = snapshot.child("bill").getValue().toString();
                        ett11.setText(bil);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });




    }
}