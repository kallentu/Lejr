package com.lejr.lejr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;

public class PreloginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MongoClientURI uri = new MongoClientURI( "mongodb://user:lejr@ds263847.mlab.com:63847/lejr" );
        MongoClient mongoClient = new MongoClient( "ds263847.mlab.com/lejr" , 63847 );
        MongoDatabase database = mongoClient.getDatabase("lejr");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prelogin);
    }
}
