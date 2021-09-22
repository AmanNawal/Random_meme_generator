package com.example.restvolleyapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    public ImageView imageView;
   public TextView textView;
    public Button next;
    public String url = "https://meme-api.herokuapp.com/gimme";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageView=findViewById(R.id.imageView2);
        textView=findViewById(R.id.textView3);
        next=findViewById(R.id.button);


        nextPressed();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextPressed();
            }
        });




    }

    public void nextPressed()
    {
        RequestQueue requestQueue=Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        // textView.setText("Response: " + response.toString());
                        //  Toast.makeText(MainActivity.this, "Working", Toast.LENGTH_SHORT).show();
                        try {
                            String url2=response.getString("url");
                            String title=response.getString("title");
                            textView.setText(title);
                            Glide.with(MainActivity.this).load(url2).into(imageView);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
        requestQueue.add(jsonObjectRequest);
    }
}