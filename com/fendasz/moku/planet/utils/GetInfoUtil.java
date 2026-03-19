package com.fendasz.moku.planet.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import com.alibaba.fastjson.JSON;
import com.baidu.mobads.container.util.e.a;
import com.fendasz.moku.planet.entity.MokuCellInfoCallback;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class GetInfoUtil {
    private static final String TAG = "MOKU_GetInfoUtil==>";
    private static final String[] rootRelatedDirs = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};

    public static int hasRootPrivilege() {
        boolean z;
        String[] strArr = rootRelatedDirs;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            if (new File(strArr[i]).exists()) {
                z = true;
                break;
            }
            i++;
        }
        return (Build.TAGS != null && Build.TAGS.contains("test-keys")) || z ? 1 : 0;
    }

    public static int isOpenDevelopmentSetting(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0 ? 1 : 0;
    }

    public static int isUSBDebugSetting(Activity activity) {
        return Settings.Secure.getInt(activity.getContentResolver(), "adb_enabled", 0) != 0 ? 1 : 0;
    }

    public static int getBasebandInfo() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        if (Build.VERSION.SDK_INT >= 28) {
            return 0;
        }
        String basebandVer = getBasebandVer();
        return (basebandVer.isEmpty() || basebandVer.length() < 3) ? 1 : 0;
    }

    public static String getBasebandVer() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls.newInstance(), "gsm.version.baseband", "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getBatteryCapacity(Context context) {
        double dDoubleValue;
        try {
            dDoubleValue = ((Double) Class.forName("com.android.internal.os.PowerProfile").getMethod("getBatteryCapacity", new Class[0]).invoke(Class.forName("com.android.internal.os.PowerProfile").getConstructor(Context.class).newInstance(context), new Object[0])).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
            dDoubleValue = 0.0d;
        }
        return String.valueOf(dDoubleValue);
    }

    public static Map<String, String> receiverBatteryOhterInfo(Context context) {
        HashMap map = new HashMap();
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = intentRegisterReceiver.getIntExtra("voltage", 0);
        int intExtra2 = intentRegisterReceiver.getIntExtra("level", 0);
        map.put("voltage", intExtra + "mv");
        map.put("level", intExtra2 + "%");
        map.put("temperature", (intentRegisterReceiver.getIntExtra("temperature", 0) / 10.0d) + "℃");
        return map;
    }

    public static String getWifiFreq(Context context) {
        if (Build.VERSION.SDK_INT < 21) {
            return "-1";
        }
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(a.a);
        if (wifiManager != null) {
            return wifiManager.getConnectionInfo().getFrequency() + "Hz";
        }
        return null;
    }

    public static String getCpuSchemaName() {
        try {
            String[] strArrSplit = new BufferedReader(new FileReader("/proc/cpuinfo")).readLine().split(":\\s+", 2);
            for (int i = 0; i < strArrSplit.length; i++) {
            }
            return strArrSplit[1];
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getCpuMinFreq() throws IOException {
        String str = "0";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.trim() + "Hz";
    }

    public static String getCpuCurrentFreq() {
        String strTrim;
        try {
            strTrim = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq")).readLine().trim();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            strTrim = "0";
            return strTrim + "Hz";
        } catch (IOException e2) {
            e2.printStackTrace();
            strTrim = "0";
            return strTrim + "Hz";
        }
        return strTrim + "Hz";
    }

    public static String getPixels(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i;
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        int i2 = 0;
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            i = displayMetrics.widthPixels;
            try {
                i2 = displayMetrics.heightPixels;
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                return i + "*" + i2;
            }
        } catch (Exception e2) {
            e = e2;
            i = 0;
        }
        return i + "*" + i2;
    }

    public static int isAliPayInstalled(Context context) {
        return new Intent("android.intent.action.VIEW", Uri.parse("alipays://platformapi/startApp")).resolveActivity(context.getPackageManager()) != null ? 1 : 0;
    }

    public static int isWeixinAvilible(Context context) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages != null) {
            for (int i = 0; i < installedPackages.size(); i++) {
                if (installedPackages.get(i).packageName.equals("com.tencent.mm")) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static String getSerialNum() throws ClassNotFoundException {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                return "OOR";
            }
            if (Build.VERSION.SDK_INT == 28) {
                return Build.getSerial();
            }
            if (Build.VERSION.SDK_INT >= 26) {
                return Build.SERIAL;
            }
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, "ro.serialno");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String, String> getCurrentTime() {
        HashMap map = new HashMap();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jUptimeMillis = SystemClock.uptimeMillis();
        String time = DensityUtils.formatTime(Long.valueOf(jElapsedRealtime));
        String time2 = DensityUtils.formatTime(Long.valueOf(jUptimeMillis));
        map.put("elapsedRealtime", time);
        map.put("uptimeMillis", time2);
        return map;
    }

    public static String getStartupTime() {
        return TimeUtil.formatData(new Date(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
    }

    public static void getSimCardInfo(Context context, MokuCellInfoCallback.CellInfoCallBack cellInfoCallBack) {
        Log.d(TAG, "getSimCardInfo");
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (Build.VERSION.SDK_INT >= 29) {
            ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
            MokuCellInfoCallback mokuCellInfoCallback = new MokuCellInfoCallback();
            mokuCellInfoCallback.setCallBack(cellInfoCallBack);
            try {
                try {
                    telephonyManager.requestCellInfoUpdate(executorServiceNewCachedThreadPool, mokuCellInfoCallback);
                    executorServiceNewCachedThreadPool.awaitTermination(1000L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    executorServiceNewCachedThreadPool.shutdownNow();
                    cellInfoCallBack.cellError(0, e.getMessage());
                }
                return;
            } finally {
                mokuCellInfoCallback.setCallBack(null);
            }
        }
        String jSONString = JSON.toJSONString(telephonyManager.getAllCellInfo());
        LogUtils.logE(TAG, "cellList=>" + jSONString);
        cellInfoCallBack.cellSuccess(1, jSONString);
    }

    public static int getAccessibilityModel(Context context) {
        boolean zIsEnabled = ((AccessibilityManager) context.getSystemService("accessibility")).isEnabled();
        Log.d(TAG, "isEnabled:" + zIsEnabled);
        return zIsEnabled ? 1 : 0;
    }
}
