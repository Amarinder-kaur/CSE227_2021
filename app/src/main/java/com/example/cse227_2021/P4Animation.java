package com.example.cse227_2021;
//Only four animations: rotation,alpha,translate and scale
/*
 view animation:Android View animation can make animation on any View objects, such as ImageView, TextView or Button objects.
 View animation can only animate simple properties like position, size, rotation, and the alpha property that allows you
 animate the transparency of a View.

Property Animation:This animation was introduced in Android 3.0 (API level 11). It allows the user to animate anything.
Property animations are highly customizable, you can specify the duration, the number of repeats, the type of interpolation,
 and the frame rate of the animation. The Property Animation system is always preferred for more complex animations.
Property animations allow us to animate any property of any object from one value to another over a specified duration.
Let us take an example, imagine you wanted to animate the 3d rotation using the rotationX or rotationY properties that
 were introduced in API 11. Or maybe you want to animate a color change or animate the change of a drawable.
 This is not possible by using View Animations. For this purpose Property Animation is used .

You are not limited by predefined animation types or by the type of object that you want to animate. At first the usage of the Property Animation System might seem a little complicated. However, in most cases you can use the very versatile ObjectAnimator that uses reflection. The ObjectAnimator makes creating Property Animations almost as easy as creating View Animations.

Drawable Animation:This animation allows the user to load drawable resources and display them one frame after another. This method of animation is useful when user wants to animate things that are easier to represent with Drawable resources.
To use Animations in Android , Android has provided us a class called Animation.
To perform animation in android , we will  call a static function loadAnimation()(this method is used to load animation) of the class AnimationUtils. We are going to receive the result in an instance of Animation Object. Its syntax is as follows −
Animation animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myanimation);
Second parameter refers to our animation.xml file.It is created under res directory(res->anim->myanimation.xml)

The Animation class has many methods given below:
1.start(): This method will start the animation.
2.setDuration(long duration): This method sets the duration of an animation.
3.getDuration(): This method gets the duration.
4.end(): This method ends the animation.
5.cancel(): This method cancels the animation.

 */
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

//pivotX and pivotY is the central point of the animation.
//alpha: fading
//duration: The duration to show this frame, in milliseconds.How long this animation should last
//getInterpolator():Gets the acceleration curve type for this animation.
//getRepeatCount():Defines how many times the animation should repeat.
//getRepeatMode():Defines what this animation should do when it reaches the end.
//getStartOffset():When this animation should start, relative to StartTime
//getStartTime():When this animation should start.
// for all methods: https://developer.android.com/reference/android/view/animation/Animation

//constructor
// Animation():Creates a new animation with a duration of 0ms, the default interpolator, with fillBefore set to true
// and fillAfter set to false

//https://developer.android.com/guide/topics/resources/animation-resource#:~:text=android%3ApivotX%3D%22float%22,android%3AtoXDelta%3D%22float%22
// for details: https://abhiandroid.com/materialdesign/animation

//interpolator details: https://www.raywenderlich.com/2785491-android-animation-tutorial-with-kotlin
public class P4Animation extends AppCompatActivity {
    ImageView imageView;
    AnimationDrawable animationdrawable;
    Animation ani1, ani7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p4_animation);
        ani7 = AnimationUtils.loadAnimation(this, R.anim.ani);
        imageView = (ImageView) findViewById(R.id.i1);
        //imageView.setImageResource(R.drawable.b);

        imageView.setBackgroundResource(R.drawable.mylist);
        animationdrawable=(AnimationDrawable)imageView.getBackground();
    }
    public void Sequenceofimages(View v) {

    animationdrawable.start();
    }
    public void StopSequence(View v) {animationdrawable.stop();
    }
    public void RotateScale(View view) {

        imageView.startAnimation(ani7);
    }
    public void MovetheImage(View view) {
        Animation ani2 = AnimationUtils.loadAnimation
                (getApplicationContext(), R.anim.translate);
        imageView.startAnimation(ani2);
    }
    public void fade(View view) {
        Animation ani2 = AnimationUtils.loadAnimation
                (getApplicationContext(), R.anim.anim3);
        imageView.startAnimation(ani2);
    }
    public void blink(View view) {
        Animation ani2 = AnimationUtils.loadAnimation
                (getApplicationContext(), R.anim.anim4);
        imageView.startAnimation(ani2);
    }

    public void slide(View view) {
        Animation ani2 = AnimationUtils.loadAnimation
                (getApplicationContext(), R.anim.anim6);
        imageView.startAnimation(ani2);
    }
}


