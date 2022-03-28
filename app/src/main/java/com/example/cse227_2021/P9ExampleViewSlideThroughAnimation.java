package com.example.cse227_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

public class P9ExampleViewSlideThroughAnimation extends AppCompatActivity {
    TextView textview;
    View myView;
Button myButton;
    boolean isUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p9_example_view_slide_through_animation);
        myView = findViewById(R.id.my_view);
        myButton = findViewById(R.id.b1);
        myView.setVisibility(View.INVISIBLE);
        myButton.setText("Slide up");
        isUp = false;
    }
    public void slideUp(View view){
        view.setVisibility(View.VISIBLE);
        TranslateAnimation animate = new TranslateAnimation(0,0,view.getHeight(),0);
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
    }


    public void slideDown(View view){
        TranslateAnimation animate = new TranslateAnimation(0,0, 0,view.getHeight());
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
    }

    public void onSlideViewButtonClick(View view) {
        if (isUp) {
            slideDown(myView);
            myButton.setText("Slide up");
        } else {
            slideUp(myView);
            myButton.setText("Slide down");
        }
        isUp = !isUp;
    }
}
        /*textview=findViewById(R.id.t1);
           }

           public void Slide(View v) {
               ObjectAnimator animator = ObjectAnimator.ofFloat(textview, "scaleY", 1, 0);
               animator.setDuration(2000);
               animator.start();
           }
}*/