package com.project.network_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.hardware.Sensor.TYPE_GYROSCOPE;
import static android.hardware.Sensor.TYPE_LIGHT;
import static android.hardware.Sensor.TYPE_PROXIMITY;
import static java.lang.String.valueOf;

public class pub extends AppCompatActivity {

    TextView data_gyro,data_light,data_prox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Intent soket = getIntent();
        setContentView(R.layout.activity_pub);
        data_light = findViewById(R.id.data_light);
        data_gyro = findViewById(R.id.data_gyro);
        data_prox = findViewById(R.id.data_prox);


        data_gyro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show_all a = new show_all();
                //send_data obj = new send_data();
                //obj.execute(a.data_gyr.setText(valueOf(value[0]))
                /*if(event.sensor.getType() == TYPE_GYROSCOPE){
                    float[] value =  event.values;
                    send_data obj = new send_data();
                    obj.execute(valueOf(value[0]));
                }*///);
//                System.out.println(show_all.value[0];
               send_data s = new send_data();
               String again = soket.getStringExtra("socket");
               again = again.concat(valueOf(show_all.value[0]));
//               s.onPreExecute(again,valueOf(show_all.value[0]));
               s.execute(again);
            }
        });

        data_light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send_data s = new send_data();
                String again = soket.getStringExtra("socket");
                again = again.concat(valueOf(show_all.value[0]));
//               s.onPreExecute(again,valueOf(show_all.value[0]));
                s.execute(again);
//                send_data s = send_data.getInstance();
//                s.execute(valueOf(show_all.value[0]));
            }
        });

        data_prox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send_data s = new send_data();
                String again = soket.getStringExtra("socket");
                again = again.concat(valueOf(show_all.value[0]));
//               s.onPreExecute(again,valueOf(show_all.value[0]));
                s.execute(again);
//                send_data s = send_data.getInstance();
//                s.execute(valueOf(show_all.value[0]));
            }
        });
    }

}