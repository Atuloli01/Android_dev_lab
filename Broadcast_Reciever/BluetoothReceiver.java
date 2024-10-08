package com.example.bluetoothreceiver;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BluetoothReceiver extends BroadcastReceiver {

    private static final String TAG = "BluetoothReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            switch (action) {
                case BluetoothAdapter.ACTION_STATE_CHANGED:
                    int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);
                    if (state == BluetoothAdapter.STATE_ON) {
                        Log.d(TAG, "Bluetooth is ON");
                    } else if (state == BluetoothAdapter.STATE_OFF) {
                        Log.d(TAG, "Bluetooth is OFF");
                    }
                    break;

                case BluetoothAdapter.ACTION_DISCOVERY_STARTED:
                    Log.d(TAG, "Bluetooth Discovery Started");
                    break;

                case BluetoothAdapter.ACTION_DISCOVERY_FINISHED:
                    Log.d(TAG, "Bluetooth Discovery Finished");
                    break;

                case BluetoothAdapter.ACTION_CONNECTION_STATE_CHANGED:
                    int connectionState = intent.getIntExtra(BluetoothAdapter.EXTRA_CONNECTION_STATE, BluetoothAdapter.ERROR);
                    if (connectionState == BluetoothAdapter.STATE_CONNECTED) {
                        Log.d(TAG, "Bluetooth Device Connected");
                    } else if (connectionState == BluetoothAdapter.STATE_DISCONNECTED) {
                        Log.d(TAG, "Bluetooth Device Disconnected");
                    }
                    break;

                default:
                    Log.d(TAG, "Unknown Bluetooth Action: " + action);
            }
        }
    }
}
