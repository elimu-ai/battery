package org.literacyapp.battery;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import org.literacyapp.battery.util.VersionHelper;

public class BatteryApplication extends Application {

    public static final String PREF_APP_VERSION_CODE = "pref_app_version_code";

    @Override
    public void onCreate() {
        Log.i(getClass().getName(), "onCreate");
        super.onCreate();

        // Check if the application's versionCode was upgraded
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        int oldVersionCode = sharedPreferences.getInt(PREF_APP_VERSION_CODE, 0);
        int newVersionCode = VersionHelper.getAppVersionCode(getApplicationContext());
        if ((oldVersionCode > 0) && (oldVersionCode < newVersionCode)) {
            Log.i(getClass().getName(), "Upgrading application from version " + oldVersionCode + " to " + newVersionCode);
//            if (newVersionCode == ???) {
//                // Put relevant tasks required for upgrading here
//            }
            sharedPreferences.edit().putInt(PREF_APP_VERSION_CODE, newVersionCode).commit();
        }
    }
}
