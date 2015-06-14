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

import org.json.JSONObject;

public class UserDetailsActivity extends Activity {

    EditText etFisrtName, etLastName, etPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        // Show the Up button in the action bar.
 //       setupActionBar();

        etFisrtName=(EditText)findViewById(R.id.et_firstname);
        etLastName=(EditText)findViewById(R.id.et_lastname);
        etPhoneNumber=(EditText)findViewById(R.id.et_phone);

        Intent i=getIntent();
        //String username=i.getStringExtra("username");
        String username=i.getStringExtra("username");

        new AsyncUserDetails().execute(username);

        // po edin onclicklistener za dvata butona da vikat 2 intent
        Button btnAddRoute = (Button) findViewById(R.id.btnAddRoute);

        btnAddRoute.setOnClickListener(new View.OnClickListener() {

            // @Override
            public void onClick(View v) {

                Intent i = new Intent(UserDetailsActivity.this,CreateRouteActivity.class);
                startActivity(i);
            }
        });

        Button btnSearch = (Button) findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {

            // @Override
            public void onClick(View v) {
               Intent i=new Intent(UserDetailsActivity.this,RouteActivity.class);
               startActivity(i);
            }
        });


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

    protected class AsyncUserDetails extends AsyncTask<String,Void,UserDetailsTable>
    {

        @Override
        protected UserDetailsTable doInBackground(String... params) {
            // TODO Auto-generated method stub
            UserDetailsTable userDetail=null;
            RestAPI api = new RestAPI();
            try {

                JSONObject jsonObj = api.GetUserDetails(params[0]);
                JSONParser parser = new JSONParser();
                userDetail = parser.parseUserDetails(jsonObj);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                Log.d("AsyncUserDetails", e.getMessage());

            }

            return userDetail;
        }

        @Override
        protected void onPostExecute(UserDetailsTable result) {
            // TODO Auto-generated method stub

            etFisrtName.setText(result.getFirstName());
            etLastName.setText(result.getLastName());
            etPhoneNumber.setText(result.getPhoneNumber());


        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_details, menu);
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