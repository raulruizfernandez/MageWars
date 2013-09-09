package com.camaleon2d.objects;

import android.os.Looper;

import com.camaleon2d.magewars.BuildConfig;

public class ThreadPreconditions {
        
	public static void checkOnMainThread() {
        if (BuildConfig.DEBUG) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                throw new IllegalStateException("This method should be called from the Main Thread");
            }
        }
    }
    	
    
	
}
