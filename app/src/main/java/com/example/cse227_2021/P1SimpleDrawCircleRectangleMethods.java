package com.example.cse227_2021;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
/*
drawrect(left,top,right,bottom) parameters:
        left: distance of the left side of rectangular from left side of canvas.

        top:Distance of top side of rectangular from the top side of canvas

        right:distance of the right side of rectangular from left side of canvas.
        bottom: Distance of the bottom side of rectangle from top side of canvas.

        drawCircle(float cx, float cy, float radius, Paint paint) parameter:

        drawLine(float startX, float startY, float stopX, float stopY, Paint paint)

        drawOval(float left, float top, float right, float bottom, Paint paint)

        drawArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean useCenter, Paint paint)
or
drawArc(RectF oval, float startAngle, float sweepAngle, boolean useCenter, Paint paint)

  DrawArc method takes 4 parameters: . 1-Rectangle to draw in. 2-Start angle. 3-Sweep angle 4.Paint
  draw an arc representing a portion of an ellipse specified by a pair of coordinates

  for more details of arc: https://thoughtbot.com/blog/android-canvas-drawarc-method-a-visual-guide

        */
public class P1SimpleDrawCircleRectangleMethods extends View {
    Paint paint = new Paint();

    public P1SimpleDrawCircleRectangleMethods(Context context) {
        super(context);
    }

    @Override
    public void onDraw(Canvas canvas) {
       paint.setColor(Color.BLACK);
       // paint.setStrokeWidth(50);
      //  paint.setStyle(Paint.Style.STROKE);
     //  canvas.drawRect(150, 130, 580, 880, paint);

        paint.setColor(Color.CYAN);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(500, 500, 100, paint);

        paint.setColor(Color.YELLOW);
        canvas.drawLine(600,130,580,880,paint);

        canvas.drawOval(150, 130, 580, 880, paint);
       paint.setColor(Color.BLACK);

        canvas.drawArc(150F, 130F, 580F, 880F,90F,180F,false,paint);
        /*

// make india's flag
        paint.setColor(Color.BLACK);
        canvas.drawRect(150,130,950,1200,paint);

        // how to set our own color which is not in color class
        int orange= Color.argb(250, 255,255,50);
        paint.setColor(orange);
        canvas.drawRect(150,130,950,400,paint);

        paint.setColor(Color.BLUE);
        canvas.drawCircle(550,600,190,paint);

        paint.setColor(Color.GREEN);
        canvas.drawRect(150,1200,950,800,paint);
  */
        //draw smile
      /*  paint.setColor(Color.YELLOW);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);

        canvas.drawCircle(550,500,275,paint);
        paint.setColor(Color.BLACK);
        canvas.drawArc(400,500,700,650,0,180,false,paint);

        canvas.drawCircle(400,400,50,paint);
        canvas.drawCircle(700,400,50,paint);

        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawOval(365,365,440,450,paint);
        canvas.drawOval(665,365,740,450,paint);
    */
    }
}