package com.example.startedservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = "MyService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Service Created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "Service Started");
        // Simulate a background task (running in the background)
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Simulate some work (e.g., downloading or processing)
                    for (int i = 1; i <= 5; i++) {
                        Thread.sleep(1000);  // Simulate task
                        Log.d(TAG, "Service is running: " + i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stopSelf(); // Stop service after the task is completed
            }
        }).start();
        return START_STICKY;  // Service will be restarted if it's killed by the system
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Service Destroyed");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;  // Binding is not used in a started service
    }
}
