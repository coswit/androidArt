package com.ryg.chapter_2.utils;

import android.content.Context;
import android.os.Environment;

public class MyConstants {
    public static final String CHAPTER_2_PATH = Environment
            .getExternalStorageDirectory().getPath()
            + "/singwhatiwanna/chapter_2/";

    public static final String CACHE_FILE_PATH = CHAPTER_2_PATH + "usercache";

    public static final int MSG_FROM_CLIENT = 0;
    public static final int MSG_FROM_SERVICE = 1;

    public static String getCachePath(Context context) {
        String cachePath = null;

        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || !Environment
                .isExternalStorageRemovable()) {

            cachePath = context.getExternalCacheDir().getPath();
        } else {
            cachePath = context.getCacheDir().getPath();
        }
        cachePath = cachePath + "/singwhatiwanna/chapter_2/";
        return cachePath;
    }

    public static String getCacheFilePath(Context context){
        return getCachePath(context) + "usercache";
    }

}
