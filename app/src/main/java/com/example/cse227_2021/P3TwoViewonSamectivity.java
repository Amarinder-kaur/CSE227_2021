package com.example.cse227_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

public class P3TwoViewonSamectivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p3_two_viewon_samectivity);
        LinearLayout Layout1 = (LinearLayout)findViewById(R.id.idP3View);
        // Create the P1SimpleDrawCircleRectangleMethods custom view object.
        final P1SimpleDrawCircleRectangleMethods view1 = new P1SimpleDrawCircleRectangleMethods(this);

        LinearLayout Layout2= (LinearLayout)findViewById(R.id.idP3View1);
        // Create the P1CustomViewWithBitamp custom view object.
        final P1CustomViewWithBitamp view2 = new  P1CustomViewWithBitamp(this);

        // Add  object in LinearLayout object.
                Layout1.addView(view1);
                Layout2.addView(view2);

    }
}