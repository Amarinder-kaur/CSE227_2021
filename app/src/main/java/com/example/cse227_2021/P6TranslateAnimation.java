package com.example.cse227_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class P6TranslateAnimation extends AppCompatActivity {
    Button rotate, move, sequence, stop, fade, blink, slide;
    ImageView mario;
    Animation translateMario;
    AnimationDrawable animationDrawable;
    Button pp,pm,mp,mm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p6_translate_animation);
        pp = (Button) findViewById(R.id.quad1);
        pm = (Button) findViewById(R.id.quad2);
        mp = (Button) findViewById(R.id.quad3);
        mm = (Button) findViewById(R.id.quad4);

        mario = (ImageView) findViewById(R.id.mario);

        pp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                translateMario = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translatepp);
                mario.startAnimation(translateMario);
            }
        });
        pm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                translateMario = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translatepm);
                mario.startAnimation(translateMario);
            }
        });
        mp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                translateMario = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translatemp);
                mario.startAnimation(translateMario);
            }
        });
        mm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                translateMario = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translatemm);
                mario.startAnimation(translateMario);
            }
        });



    }
}
/*
output:

in system screen is like this
                  y axis
                    |
                    |
          (x,y)     | (x,y)
          (-,-)     | (+,-)
xaxis   ------------|---------
          (x,y)     |  (x,y)
          (-,+)     |  (+,+)
                    |
but in mathematics

                   Y Axis
                    |
                    |
          (x,y)     | (x,y)
          (-,+)     | (+,+)
xaxis   ------------|---------
          (x,y)     |  (x,y)
          (-,-)     |  (+,-)
                    |
 */

/* details of Translate
TranslateAnimation is a moving animation effect. It has following constructors, namely:

　　1.public TranslateAnimation(Context context,AttributeSet attrs) skip

　　2.public TranslateAnimation(float fromXDelta, float toXDelta, float fromYDelta, float toYDelta)

　　This is one of our most commonly used construction methods,

　　float fromXDelta: This parameter represents the difference between the starting point of the animation and the current View X coordinate;

　　float toXDelta, this parameter represents the difference between the point where the animation ends and the current View X coordinate;

　　float fromYDelta, this parameter represents the difference between the starting point of the animation and the Y coordinate of the current View;

　　float toYDelta) This parameter represents the difference between the starting point of the animation and the Y coordinate of the current View;

　　If the view is at point A(x,y), then the animation will move from point B (x+fromXDelta, y+fromYDelta) to point C (x+toXDelta, y+toYDelta).

　　3. public　　TranslateAnimation (int fromXType, float fromXValue, int toXType, float toXValue, int fromYType, float fromYValue, int toYType, float toYValue)

　　fromXType: The first parameter is the reference of the value of the x-axis direction (Animation.ABSOLUTE, Animation.RELATIVE_TO_SELF, or Animation.RELATIVE_TO_PARENT);

　　fromXValue: The second parameter is the starting value of the first parameter type;

　　toXType, toXValue: The third parameter and the fourth parameter are the end point reference and corresponding value in the x-axis direction;

　　The last four parameters need not be explained. If you choose Animation.ABSOLUTE all, it is actually the second constructor.

      Take the x-axis as an example to introduce the relationship between reference and corresponding value:

      If you choose to refer to Animation.ABSOLUTE, the corresponding value should be a specific coordinate value, such as 100 to 300,
       which refers to the absolute screen pixel unit

      If the selected reference is Animation.RELATIVE_TO_SELF or Animation.RELATIVE_TO_PARENT, it means relative to itself or the parent control, and the corresponding value should be understood as several times or percent relative to itself or the parent control. Try more parameters to understand.


 */