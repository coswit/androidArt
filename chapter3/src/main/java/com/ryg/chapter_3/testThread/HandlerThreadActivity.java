package com.ryg.chapter_3.testThread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ryg.chapter_3.R;

public class HandlerThreadActivity extends Activity {

    private String TAG = "HandlerThreadActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_thread);


    }

    private class WorkHandler extends Handler {
        WorkHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String str = (String) msg.obj;
            Toast.makeText(HandlerThreadActivity.this,str,Toast.LENGTH_SHORT).show();
            Log.d(TAG, Thread.currentThread().getName() + " thread receiver the message from thread: " + msg.obj);
        }
    }


    public void onButtonClick(View v) {
        if (v.getId() == R.id.button1) {
            HandlerThread hThread = new HandlerThread("hThread"){
                @Override
                public void run() {
                    super.run();

                }
            };
            WorkHandler workHandler = new WorkHandler(hThread.getLooper());
            hThread.start();

            Message message = workHandler.obtainMessage();
            message.obj = hThread.getName();
            workHandler.sendMessage(message);

        }
    }
}
