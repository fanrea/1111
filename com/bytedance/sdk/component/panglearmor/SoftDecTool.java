package com.bytedance.sdk.component.panglearmor;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.component.sdk.annotation.HungeonFlag;
import com.bytedance.sdk.component.utils.mq;
import com.pandora.common.utils.Times;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class SoftDecTool {
    public static final String SP_NAME = "softdec";
    public static volatile boolean a = false;
    public static volatile double acs = -1.0d;
    public static volatile long act = 0;
    private static volatile boolean b = true;
    private static SharedPreferences d = null;
    public static volatile boolean f = false;
    public static volatile boolean h = false;
    private static volatile int hc;

    @HungeonFlag
    public static native Object b(int i, Object[] objArr);

    public static native byte[] bc(int i, byte[] bArr);

    /* JADX WARN: Multi-variable type inference failed */
    @DungeonFlag
    public static int b() throws Throwable {
        InputStream inputStream;
        ZipFile zipFile;
        InputStream inputStream2;
        InputStream inputStream3;
        String strAn = an.an();
        if (strAn.isEmpty()) {
            return 1;
        }
        int iEquals = 11;
        iEquals = 11;
        iEquals = 11;
        InputStream inputStream4 = null;
        try {
            zipFile = new ZipFile(strAn + "/apk/base-1.apk");
            try {
                inputStream3 = zipFile.getInputStream(zipFile.getEntry("classes.dex"));
            } catch (Exception unused) {
                inputStream2 = null;
            } catch (Throwable th) {
                th = th;
                inputStream = null;
            }
        } catch (Exception unused2) {
            inputStream2 = null;
            zipFile = null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            zipFile = null;
        }
        try {
            String strD = d(inputStream3);
            String str = strD.substring(strD.length() / 2) + strD.substring(0, strD.length() / 2);
            ZipEntry entry = zipFile.getEntry("assets/pangle_vp_config.db");
            if (entry != null) {
                inputStream4 = zipFile.getInputStream(entry);
                byte[] bArr = new byte[inputStream4.available()];
                inputStream4.read(bArr);
                iEquals = new String(bArr).equals(str);
            }
            if (inputStream3 != null) {
                try {
                    inputStream3.close();
                } catch (IOException unused3) {
                }
            }
            if (inputStream4 != null) {
                try {
                    inputStream4.close();
                } catch (IOException unused4) {
                }
            }
        } catch (Exception unused5) {
            InputStream inputStream5 = inputStream4;
            inputStream4 = inputStream3;
            inputStream2 = inputStream5;
            if (inputStream4 != null) {
                try {
                    inputStream4.close();
                } catch (IOException unused6) {
                }
            }
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException unused7) {
                }
            }
            if (zipFile != null) {
                zipFile.close();
            }
            return iEquals;
        } catch (Throwable th3) {
            th = th3;
            InputStream inputStream6 = inputStream4;
            inputStream4 = inputStream3;
            inputStream = inputStream6;
            if (inputStream4 != null) {
                try {
                    inputStream4.close();
                } catch (IOException unused8) {
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused9) {
                }
            }
            if (zipFile != null) {
                try {
                    zipFile.close();
                    throw th;
                } catch (IOException unused10) {
                    throw th;
                }
            }
            throw th;
        }
        try {
            zipFile.close();
        } catch (IOException unused11) {
        }
        return iEquals;
    }

    @DungeonFlag
    private static String d(InputStream inputStream) throws NoSuchAlgorithmException, IOException {
        int i;
        try {
            byte[] bArr = new byte[8192];
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i2);
            }
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b2 : bArrDigest) {
                int i3 = b2 & 255;
                if (i3 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i3));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UnsupportedEncodingException", e);
        } catch (IOException e2) {
            mq.d(e2);
            return "";
        } catch (NoSuchAlgorithmException e3) {
            throw new RuntimeException("NoSuchAlgorithmException", e3);
        }
    }

    @DungeonFlag
    public static String p() {
        return com.bytedance.sdk.openadsdk.api.plugin.hc.d(an.c()).getPath();
    }

    @DungeonFlag
    public static int u() {
        UsbAccessory[] accessoryList = ((UsbManager) an.c().getSystemService("usb")).getAccessoryList();
        return (accessoryList == null || accessoryList.length == 0) ? 0 : 1;
    }

    @DungeonFlag
    public static void cs(String str) {
        SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("sofchara", str).putLong("t", System.currentTimeMillis()).apply();
        }
    }

    @DungeonFlag
    public static String gc() {
        SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("sofchara", "");
            long j = sharedPreferences.getLong("t", 0L);
            if (j != 0 && !TextUtils.isEmpty(string) && System.currentTimeMillis() - j <= 300000) {
                return string;
            }
        }
        return "";
    }

    @DungeonFlag
    public static String i() {
        int i = hc + 1;
        hc = i;
        if (i != 2) {
            return "2";
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) an.c().getSystemService("accessibility");
            TreeSet treeSet = new TreeSet();
            for (AccessibilityServiceInfo accessibilityServiceInfo : accessibilityManager.getInstalledAccessibilityServiceList()) {
                treeSet.add(String.format("%s#%s", accessibilityServiceInfo.getResolveInfo().serviceInfo.packageName, accessibilityServiceInfo.getResolveInfo().serviceInfo.name));
            }
            JSONArray jSONArray = new JSONArray((Collection) treeSet);
            SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
            String string = jSONArray.toString();
            String str = new SimpleDateFormat(Times.YYYY_MM_DD).format(new Date());
            String string2 = sharedPreferences.getString("iacba", "");
            String string3 = sharedPreferences.getString("date", "1970-01-01");
            if (string2.equals(jSONArray.toString()) && str.equals(string3)) {
                return "2";
            }
            sharedPreferences.edit().putString("iacba", string).apply();
            sharedPreferences.edit().putString("date", str).apply();
            return string;
        } catch (Throwable th) {
            mq.d(th);
            return "-1";
        }
    }

    @DungeonFlag
    public static synchronized int h(String str, boolean z) {
        try {
            SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
            int i = sharedPreferences.getInt(str, 0);
            if (!z) {
                return i;
            }
            int i2 = i + 1;
            sharedPreferences.edit().putInt(str, i2).apply();
            return i2;
        } catch (Throwable th) {
            mq.d(th);
            return -1;
        }
    }

    @DungeonFlag
    public static long tft() {
        return an.gb();
    }

    @DungeonFlag
    public static int trc() {
        return an.tt();
    }

    @DungeonFlag
    public static String dn() {
        try {
            return !b ? "no_collection_allowed" : Settings.Secure.getString(an.c().getContentResolver(), "bluetooth_name");
        } catch (Throwable unused) {
            return "-1";
        }
    }

    @DungeonFlag
    public static long fi() {
        try {
            return an.c().getPackageManager().getPackageInfo(an.c().getPackageName(), 0).firstInstallTime / 1000;
        } catch (PackageManager.NameNotFoundException e) {
            mq.d(e);
            return 0L;
        }
    }

    @DungeonFlag
    public static long fr() {
        SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
        if (sharedPreferences == null) {
            return 0L;
        }
        long j = sharedPreferences.getLong("frt", 0L);
        if (j != 0) {
            return j;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        sharedPreferences.edit().putLong("frt", jCurrentTimeMillis).apply();
        return jCurrentTimeMillis;
    }

    @DungeonFlag
    public static String kv() {
        return System.getProperty("os.version");
    }

    @DungeonFlag
    public static String prx() {
        String property = System.getProperty("http.proxyHost");
        String property2 = System.getProperty("http.proxyPort");
        return (TextUtils.isEmpty(property) && TextUtils.isEmpty(property2)) ? "" : String.format("%s:%s", property, property2);
    }

    @DungeonFlag
    public static int hv() {
        if (Build.VERSION.SDK_INT < 23) {
            return -1;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) an.c().getSystemService("connectivity");
            return connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork()).hasCapability(15) ? 0 : 1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    @DungeonFlag
    public static JSONObject gdh() {
        List<Sensor> sensorList;
        try {
            SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
            if (sharedPreferences == null || sharedPreferences.getBoolean("reported_devicehardware_2", false) || an.c() == null || d(an.c().getPackageManager().getPackageInfo(an.c().getPackageName(), 0).firstInstallTime, System.currentTimeMillis())) {
                return null;
            }
            TreeSet treeSet = new TreeSet();
            SensorManager sensorManager = (SensorManager) an.c().getSystemService("sensor");
            if (sensorManager != null && (sensorList = sensorManager.getSensorList(-1)) != null) {
                for (Sensor sensor : sensorList) {
                    if (sensor != null) {
                        treeSet.add(String.format(Locale.getDefault(), "%s###%s###%d", sensor.getName(), sensor.getVendor(), Integer.valueOf(sensor.getType())));
                    }
                }
            }
            String strD = an.d("gsm.version.baseband", "");
            String strD2 = an.d("ro.build.fingerprint", "");
            String property = System.getProperty("os.version");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sensors", treeSet);
            jSONObject.put("radio", strD);
            jSONObject.put("fp", strD2);
            jSONObject.put("kernel", property);
            jSONObject.put("rom_version", an.d("ro.build.display.id", ""));
            jSONObject.put("build_id", an.d("ro.build.id", ""));
            jSONObject.put("incremental", an.d("ro.build.version.incremental", ""));
            jSONObject.put("compiling_time", an.d("ro.build.date.utc", ""));
            sharedPreferences.edit().putBoolean("reported_devicehardware_2", true).apply();
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    @DungeonFlag
    public static void rsd(final String str) {
        com.bytedance.sdk.component.utils.gb.d().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.panglearmor.SoftDecTool.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    gb gbVarH = an.h();
                    if (gbVarH != null) {
                        JSONObject jSONObjectGdh = SoftDecTool.gdh();
                        if (jSONObjectGdh == null && !TextUtils.isEmpty(str)) {
                            jSONObjectGdh = new JSONObject();
                        }
                        if (jSONObjectGdh != null) {
                            if (!TextUtils.isEmpty(str)) {
                                jSONObjectGdh.put("rd2", str);
                            }
                            gbVarH.d("device_hardware", jSONObjectGdh);
                        }
                    }
                } catch (Throwable th) {
                    mq.d(th);
                }
            }
        }, 20000L);
    }

    private static boolean d(long j, long j2) {
        long j3 = j2 - j;
        return j3 < 86400000 && j3 > -86400000 && d(j) == d(j2);
    }

    private static long d(long j) {
        return (j + TimeZone.getDefault().getOffset(j)) / 86400000;
    }

    public static SharedPreferences getSharedPreferences(String str) {
        if (d == null) {
            try {
                Context contextC = an.c();
                if (contextC != null && str != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        Context contextCreateDeviceProtectedStorageContext = contextC.createDeviceProtectedStorageContext();
                        if (!contextCreateDeviceProtectedStorageContext.moveSharedPreferencesFrom(contextC, str)) {
                            mq.hc("HARLOG", "Failed to move shared preferences.");
                        }
                        contextC = contextCreateDeviceProtectedStorageContext;
                    }
                    d = com.bytedance.sdk.openadsdk.api.plugin.hc.hc(contextC, str, 0);
                }
                return null;
            } catch (Exception unused) {
            }
        }
        return d;
    }

    @DungeonFlag
    public static synchronized Object cn(int i, Object[] objArr) {
        if (!tt.hc()) {
            return null;
        }
        return b(i, objArr);
    }

    @DungeonFlag
    private static int d(String str, String str2) {
        String strD = an.d(str2, "unknown");
        return (str.equals("unknown") || strD.equals("unknown") || str.equals(strD)) ? 0 : 1;
    }

    @DungeonFlag
    public static String dgb() throws NumberFormatException {
        StringBuilder sb = new StringBuilder();
        sb.append(d(Build.BOARD, "ro.product.board"));
        sb.append(d(Build.MODEL, "ro.product.model"));
        sb.append(d(Build.VERSION.RELEASE, "ro.build.version.release"));
        sb.append(d(Build.MANUFACTURER, "ro.product.manufacturer"));
        sb.append(d(Build.DISPLAY, "ro.build.display.id"));
        long j = Build.TIME;
        long j2 = Long.parseLong(an.d("ro.build.date.utc", "-1"));
        if (j == -1000 || j2 == -1) {
            sb.append("00");
        } else {
            if (String.valueOf(j).length() >= 10) {
                sb.append(Long.parseLong(String.valueOf(j).substring(0, 10)) == j2 ? 0 : 1);
            } else {
                sb.append(1);
            }
            sb.append(j != j2 * 1000 ? 1 : 0);
        }
        return sb.toString();
    }

    public static void ua() {
        SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
        if (sharedPreferences != null) {
            acs = sharedPreferences.getFloat("acs", -1.0f);
            act = sharedPreferences.getLong("act", 0L);
        }
    }

    public static void ua(double d2, long j) {
        acs = d2;
        act = j;
        SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putFloat("acs", (float) d2).putLong("act", j).apply();
        }
    }

    public static void setBlt(boolean z) {
        b = z;
    }
}
