package com.example.cse227_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
/*An accelerometer is an electronic sensor that measures the acceleration forces
 acting on an object, in order to determine the object's position in space and
 monitor the object's movement
  */

public class P10BasicSensor extends AppCompatActivity {
    SensorManager sm = null;
    TextView textView1 = null;
    List list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p10_basic_sensor);

        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        textView1 = (TextView)findViewById(R.id.textView1);
        list = sm.getSensorList(Sensor.TYPE_ACCELEROMETER);
        //parameters: registerListener(ISensorEventListener, Sensor, SensorDelay)
        if(list.size()>0){
            sm.registerListener(sel, (Sensor) list.get(0), SensorManager.SENSOR_DELAY_NORMAL);
        }else{
            Toast.makeText(getBaseContext(), "Error: No Accelerometer.", Toast.LENGTH_LONG).show();
        }
    }
    //these are two methods to override for SensorEventListener interface
    SensorEventListener sel = new SensorEventListener(){
        public void onAccuracyChanged(Sensor sensor, int accuracy) {}
        public void onSensorChanged(SensorEvent event) {
            float[] values = event.values;
            textView1.setText("x: "+values[0]+"\ny: "+values[1]+"\nz: "+values[2]);
        }
    };
    @Override
    protected void onStop() {
        if(list.size()>0){
            sm.unregisterListener(sel);//   SensorManager sm; sel: sensorListener
        }
        super.onStop();
    }
}