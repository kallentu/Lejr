package com.lejr.lejr;

import android.content.Intent;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
    }

    public void submitInformation(View view) throws IOException {
        /*
        EditText amountEditText = (EditText) findViewById(R.id.sending_amount);
        EditText emailEditText = (EditText) findViewById(R.id.sender_email);

        if(Integer.parseInt(amountEditText.getText().toString()) < 0){
            TextView amount_err = (TextView)findViewById(R.id.req_err_1);
            amount_err.setText("Receiving amount must be at least $0.01.");
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(((EditText) findViewById(R.id.sender_email)).getText().toString()).matches()){
            TextView email_err = (TextView)findViewById(R.id.req_err_2);
            email_err.setText("Invalid email.");
        }
        */
        Retrofit v1 = new Retrofit.Builder()
                .baseUrl("https://gateway-web.beta.interac.ca/publicapi/api/v1/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        Interac serviceV1 = v1.create(Interac.class);
        Call<String> token = serviceV1.token("7dIDt/5D5W6HK8s3gKY/9sAyhPFFxxhk8yZ6V0QVB/U=","jason","CA1TAUCyPsSfqkzX");
        String accessToken = token.execute().body();
        Log.e("wut", token.execute().body());

        Retrofit v2 = new Retrofit.Builder()
                .baseUrl("https://gateway-web.beta.interac.ca/publicapi/api/v2/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        Interac serviceV2 = v2.create(Interac.class);
        Call<Void> req = serviceV2.request(accessToken,"CA1TAUCyPsSfqkzX","123", "123","CA1ARhhdGyUQ2kqj");

        //TextView test = (TextView) findViewById(R.id.test);
        Log.e("wut", accessToken);

    }
}
