package com.kwai.middleware.azeroth.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.PowerManager;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.baidu.mobads.container.w.f.a;
import com.baidu.mobstat.forbes.Config;
import com.kuaishou.weapon.p0.t;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SystemUtils {
    private static String sAndroidId;
    private static String sMacAddress;
    private static String sProcessName;
    private static int sTargetSdkVersion;

    public static boolean isStartFromActivity(Context context) {
        return getTopActivity(context) != null;
    }

    public static ComponentName getTopActivity(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (runningTasks = activityManager.getRunningTasks(1)) == null || runningTasks.isEmpty()) {
            return null;
        }
        return runningTasks.get(0).topActivity;
    }

    public static boolean isInMainProcess(Context context) {
        String processName = getProcessName(context);
        return !android.text.TextUtils.isEmpty(processName) && processName.equals(context.getPackageName());
    }

    public static String getProcessName(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (!android.text.TextUtils.isEmpty(sProcessName)) {
            return sProcessName;
        }
        try {
            int iMyPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == iMyPid) {
                        String str = runningAppProcessInfo.processName;
                        sProcessName = str;
                        return str;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Locale getDefaultLocale() {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = LocaleList.getDefault().get(0);
        } else {
            locale = Locale.getDefault();
        }
        return locale == null ? Locale.ROOT : locale;
    }

    public static String getAcceptLanguage() {
        StringBuilder sb = new StringBuilder(getDefaultLocale().getLanguage());
        String country = Locale.getDefault().getCountry();
        if (!android.text.TextUtils.isEmpty(country)) {
            sb.append(SignatureImpl.SEP);
            sb.append(country);
        }
        return sb.toString().toLowerCase();
    }

    public static String getCountryIso(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return getDefaultLocale().getCountry();
        }
        try {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return networkCountryIso;
            }
        } catch (Exception unused) {
        }
        try {
            String simCountryIso = telephonyManager.getSimCountryIso();
            if (!TextUtils.isEmpty(simCountryIso)) {
                return simCountryIso;
            }
        } catch (Exception unused2) {
        }
        return getDefaultLocale().getCountry();
    }

    public static long getRomTotalSpace() {
        return getDirectoryTotalSpace(Environment.getDataDirectory());
    }

    public static long getRomAvailableSpace() {
        return getDirectoryAvailableSpace(Environment.getDataDirectory());
    }

    public static long getSdcardTotalSpace() {
        return getDirectoryTotalSpace(Environment.getExternalStorageDirectory());
    }

    public static long getSdcardAvailableSpace() {
        return getDirectoryAvailableSpace(Environment.getExternalStorageDirectory());
    }

    public static long getAvailMemory(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return 0L;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static long getTotalMemory(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return 0L;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        if (Build.VERSION.SDK_INT >= 16) {
            return memoryInfo.totalMem;
        }
        return getRamTotalSize();
    }

    public static long getRamTotalSize() throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        String line;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(a.f), 8192);
            } catch (Exception unused) {
            } catch (Throwable th2) {
                bufferedReader = null;
                th = th2;
            }
            do {
                try {
                    line = bufferedReader.readLine();
                } catch (Exception unused2) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 == null) {
                        return 0L;
                    }
                    bufferedReader2.close();
                    return 0L;
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    throw th;
                }
                if (line == null) {
                    bufferedReader.close();
                    return 0L;
                }
            } while (!line.contains(a.g));
            long jLongValue = Long.valueOf(line.split("\\s+")[1]).longValue() << 10;
            try {
                bufferedReader.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return jLongValue;
        } catch (IOException e3) {
            e3.printStackTrace();
            return 0L;
        }
    }

    public static long getDirectoryTotalSpace(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            if (Build.VERSION.SDK_INT < 18) {
                return statFs.getBlockSize() * statFs.getBlockCount();
            }
            return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
        } catch (IllegalArgumentException unused) {
            return 0L;
        }
    }

    public static long getDirectoryAvailableSpace(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            if (Build.VERSION.SDK_INT < 18) {
                return statFs.getBlockSize() * statFs.getAvailableBlocks();
            }
            return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
        } catch (IllegalArgumentException unused) {
            return 0L;
        }
    }

    public static int getCpuCoreCount() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.kwai.middleware.azeroth.utils.SystemUtils.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]+", file.getName());
                }
            }).length;
        } catch (Exception e) {
            e.printStackTrace();
            return Runtime.getRuntime().availableProcessors();
        }
    }

    public static int getCpuMaxFreqInKHz() throws Throwable {
        BufferedReader bufferedReader;
        Exception e;
        int i = 0;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"));
            } catch (Exception e2) {
                bufferedReader = null;
                e = e2;
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
                CloseableUtils.closeQuietly(bufferedReader);
                throw th;
            }
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    String strEmptyIfNull = TextUtils.emptyIfNull(line.trim());
                    if (!strEmptyIfNull.isEmpty()) {
                        i = Integer.parseInt(strEmptyIfNull);
                    }
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                CloseableUtils.closeQuietly(bufferedReader);
                return i;
            }
            CloseableUtils.closeQuietly(bufferedReader);
            return i;
        } catch (Throwable th2) {
            th = th2;
            CloseableUtils.closeQuietly(bufferedReader);
            throw th;
        }
    }

    public static List<String> getDNS() throws NoSuchMethodException, SecurityException {
        ArrayList arrayList = new ArrayList();
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            String[] strArr = {"net.dns1", "net.dns2", "net.dns3", "net.dns4"};
            for (int i = 0; i < 4; i++) {
                String str = (String) method.invoke(null, strArr[i]);
                if (str != null && !"".equals(str) && !arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static boolean isScreenOn(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return false;
        }
        try {
            if (Build.VERSION.SDK_INT >= 20) {
                return powerManager.isInteractive();
            }
            return powerManager.isScreenOn();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getMacAddress(Context context) throws SocketException {
        if (android.text.TextUtils.isEmpty(sMacAddress)) {
            try {
                WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(com.baidu.mobads.container.util.e.a.a);
                if (wifiManager == null) {
                    return "";
                }
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo != null) {
                    sMacAddress = connectionInfo.getMacAddress();
                }
                if (android.text.TextUtils.isEmpty(sMacAddress) || sMacAddress.equals(Config.DEF_MAC_ID)) {
                    Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        NetworkInterface networkInterface = (NetworkInterface) it.next();
                        if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                            byte[] hardwareAddress = networkInterface.getHardwareAddress();
                            if (hardwareAddress != null && hardwareAddress.length != 0) {
                                StringBuilder sb = new StringBuilder();
                                for (byte b : hardwareAddress) {
                                    sb.append(String.format("%02X:", Byte.valueOf(b)));
                                }
                                if (sb.length() > 0) {
                                    sb.deleteCharAt(sb.length() - 1);
                                }
                                sMacAddress = sb.toString();
                            }
                        }
                    }
                }
                if (android.text.TextUtils.isEmpty(sMacAddress) || sMacAddress.equals(Config.DEF_MAC_ID)) {
                    sMacAddress = TextUtils.emptyIfNull(new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream())).readLine());
                }
                sMacAddress = sMacAddress.toUpperCase(Locale.US);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sMacAddress;
    }

    public static String getAndroidId(Context context) {
        if (sAndroidId == null) {
            try {
                sAndroidId = TextUtils.leftPad(Settings.Secure.getString(context.getContentResolver(), "android_id"), 16, '0');
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return TextUtils.emptyIfNull(sAndroidId);
    }

    public static boolean aboveApiLevel(int i) {
        return getApiLevel() >= i;
    }

    public static int getApiLevel() {
        return Build.VERSION.SDK_INT;
    }

    public static boolean targetApiAbove(Context context, int i) {
        return getTargetApi(context) >= i;
    }

    public static int getTargetApi(Context context) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo;
        int i = sTargetSdkVersion;
        if (i > 0) {
            return i;
        }
        if (context == null) {
            return 0;
        }
        try {
            applicationInfo = context.getApplicationInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (applicationInfo != null) {
            int i2 = applicationInfo.targetSdkVersion;
            sTargetSdkVersion = i2;
            return i2;
        }
        ApplicationInfo applicationInfo2 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        if (applicationInfo2 != null) {
            int i3 = applicationInfo2.targetSdkVersion;
            sTargetSdkVersion = i3;
            return i3;
        }
        return 0;
    }

    public static boolean isInstalled(Context context, String str) throws PackageManager.NameNotFoundException {
        if (str != null && !"".equals(str)) {
            try {
                context.getPackageManager().getPackageInfo(str, 0);
                return true;
            } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            }
        }
        return false;
    }

    public static String installedAppVersion(Context context, String str) {
        if (isInstalled(context, str)) {
            try {
                return context.getPackageManager().getPackageInfo(str, 0).versionName;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    public static Application getApplication(Context context) {
        while (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        return (Application) context;
    }

    public static String getMetaData(Context context, String str) {
        String string;
        try {
            string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(str);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            string = null;
        }
        return string == null ? "" : string;
    }

    public static long getTotalMemoryBytes(Context context) {
        long totalMemBytes = Build.VERSION.SDK_INT >= 16 ? getTotalMemBytes(context) : 0L;
        return totalMemBytes == 0 ? getTotalMemKB() << 10 : totalMemBytes;
    }

    public static long getTotalMemKB() {
        try {
            for (String str : FileUtils.readLines(new File(a.f), Charsets.UTF_8)) {
                if (str.contains(a.g)) {
                    String[] strArrSplit = str.split("\\s+");
                    String str2 = strArrSplit.length > 2 ? strArrSplit[1] : null;
                    if (android.text.TextUtils.isEmpty(str2)) {
                        str2 = "0";
                    }
                    return Long.valueOf(str2).longValue();
                }
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long getTotalMemBytes(Context context) {
        ActivityManager.MemoryInfo memoryInfo = getMemoryInfo(context);
        if (memoryInfo != null) {
            return memoryInfo.totalMem;
        }
        return 0L;
    }

    public static long getAvailableMemBytes(Context context) {
        ActivityManager.MemoryInfo memoryInfo = getMemoryInfo(context);
        if (memoryInfo != null) {
            return memoryInfo.availMem;
        }
        return 0L;
    }

    private static ActivityManager.MemoryInfo getMemoryInfo(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    private static float sampleCpuUsage() throws IOException {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/stat", t.k);
            try {
                ArrayList arrayListAsArrayList = ArrayUtils.asArrayList(2, 3, 5, 6, 7, 8);
                String[] strArrSplit = TextUtils.emptyIfNull(randomAccessFile.readLine()).split(" +");
                BigInteger bigInteger = new BigInteger(strArrSplit[4]);
                BigInteger bigIntegerAdd = BigInteger.ZERO;
                Iterator it = arrayListAsArrayList.iterator();
                while (it.hasNext()) {
                    bigIntegerAdd = bigIntegerAdd.add(new BigInteger(strArrSplit[((Integer) it.next()).intValue()]));
                }
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException unused) {
                }
                randomAccessFile.seek(0L);
                String[] strArrSplit2 = TextUtils.emptyIfNull(randomAccessFile.readLine()).split(" +");
                BigInteger bigInteger2 = new BigInteger(strArrSplit2[4]);
                BigInteger bigIntegerAdd2 = BigInteger.ZERO;
                Iterator it2 = arrayListAsArrayList.iterator();
                while (it2.hasNext()) {
                    bigIntegerAdd2 = bigIntegerAdd2.add(new BigInteger(strArrSplit2[((Integer) it2.next()).intValue()]));
                }
                BigInteger bigIntegerSubtract = bigIntegerAdd2.add(bigInteger2).subtract(bigIntegerAdd.add(bigInteger));
                if (bigIntegerSubtract.compareTo(BigInteger.ZERO) <= 0) {
                    return 0.0f;
                }
                float fFloatValue = new BigDecimal(bigIntegerAdd2.subtract(bigIntegerAdd)).divide(new BigDecimal(bigIntegerSubtract), 3, RoundingMode.HALF_EVEN).floatValue();
                randomAccessFile.close();
                return fFloatValue;
            } finally {
            }
        } catch (IOException unused2) {
            return 0.0f;
        }
    }

    public static float readAdjustedCpuUsage() throws IOException {
        float fSampleCpuUsage = 0.0f;
        for (int i = 0; i < 5; i++) {
            fSampleCpuUsage = sampleCpuUsage();
            if (fSampleCpuUsage > 0.0f && fSampleCpuUsage <= 1.0f) {
                return fSampleCpuUsage;
            }
        }
        return fSampleCpuUsage > 1.0f ? 1.0f : 0.0f;
    }

    public static float getCurrentVolume(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return 0.0f;
        }
        try {
            int streamVolume = audioManager.getStreamVolume(3);
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            if (streamMaxVolume == 0) {
                return 0.0f;
            }
            return streamVolume / streamMaxVolume;
        } catch (NullPointerException unused) {
            return 0.0f;
        }
    }

    public static int getScreenBrightness(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
