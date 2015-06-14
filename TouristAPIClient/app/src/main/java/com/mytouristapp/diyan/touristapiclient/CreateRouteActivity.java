package com.mytouristapp.diyan.touristapiclient;


import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateRouteActivity extends Activity {

    EditText etStartPoint, etDestination, etDate, etTime, etOwner, etPhone;
    Button btnCreateRoute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_route);
        // Show the Up button in the action bar.
//        setupActionBar();

        etStartPoint =(EditText) findViewById(R.id.et_StartPoint);
        etDestination = (EditText) findViewById(R.id.et_Destination);
        etDate = (EditText) findViewById(R.id.et_Date);
        etTime = (EditText) findViewById(R.id.et_Time);
        etOwner = (EditText) findViewById(R.id.et_Owner);
        etPhone = (EditText) findViewById(R.id.et_PhoneNumber);

        btnCreateRoute=(Button) findViewById(R.id.btnAddRoute);

        btnCreateRoute.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub


                String starting, destination, date, time, owner, phone;

                starting = etStartPoint.getText().toString();
                destination = etDestination.getText().toString();
                date = etDate.getText().toString();
                time = etTime.getText().toString();
                owner = etOwner.getText().toString();
                phone = etPhone.getText().toString();

                //System.out.println(starting+  destination+  date+ time+  owner+  phone);

                RouteTable routeDetail = new RouteTable( starting,  destination,  date,  time,  owner,  phone);

                new AsyncCreateRoute().execute(routeDetail);

            }
       });

    }

    protected class AsyncCreateRoute extends
            AsyncTask<RouteTable, Void, Void> {

        @Override
        protected Void doInBackground(RouteTable... params) {

            RestAPI api = new RestAPI();
            try {

                api.CreateNewRoute(params[0].getStartPoint(),params[0].getEndPoint(),params[0].getDate(),params[0].getTime(),params[0].getOwnerName(),params[0].getPhoneNumber());

            } catch (Exception e) {
                // TODO Auto-generated catch block
                Log.d("AsyncCreateRoute", e.getMessage());

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

             Intent i = new Intent(CreateRouteActivity.this, RouteActivity.class);
            //TODO Clear route
            startActivity(i);
        }

    }

    /**
     * Set up the {@link android.app.ActionBar}, if the API is available.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void setupActionBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_route, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // This ID represents the Home or Up button. In the case of this
                // activity, the Up button is shown. Use NavUtils to allow users
                // to navigate up one level in the application structure. For
                // more details, see the Navigation pattern on Android Design:
                //
                // http://developer.android.com/design/patterns/navigation.html#up-vs-back
                //
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}