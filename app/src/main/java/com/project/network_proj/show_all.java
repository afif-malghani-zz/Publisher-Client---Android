package com.project.network_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import static android.hardware.Sensor.TYPE_ALL;
import static android.hardware.Sensor.TYPE_GYROSCOPE;
import static android.hardware.Sensor.TYPE_GYROSCOPE_UNCALIBRATED;
import static android.hardware.Sensor.TYPE_LIGHT;
import static android.hardware.Sensor.TYPE_PROXIMITY;
import static java.lang.String.valueOf;

public class show_all extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensor2;
    private TextView data_gyr,data_ligh,data_prox;
    private Sensor gyro,light,proximity;
    public static  float[] value = new float[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);
        data_gyr = findViewById(R.id.data_gyro);
        data_ligh = findViewById(R.id.data_light);
        data_prox = findViewById(R.id.data_prox);



        sensor2 = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        gyro = sensor2.getDefaultSensor(TYPE_GYROSCOPE);
        light = sensor2.getDefaultSensor(TYPE_LIGHT);
        proximity = sensor2.getDefaultSensor(TYPE_PROXIMITY);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == TYPE_GYROSCOPE){
            value =  event.values;
            data_gyr.setText(valueOf(value[0]));

        }
        if(event.sensor.getType() == TYPE_LIGHT){
            value =  event.values;
            data_ligh.setText(valueOf(value[0]));
//            System.out.println(value[0]);
        }
        if(event.sensor.getType() == TYPE_PROXIMITY){
            value =  event.values;
            data_prox.setText(valueOf(value[0]));

        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume(){
        super.onResume();
        sensor2.registerListener(this,gyro,SensorManager.SENSOR_DELAY_NORMAL);
        sensor2.registerListener(this,light,SensorManager.SENSOR_DELAY_NORMAL);
        sensor2.registerListener(this,proximity,SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        sensor2.unregisterListener(this);
    }
}
