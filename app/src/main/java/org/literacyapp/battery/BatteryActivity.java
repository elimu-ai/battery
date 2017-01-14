package org.literacyapp.battery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class BatteryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);
        Intent intent = new Intent();
        intent.setAction("literacyapp.intent.action.BATTERY_STATUS_CHANGED");
        sendBroadcast(intent);

    }
}
