package com.ss.mediakit.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import com.component.c.c;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AVMDLDeviceUtil {
    public static String sBoard;
    public static String sHardware;

    public static String getDeviceBoard() {
        try {
            if (sBoard == null) {
                sBoard = Build.BOARD;
            }
        } catch (Throwable unused) {
            sBoard = null;
        }
        return sBoard;
    }

    public static String getDeviceHardware() {
        try {
            if (sHardware == null) {
                sHardware = Build.HARDWARE;
            }
        } catch (Throwable unused) {
            sHardware = null;
        }
        return sHardware;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static long getTotalStorageSpaceKB() {
        StatFs sdcardState = getSdcardState();
        if (sdcardState == null) {
            return 0L;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            return (sdcardState.getBlockSizeLong() * sdcardState.getBlockCountLong()) / 1024;
        }
        return (sdcardState.getBlockSize() * sdcardState.getBlockCount()) / 1024;
    }

    private static StatFs getSdcardState() {
        if (c.a.equals(Environment.getExternalStorageState())) {
            return new StatFs(Environment.getExternalStorageDirectory().getPath());
        }
        return null;
    }

    public static long getTotalFreeStorageKB() {
        if (getSdcardState() != null) {
            return (r0.getAvailableBlocks() * r0.getBlockSize()) / 1024;
        }
        return 0L;
    }

    public static int getBatteryPercentage(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((BatteryManager) context.getSystemService("batterymanager")).getIntProperty(4);
        }
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return (int) (((intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("level", -1) : -1) / (intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("scale", -1) : -1)) * 100.0d);
    }

    public static boolean isPowerSaveMode(Context context) {
        if (context == null || Build.VERSION.SDK_INT < 21) {
            return false;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                return powerManager.isPowerSaveMode();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static HashMap<String, Object> getChargingState(Context context) {
        Intent intentRegisterReceiver;
        if (context == null || (intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"))) == null) {
            return null;
        }
        int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
        int i = (intExtra == 2 || intExtra == 5) ? 1 : 0;
        int intExtra2 = intentRegisterReceiver.getIntExtra("plugged", -1);
        int intExtra3 = (intentRegisterReceiver.getIntExtra("level", -1) * 100) / intentRegisterReceiver.getIntExtra("scale", -1);
        HashMap<String, Object> map = new HashMap<>(3);
        map.put("isCharging", Integer.valueOf(i));
        map.put("chargePlug", Integer.valueOf(intExtra2));
        map.put("power", Integer.valueOf(intExtra3));
        return map;
    }

    public static boolean isOverHeat(Context context) {
        if (context != null && Build.VERSION.SDK_INT >= 29) {
            try {
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                if (powerManager != null) {
                    return powerManager.getCurrentThermalStatus() >= 3;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
