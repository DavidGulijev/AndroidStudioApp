package com.example.ageofempires2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "tag";
    RecyclerView itemList;
    Adapter adapter;
    List<Civilizations> all_civilizations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Civilizations menu");
        all_civilizations = new ArrayList<>();
        itemList = findViewById(R.id.itemList);
        itemList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, all_civilizations);
        itemList.setAdapter(adapter);

        getJsonData();

    }

    private void getJsonData() {
        String URL = "https://age-of-empires-2-api.herokuapp.com/api/v1/civilizations";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //Log.d(TAG, "onErrorResponse" + response);
                try {
                    JSONArray civilizations = response.getJSONArray("civilizations");
                    JSONObject civilizationsData = civilizations.getJSONObject(0);

                    Log.d(TAG, "onResponse "+ civilizationsData);

                    for (int i=0; i< civilizationsData.length();i++){
                        JSONObject civilization = civilizations.getJSONObject(i);
                        Civilizations v = new Civilizations();

                        v.setName(civilization.getString("name"));
                        v.setArmy_type(civilization.getString("army_type"));
                        v.setExpansion(civilization.getString("expansion"));

                        all_civilizations.add(v);
                        adapter.notifyDataSetChanged();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse" + error.getMessage());
            }
        });
        requestQueue.add(objectRequest);
    }
}
