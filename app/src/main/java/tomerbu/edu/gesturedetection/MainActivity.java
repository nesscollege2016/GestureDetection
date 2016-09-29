package tomerbu.edu.gesturedetection;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         fab = (FloatingActionButton) findViewById(R.id.fab);
/*         fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }); */



        fab.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //Toast.makeText(MainActivity.this, "inFab " + fab.getX() + ", " + fab.getY(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        float x = event.getX();
        float y = event.getY();

        float fabX0 = fab.getX();
        float fabY0 = fab.getY();
        int fabHeight = fab.getHeight();
        int fabWidth = fab.getWidth();
        float fabXm = fabX0 + fabWidth;
        float fabYm = fabY0 + fabHeight;

        if (x <= fabXm && x>=fabX0 && y<=fabYm && y>=fabY0){
            Toast.makeText(MainActivity.this, "in fab", Toast.LENGTH_SHORT).show();
        }

        switch (action){
            case MotionEvent.ACTION_DOWN:
                Log.i("Ness", "Down " + x + ", " + y);
                return true;
            case MotionEvent.ACTION_MOVE:
                Log.i("Ness", "Move " + x + ", " + y);
                return true;
            case MotionEvent.ACTION_UP:
                Log.i("Ness", "Up " + x + ", " + y);
                return false;
        }

        return super.onTouchEvent(event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
