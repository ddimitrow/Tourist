package com.mytouristapp.diyan.touristapiclient;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;

public class DisplayRoutesActivity extends Activity {

    ArrayAdapter<String> adapter;
    ListView listv;
    Context context;
    ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_routes);
        // Show the Up button in the action bar.
        // setupActionBar();
        data = new ArrayList<String>();

        listv = (ListView) findViewById(R.id.lvRoute);
        context = this;

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, data);
        listv.setAdapter(adapter);
        Toast.makeText(this, "Loading Please Wait..", Toast.LENGTH_SHORT).show();

        String start = getIntent().getExtras().getString("start");
        String date = getIntent().getExtras().getString("date");

        new AsyncDisplayRoute().execute(start, date);

    }

    protected class AsyncDisplayRoute extends AsyncTask<String ,JSONObject, ArrayList<RouteTable>>
    {

        ArrayList<RouteTable> routeTable = null;

        @Override
        protected ArrayList<RouteTable> doInBackground(String... params) {

            RestAPI api = new RestAPI();
            try {

                JSONObject json_object = api.GetRouteDetails(params[0],params[1]);

                JSONParser parser = new JSONParser();

                routeTable = parser.parseRoute(json_object);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                Log.d("AsyncLoadRouteDetails", e.getMessage());

            }

            return routeTable;
        }

        //what to be displayed
        @Override
        protected void onPostExecute(ArrayList<RouteTable> result) {
            // TODO Auto-generated method stub

            for (int i = 0; i < result.size(); i++) {
                data.add("Start point: " +result.get(i).getStartPoint() + "\nDestination: " + result.get(i).getEndPoint() + "\nTime: "+result.get(i).getTime()
                +"\nLeader: "+result.get(i).getOwnerName()+ "\nPhone Number: "+result.get(i).getPhoneNumber() );
            }

            adapter.notifyDataSetChanged();

            Toast.makeText(context, "Loading Completed", Toast.LENGTH_SHORT).show();
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_route, menu);
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