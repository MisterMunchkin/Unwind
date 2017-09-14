package com.unwind.munchkin.unwind;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Munchkin on 9/10/2017.
 */

public class AddBookingPage extends AppCompatActivity{

    EditText checkinText;
    EditText checkoutText;
    Button createBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_booking);

        checkinText = (EditText) findViewById(R.id.checkIn_text);
        checkoutText = (EditText) findViewById(R.id.checkOut_text);
        createBooking = (Button) findViewById(R.id.createBookingButton);

        createBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddBookingPage.this, "booking added!",
                        Toast.LENGTH_LONG).show();
            }
        });
        checkinText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar checkInCalendar = Calendar.getInstance();

                int mYear = checkInCalendar.get(Calendar.YEAR);
                int mMonth = checkInCalendar.get(Calendar.MONTH);
                int mDay = checkInCalendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker = new DatePickerDialog(AddBookingPage.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String checkinDateString = String.valueOf(year)+"/"+String.valueOf(month)+"/"+
                                String.valueOf(dayOfMonth);

                        checkinText.setText(checkinDateString);
                    }
                },mYear,mMonth,mDay);
                mDatePicker.setTitle("check in");
                mDatePicker.show();
            }
        });

        checkoutText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar checkInCalendar = Calendar.getInstance();

                int mYear = checkInCalendar.get(Calendar.YEAR);
                int mMonth = checkInCalendar.get(Calendar.MONTH);
                int mDay = checkInCalendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker = new DatePickerDialog(AddBookingPage.this,R.style.CalendarTheme,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String checkoutDateString = String.valueOf(year)+"/"+String.valueOf(month)+"/"+
                                String.valueOf(dayOfMonth);

                        checkoutText.setText(checkoutDateString);
                    }
                },mYear,mMonth,mDay);
                mDatePicker.setTitle("check out");
                mDatePicker.show();
               //change date picker dialog color

            }
        });
    }
}
