package com.example.cse227_2021;

//detail about thread : https://www.geeksforgeeks.org/multithreading-in-java/
/*java.lang.Thread class provides the join() method which allows one thread to wait until another thread completes
 its execution. If t is a Thread object whose thread is currently executing, then t.join() will make sure
 that t is terminated before the next instruction is executed by the program.
 example details: https://www.javatpoint.com/java-join-method
 */
//https://www.javatpoint.com/synchronized-block-example for synchronized
//difference between view and surface view
/*The main difference between a View and a SurfaceView is that
1. a View is drawn in the UI Thread,which is used for all the user interaction.surfaceView can be
 updated on the background thread.
2. More work should be done to create your customized surfaceView. You need to listener to the
 surfaceCreated/Destroy Event, create an render thread, more importantly, synchronized the render
thread and main thread. However, to customize the View, all you need to do is override onDraw method.
3. The timing to update is different. Normal views are rendered when you call the methods
 invalidate or postInvalidate(), but this does not mean the view will be immediately updated
(A VSYNC will be sent, and the OS decides when it gets updated. The SurfaceView can be
  immediately updated.
4. A SurfaceView has an allocated surface buffer, so it is more costly
*/

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class P1FanSurfaceView extends SurfaceView implements Runnable
{
    Canvas canvas;
    SurfaceHolder surfaceHolder;
    Paint paint;
    Thread t = null;
    boolean isRotating ;
    int x =0;
    Rect r1;
    public P1FanSurfaceView(Context context)
    {
        super(context);
        //Access to the underlying surface is provided via the SurfaceHolder interface,
        // which can be retrieved by calling getHolder().
        surfaceHolder = getHolder();
        paint = new Paint();
      //  The Surface will be created for you while the SurfaceView's window is visible;
        //  you should implement SurfaceHolder.Callback#surfaceCreated and SurfaceHolder.Callback#surfaceDestroyed
        //  to discover when the Surface is created and destroyed as the window is shown and hidden.
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                startThread1();
            }
            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2)
            {
            }
            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            }
        });
    }
//    One of the purposes of this class(surface view) is to provide a surface in which a secondary thread can give into the screen.
    public void startThread1()
    {
        isRotating = true;
        t = new Thread(this);
        t.start();
    }

    public void stopThread()
    {
        isRotating = false;
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run()
    {
        while (isRotating)
        {
            if (surfaceHolder.getSurface().isValid())
            {
                canvas =  surfaceHolder.lockCanvas();
                synchronized (this) {
                    canvas.drawColor(Color.YELLOW);
                    paint.setColor(Color.GREEN);
                    canvas.drawArc(400, 400, 1100, 1100, x, 30, true, paint);
                    canvas.drawArc(400, 400, 1100, 1100, x + 120, 30, true, paint);
                    canvas.drawArc(400, 400, 1100, 1100, x + 240, 30, true, paint);




                    r1 = new Rect(400,400,1100,1100);
                    x = x + 10;
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        if (canvas != null)
                            surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                }
            }
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x1 = (int) event.getX();
        int y1 = (int) event.getY();

        if (r1.contains(x1, y1)) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    startThread1();
                    break;
                case MotionEvent.ACTION_UP:
                    stopThread();
                    break;
            }
        }
        return true;
    }
}
