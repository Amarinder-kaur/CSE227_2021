package com.example.cse227_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

//https://guides.codepath.com/android/animations
// for more example based on ViewAnimation: https://medium.com/mindorks/android-property-animation-the-valueanimator-4ca173567cdb
public class P8BasicViewAnimationJavaAnimation extends AppCompatActivity {
TextView tvLabel;
int dest,dest1;
float x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p8_basic_view_animation_java_animation);
        tvLabel=findViewById(R.id.i1);
    }


    public void Rotate(View view) {
        dest = 180;
        if (tvLabel.getRotation() == 180) {
            System.out.println(tvLabel.getAlpha());
            dest = 0;
        }
        ObjectAnimator animation1 = ObjectAnimator.ofFloat(tvLabel,
                "rotation", dest);
        animation1.setDuration(2000);
        animation1.start();
 /*       ObjectAnimator animation1 = ObjectAnimator.ofFloat(tvLabel,"rotation", 180);
        animation1.setDuration(2000);
        animation1.start();
   */
    }
    public void MovetheImage(View view) {
        ObjectAnimator moveAnim = ObjectAnimator.ofFloat(tvLabel, "Y", 1000);
        moveAnim.setDuration(2000);
      //  moveAnim.setInterpolator(new BounceInterpolator());
        moveAnim.start();
    }
    public void RotateScale(View V) {
        dest1 = 180;
        x=2.0f;
        if (tvLabel.getAlpha() == 180) {
            dest1 = 0;
            x=1.0f;
        }

        ObjectAnimator scaleAnim = ObjectAnimator.ofFloat(tvLabel, "scaleX", 1.0f, x);
        ObjectAnimator rotateanim = ObjectAnimator.ofFloat(tvLabel,
                "rotation", dest1);
        AnimatorSet animatorSet = new AnimatorSet();

        animatorSet.play(scaleAnim).after(rotateanim);
        animatorSet.start();
    }

    public void fade(View view) {
        // fade out
        ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(tvLabel, "alpha", 0.2f);
        fadeAnim.start();
    }
    public void blink(View view) {
        // fade out to visible as values are 0 to 1
        ObjectAnimator fadeAltAnim = ObjectAnimator.ofFloat(tvLabel, View.ALPHA, 0, 1);
        fadeAltAnim.start();
    }

    public void ZOOM_IN(View view) {
        ObjectAnimator scaleAnim = ObjectAnimator.ofFloat(tvLabel, "scaleX", 1.0f, 2.0f);
        scaleAnim.setDuration(3000);
        scaleAnim.setRepeatCount(ValueAnimator.INFINITE);
        scaleAnim.setRepeatMode(ValueAnimator.REVERSE);
        scaleAnim.start();
    }
}