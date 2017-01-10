package org.literacyapp.battery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;


public class BatteryReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        float batteryPct = level / (float)scale;

        Log.d("Battery status: ", String.valueOf(batteryPct));

        if(batteryPct <= 10) {
            Intent batteryIntent = new Intent(context, BatteryActivity.class);
            context.startActivity(batteryIntent);
        }

    }
}
