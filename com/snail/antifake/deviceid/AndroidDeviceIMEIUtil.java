package com.snail.antifake.deviceid;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.snail.antifake.deviceid.IpScanner;
import com.snail.antifake.deviceid.androidid.IAndroidIdUtil;
import com.snail.antifake.deviceid.deviceid.DeviceIdUtil;
import com.snail.antifake.deviceid.emulator.EmuCheckUtil;
import com.snail.antifake.deviceid.macaddress.MacAddressUtils;
import com.snail.antifake.jni.PropertiesGet;
import java.net.SocketException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AndroidDeviceIMEIUtil {
    public static BatteryChangeReceiver sBatteryChangeReceiver;

    public static boolean isRunOnEmulator(Context context) {
        return EmuCheckUtil.mayOnEmulator(context);
    }

    public static String getDeviceId(Context context) {
        return DeviceIdUtil.getDeviceId(context);
    }

    public static String getAndroidId(Context context) {
        return IAndroidIdUtil.getAndroidId(context);
    }

    public static String getMacAddress(Context context) {
        return MacAddressUtils.getMacAddress(context);
    }

    public static String getSerialno() {
        String string = "";
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                string = Build.getSerial();
            } else {
                string = PropertiesGet.getString("ro.serialno");
                if (TextUtils.isEmpty(string)) {
                    string = Build.SERIAL;
                }
            }
        } catch (Exception unused) {
        }
        return string;
    }

    public static String getManufacturer() {
        return PropertiesGet.getString("ro.product.manufacturer");
    }

    public static String getBrand() {
        return PropertiesGet.getString("ro.product.brand");
    }

    public static String getModel() {
        return PropertiesGet.getString("ro.product.model");
    }

    public static String getCpuAbi() {
        return PropertiesGet.getString("ro.product.cpu.abi");
    }

    public static String getDevice() {
        return PropertiesGet.getString("ro.product.device");
    }

    public static String getBoard() {
        return PropertiesGet.getString("ro.product.board");
    }

    public static String getHardware() {
        return PropertiesGet.getString("ro.hardware");
    }

    public static String getBootloader() {
        return PropertiesGet.getString("ro.bootloader");
    }

    public static String getIMSI(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
    }

    public static void registerBatteryChangeListener(Context context) {
        if (sBatteryChangeReceiver == null) {
            sBatteryChangeReceiver = new BatteryChangeReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            context.registerReceiver(sBatteryChangeReceiver, intentFilter);
        }
    }

    public static void unRegisterBatteryChangeListener(Context context) {
        BatteryChangeReceiver batteryChangeReceiver = sBatteryChangeReceiver;
        if (batteryChangeReceiver == null) {
            context.unregisterReceiver(batteryChangeReceiver);
            sBatteryChangeReceiver = null;
        }
    }

    public static boolean isCharging() {
        BatteryChangeReceiver batteryChangeReceiver = sBatteryChangeReceiver;
        return (batteryChangeReceiver == null || batteryChangeReceiver.isCharging()) ? false : true;
    }

    public static int getCurrentBatteryLevel() {
        BatteryChangeReceiver batteryChangeReceiver = sBatteryChangeReceiver;
        if (batteryChangeReceiver != null) {
            return batteryChangeReceiver.getCurrentLevel();
        }
        return -1;
    }

    public static void getMac(IpScanner.OnScanListener onScanListener) throws SocketException {
        new IpScanner().startScan(onScanListener);
    }
}
