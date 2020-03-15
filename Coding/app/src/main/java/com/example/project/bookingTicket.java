package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class bookingTicket extends AppCompatActivity {

    EditText editTextName;
    EditText editTextIc;
    Button buttonBook;
    Spinner spinnerDestination;
    Spinner spinnerDeparture;
    Spinner spinnerSeats;
    Spinner spinnerClass;

    DatabaseReference databaseTicket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_ticket);

        getSupportActionBar().setTitle("Booking Ticket");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // back button

        databaseTicket = FirebaseDatabase.getInstance().getReference("Customer"); // in firebase


        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextIc = (EditText) findViewById(R.id.editTextIc);
        buttonBook = (Button)findViewById(R.id.buttonBook);
        spinnerDestination = (Spinner)findViewById(R.id.spinnerDestination);
        spinnerDeparture = (Spinner)findViewById(R.id.spinnerDeparture);
        spinnerSeats = (Spinner)findViewById(R.id.spinnerSeats);
        spinnerClass = (Spinner)findViewById(R.id.spinnerTypeClass);

        buttonBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booking();
            }
        });
    }

    private void booking(){
        String name = editTextName.getText().toString().trim();
        String ic = editTextIc.getText().toString().trim();
        String destination = spinnerDestination.getSelectedItem().toString();
        String departure = spinnerDeparture.getSelectedItem().toString();
        String seats = spinnerSeats.getSelectedItem().toString();
        String typeClass = spinnerClass.getSelectedItem().toString();

        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(ic)){
            String id = databaseTicket.push().getKey();
            ticket ticket = new ticket(id,name, ic, destination,departure,seats,typeClass);

            databaseTicket.child(id).setValue(ticket);

            Toast.makeText(this,"Ticket Has Been Booked", Toast.LENGTH_LONG).show();

        }

        else{
            Toast.makeText(this, "You should enter a name and your ic numberr",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
