package com.project.network_proj;

import androidx.appcompat.app.AppCompatActivity;
/*import java.nio.*;
import java.nio.channels.SocketChannel;
import java.util.*;
import java.io.*;
import java.net.*;*/
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView sub,pub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pub = findViewById(R.id.sub_bn);
        sub=findViewById(R.id.get_bn);

        pub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pub_pge = new Intent(MainActivity.this,pub.class);
                startActivity(pub_pge);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent harmonium = new Intent(MainActivity.this,show_all.class);
                startActivity(harmonium);
            }
        });


    }

}
