package com.example.cse227_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
//Creating custom views. By extending the View class or one of its
// subclasses you can create your custom view. For drawing view use the
// onDraw() method. In this method you receive a Canvas object which allows
// you to perform drawing operations on it, e.g. draw lines, circle, text
//or bitmap

public class P1CanvasDrawingsMainJava extends AppCompatActivity {

   // P1MyDrawing cv1;
   // P1SimpleDrawCircleRectangleMethods cv2;
 //   P1CustomViewWithBitamp cv2;
 P1FanSurfaceView cv2;
 //P1MyDrawingWithEraser cv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

     //   cv2= new P1SimpleDrawCircleRectangleMethods(this);
   //    cv2= new P1CustomViewWithBitamp(this);
        cv2=new P1FanSurfaceView(this);
      //  cv2.setBackgroundColor(Color.WHITE);
        setContentView(cv2);
    }
}