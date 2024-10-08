package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Lifecycle";
    private TextView lifecycleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lifecycleText = findViewById(R.id.lifecycleText);
        logAndDisplay("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        logAndDisplay("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        logAndDisplay("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        logAndDisplay("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        logAndDisplay("onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logAndDisplay("onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logAndDisplay("onDestroy");
    }

    private void logAndDisplay(String lifecycleEvent) {
        Log.d(TAG, lifecycleEvent);
        String currentText = lifecycleText.getText().toString();
        lifecycleText.setText(currentText + "\n" + lifecycleEvent);
    }
}
