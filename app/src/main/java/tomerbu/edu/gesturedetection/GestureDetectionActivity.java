package tomerbu.edu.gesturedetection;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class GestureDetectionActivity extends AppCompatActivity {
    GestureDetectorCompat detector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_detection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        detector = new GestureDetectorCompat(this, new MyGestureRecognizer());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);

    }

    class MyGestureRecognizer extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float x1 = e1.getX();
            float x2 = e2.getX();

            float y1 = e1.getY();
            float y2 = e2.getY();
            
            
            float dx = x1 - x2;
            float dy = y1 - y2;
            
            if (Math.abs(dx) > Math.abs(dy)){
                //horizontal
                if (dx<0){
                    //Right
                    Toast.makeText(getApplicationContext(),
                            "Right", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),
                            "Left", Toast.LENGTH_SHORT).show();
                }
            }else {
                //vertical
                if (dy < 0){
                    Toast.makeText(getApplicationContext(),
                            "Down", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),
                            "Up!", Toast.LENGTH_SHORT).show();
                }
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
          //  Log.d("Ness", "Scroll " + e1 + " " + e2);
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onDown(MotionEvent e) {
         //   Log.d("Ness", "onDown " + e);
            return super.onDown(e);
        }
    }
}
