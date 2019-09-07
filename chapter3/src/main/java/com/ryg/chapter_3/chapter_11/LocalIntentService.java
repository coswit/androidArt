package com.ryg.chapter_3.chapter_11;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

/**
 * @author Created by zhengjing on 2019-09-07.
 */
public class LocalIntentService extends IntentService {

    public static final String DATA = "data";

    private static final String TAG = "LocalIntentService";
    public LocalIntentService() {
        super("service");
    }


    @Override
    protected void onHandleIntent( Intent intent) {
        String action = intent.getStringExtra(DATA);
        Log.i(TAG, "onHandleIntent: "   + action);
        SystemClock.sleep(3000);
        if ("com.ryg.action.TASK1".equals(action)) {
            Log.d(TAG, "handle task: " + action);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
