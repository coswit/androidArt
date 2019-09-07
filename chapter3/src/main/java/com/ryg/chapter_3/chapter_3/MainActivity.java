package com.ryg.chapter_3.chapter_3;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ClipDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.ryg.chapter_3.R;
import com.ryg.chapter_3.chapter_11.LocalIntentService;

public class MainActivity extends Activity {

    private ThreadLocal<Boolean> mBooleanThreadLocal = new ThreadLocal<Boolean>();

    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView testClip = (ImageView) findViewById(R.id.test_clip);
        ClipDrawable testClipDrawable = (ClipDrawable) testClip.getDrawable();
        testClipDrawable.setLevel(5000);

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                return null;
            }
        }.execute();
    }

    public void onButtonClick(View v) {
        if (v.getId() == R.id.button1) {
//            Intent intent = new Intent(this, TestActivity.class);
//            startActivity(intent);
            testThreadLocal();
        } else if (v.getId() == R.id.button2) {
            Intent intent = new Intent(this, DemoActivity_1.class);
            startActivity(intent);
        } else if (v.getId() == R.id.button3) {
            Intent intent = new Intent(this, DemoActivity_2.class);
            startActivity(intent);
        } else if (v.getId() == R.id.button4) {
            Intent intent = new Intent(this, LocalIntentService.class);
            intent.putExtra(LocalIntentService.DATA,"service 传递数据");
            startService(intent);
            intent.putExtra(LocalIntentService.DATA,"com.ryg.action.TASK1");
            startService(intent);
            intent.putExtra(LocalIntentService.DATA,"com.ryg.action.TASK2");
            startService(intent);

        }

    }

    private void testThreadLocal() {

        mBooleanThreadLocal.set(true);
        Log.d(TAG, "[Thread#main]mBooleanThreadLocal=" + mBooleanThreadLocal.get());


        new Thread("Thread#1") {
            @Override
            public void run() {
                mBooleanThreadLocal.set(false);
                Log.d(TAG, "[Thread#1]mBooleanThreadLocal=" + mBooleanThreadLocal.get());
            }

            ;
        }.start();


        new Thread("Thread#2") {
            @Override
            public void run() {
                Log.d(TAG, "[Thread#2]mBooleanThreadLocal=" + mBooleanThreadLocal.get());
            }

            ;
        }.start();
    }
}
