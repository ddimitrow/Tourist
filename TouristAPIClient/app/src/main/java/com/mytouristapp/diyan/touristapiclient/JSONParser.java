package com.mytouristapp.diyan.touristapiclient;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONParser {

    public JSONParser()
    {
        super();
    }

    public ArrayList<RouteTable> parseRoute(JSONObject object)
    {
        ArrayList<RouteTable> arrayList=new ArrayList<RouteTable>();
        try {
            JSONArray jsonArray=object.getJSONArray("Value");
            JSONObject jsonObj=null;
            for(int i=0;i<jsonArray.length();i++)
            {
                jsonObj=jsonArray.getJSONObject(i);
                arrayList.add(new RouteTable(jsonObj.getString("startPoint"), jsonObj.getString("endPoint"),jsonObj.getString("date"),jsonObj.getString("time"),jsonObj.getString("ownerName"),jsonObj.getString("phoneNumber")));
            }

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            Log.d("JSONParser=>parseRoute", e.getMessage());
        }
        return arrayList;
    }

    public boolean parseUserAuth(JSONObject object)
    {     boolean userAtuh=false;
        try {
            userAtuh= object.getBoolean("Value");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            Log.d("JSONParser=>UserAuth", e.getMessage());
        }

        return userAtuh;
    }

    public UserDetailsTable parseUserDetails(JSONObject object)
    {
        UserDetailsTable userDetail=new UserDetailsTable();

        try {
            JSONObject jsonObj=object.getJSONArray("Value").getJSONObject(0);

            userDetail.setFirstName(jsonObj.getString("firstName"));
            userDetail.setLastName(jsonObj.getString("lastName"));
           // userDetail.setUserName(jsonObj.getString("userName"));
           //userDetail.setPassword(jsonObj.getString("password"));
            userDetail.setPhoneNumber(jsonObj.getString("phoneNumber"));

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            Log.d("JSON parseUserDetails", e.getMessage());
        }

        return userDetail;

    }

}
