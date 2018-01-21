package com.lejr.lejr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
    }

    public void submitInformation(View view) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://gateway-web.beta.interac.ca/publicapi/api/v1/test/encrypted-key";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                    }
                });

        queue.add(stringRequest);

        EditText amountEditText = (EditText) findViewById(R.id.sending_amount);
        EditText emailEditText = (EditText) findViewById(R.id.sender_email);

        if(!Patterns.EMAIL_ADDRESS.matcher(((EditText) findViewById(R.id.sender_email)).getText().toString()).matches()){
            TextView email_err = (TextView)findViewById(R.id.req_err_2);
            email_err.setText("Invalid email.");
        }
    }
}
