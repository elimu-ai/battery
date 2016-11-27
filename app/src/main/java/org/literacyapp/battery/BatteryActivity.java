package org.literacyapp.battery;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class BatteryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(getClass().getName(), "onCreate");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_battery);

        TextView mcheckBatteryStatus = (TextView) findViewById(R.id.checkBatteryStatus);
        mcheckBatteryStatus.setText(String.valueOf(checkBatteryStatus()));

        Log.d("BATTERY: ", String.valueOf(checkBatteryStatus()));

    }

    public int checkBatteryStatus (){
        int level = 0;

        Intent battery = registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        level = battery.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);

        return level;
    }


}
