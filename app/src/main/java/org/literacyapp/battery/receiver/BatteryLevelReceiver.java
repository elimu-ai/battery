package org.literacyapp.battery.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;

public class BatteryLevelReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(getClass().getName(), "onReceive");

        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        Log.i(getClass().getName(), "level: " + level);

        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        Log.i(getClass().getName(), "scale: " + scale);

        float batteryPercentage = level / (float) scale;
        Log.i(getClass().getName(), "batteryPercentage: " + batteryPercentage);

        // TODO: handle low level
    }
}
