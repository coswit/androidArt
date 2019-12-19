package com.ryg.chapter_3.testThread;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class StandardService extends Service {
    public StandardService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
