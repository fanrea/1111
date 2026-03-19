package com.fendasz.moku.planet.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CustomerConfigManager {
    private static CustomerConfigManager configManger;
    private static Context mContext;

    public static CustomerConfigManager getInstance(Context context) {
        if (configManger == null) {
            configManger = new CustomerConfigManager(context);
        }
        return configManger;
    }

    private CustomerConfigManager(Context context) {
        mContext = context.getApplicationContext();
    }

    private SharedPreferences getMySharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(mContext);
    }

    public boolean setString(String str, String str2) {
        return getMySharedPreferences().edit().putString(str, str2).commit();
    }

    public String getString(String str) {
        return getMySharedPreferences().getString(str, "");
    }
}
