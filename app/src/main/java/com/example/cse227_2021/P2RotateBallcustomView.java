package com.example.cse227_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;


public class P2RotateBallcustomView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2_rotate_ballcustom_view);

        // Get the root Linearlayout object.
        LinearLayout rootLayout = (LinearLayout)findViewById(R.id.idP2DrawBallView);
        // Create the DrawBallView custom view object.
        final P2DrawBallView drawBallView = new P2DrawBallView(this);
        //set min width and height.
        drawBallView.setMinimumWidth(500);
        drawBallView.setMinimumHeight(800);
        // Create a ontouch listener object.
        View.OnTouchListener onTouchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // Set drawBallView currX and currY value to user finger x y ordinate value..
                drawBallView.setCurrX(motionEvent.getX());
                drawBallView.setCurrY(motionEvent.getY());
                // Set ball color to blue.
                drawBallView.setBallColor(Color.BLUE);
                // Notify drawBallView to redraw. This will invoke DrawBallView's onDraw() method.
                drawBallView.invalidate();
                // Return true means this listener has complete process this event successfully.
                return true;
            }
        };
        // Register onTouchListener object to drawBallView.
        drawBallView.setOnTouchListener(onTouchListener);
        // Add drawBallView object in root LinearLayout object.
        rootLayout.addView(drawBallView);
    }
}