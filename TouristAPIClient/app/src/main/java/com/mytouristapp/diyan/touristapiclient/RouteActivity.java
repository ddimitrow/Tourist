package com.mytouristapp.diyan.touristapiclient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RouteActivity extends Activity {


    EditText etStarting, etDate;
    Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);
        // Show the Up button in the action bar.

        etStarting=(EditText)findViewById(R.id.etStarting);
        etDate=(EditText)findViewById(R.id.etDate);
        btnSearch=(Button)findViewById(R.id.btn_search);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i=new Intent(RouteActivity.this,DisplayRoutesActivity.class);
                i.putExtra("start", etStarting.getText().toString());
                i.putExtra("date", etDate.getText().toString());
                startActivity(i);

            }
        });


    }


}