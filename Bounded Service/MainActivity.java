package com.example.boundservice;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MyBoundService myService;
    private boolean isBound = false;

    private TextView timestampTextView;
    private Button getTimestampButton;

    // Defines callbacks for service binding, passed to bindService()
    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            // We've bound to MyBoundService, cast the IBinder and get MyBoundService instance
            MyBoundService.LocalBinder binder = (MyBoundService.LocalBinder) service;
            myService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            isBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timestampTextView = findViewById(R.id.timestampTextView);
        getTimestampButton = findViewById(R.id.getTimestampButton);

        getTimestampButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBound) {
                    // Call the service's method
                    String timestamp = myService.getTimestamp();
                    timestampTextView.setText(timestamp);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Bind to the service
        Intent intent = new Intent(this, MyBoundService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Unbind from the service
        if (isBound) {
            unbindService(connection);
            isBound = false;
        }
    }
}
