package com.example.sensorpresentness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView textViewList;
    private SensorManager sensorManager;
    private List<Sensor> deviceSensors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewList = findViewById(R.id.listText);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        printSensors();

//        textViewList.setText(deviceSensors.toString());

    }

    private void printSensors(){
        for(Sensor sensor : deviceSensors){
            textViewList.setText(textViewList.getText() + "\nTYPE_INT: " + sensor.getType() + "\n" + sensor.getName());
        }
        Log.i("Sensor type", (String)textViewList.getText());

        textViewList.setText(textViewList.getText() + "\n");
    }
}