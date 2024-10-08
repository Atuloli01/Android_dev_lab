package com.example.boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyBoundService extends Service {

    private static final String TAG = "MyBoundService";

    // Binder given to clients
    private final IBinder binder = new LocalBinder();

    // Binder class to return the instance of the service to the clients
    public class LocalBinder extends Binder {
        MyBoundService getService() {
            return MyBoundService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Service Created");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "Service Bound");
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "Service Unbound");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Service Destroyed");
    }

    // Method for clients
    public String getTimestamp() {
        return "Current Time: " + System.currentTimeMillis();
    }
}
