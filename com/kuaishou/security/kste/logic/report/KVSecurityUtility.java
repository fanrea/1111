package com.kuaishou.security.kste.logic.report;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.ConditionVariable;
import android.os.Process;
import android.preference.PreferenceManager;
import com.kuaishou.security.kste.logic.base.XRay;
import com.kuaishou.security.kste.logic.util.KWLog;
import com.kuaishou.weapon.p0.t;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.List;
import java.util.Locale;
import java.util.zip.CRC32;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KVSecurityUtility {
    private static final String KGGUARD_SP_FILE = "com.fkgfasdfeeqeqe";
    private static final String KSGUARDALEADYPERF = "com.kwguard.security.sperf.aleadyLaunch";
    private static String VERSIONNAME = "";
    private static String appProcessName = null;
    private static String hostApkMd5 = "";
    private static String hostApkSignatureMd5 = "";
    private static volatile KVSecurityUtility instance = null;
    private static volatile boolean isFirstRunApp = false;
    private static volatile boolean isQueryedPerf = false;
    private static final boolean isRecordFail = false;
    private SharedPreferences ksSP;
    private Context mLocalContext;
    private static final String[] HEXDIGITS = {"0", "1", "2", "3", "4", "5", "6", "7", GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD, "9", "a", t.l, "c", "d", "e", "f"};
    private static final ConditionVariable pullLock = new ConditionVariable();

    public KVSecurityUtility(Context context) {
        CRC32 crc32 = new CRC32();
        setmLocalContext(context);
        crc32.update(getmLocalContext().getApplicationInfo().packageName.getBytes());
        setmLocalContext(context);
        try {
            setKsSP(getmLocalContext().getSharedPreferences(KGGUARD_SP_FILE, 0));
        } catch (Throwable unused) {
        }
    }

    public static String byteArrayToHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(byteToHexString(b));
        }
        return stringBuffer.toString();
    }

    private static String byteToHexString(byte b) {
        int i = b;
        if (b < 0) {
            i = b + 256;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArr = HEXDIGITS;
        sb.append(strArr[i / 16]);
        sb.append(strArr[i % 16]);
        return sb.toString();
    }

    private static void copyFileUsingFileChannels(File file, File file2) {
        try {
            FileChannel channel = new FileInputStream(file).getChannel();
            try {
                FileChannel channel2 = new FileOutputStream(file2).getChannel();
                try {
                    channel2.transferFrom(channel, 0L, channel.size());
                    channel2.close();
                    channel.close();
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    public static byte[] fullyReadFileToBytes(File file) throws IOException {
        int length = (int) file.length();
        byte[] bArr = new byte[length];
        byte[] bArr2 = new byte[length];
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            try {
                int i = fileInputStream.read(bArr, 0, length);
                if (i < length) {
                    int i2 = length - i;
                    while (i2 > 0) {
                        int i3 = fileInputStream.read(bArr2, 0, i2);
                        System.arraycopy(bArr2, 0, bArr, length - i2, i3);
                        i2 -= i3;
                    }
                }
                return bArr;
            } finally {
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e2) {
            throw e2;
        }
    }

    public static KVSecurityUtility get(Context context) {
        if (instance == null) {
            synchronized (KVSecurityUtility.class) {
                if (instance == null) {
                    instance = new KVSecurityUtility(context);
                }
            }
        }
        return instance;
    }

    public static KVSecurityUtility getInstance() {
        return get(XRay.get().getMInitParams().context());
    }

    public static String getMD5(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return byteArrayToHexString(MessageDigest.getInstance("MD5").digest(bArr));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getProcessName(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (!isEmpty(appProcessName)) {
            return appProcessName;
        }
        try {
            int iMyPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == iMyPid) {
                        String str = runningAppProcessInfo.processName;
                        appProcessName = str;
                        return str;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getSignatureMd5(Context context) {
        if (!isEmpty(hostApkSignatureMd5)) {
            return hostApkSignatureMd5;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            StringBuffer stringBuffer = new StringBuffer();
            for (Signature signature : packageInfo.signatures) {
                stringBuffer.append(getMD5(signature.toByteArray()));
                stringBuffer.append(",");
            }
            String string = stringBuffer.toString();
            hostApkSignatureMd5 = string;
            return string;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return hostApkSignatureMd5;
        } catch (Throwable unused) {
            return hostApkSignatureMd5;
        }
    }

    public static boolean isBlank(CharSequence charSequence) {
        int length;
        if (charSequence != null && (length = charSequence.length()) != 0) {
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(charSequence.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isBlankOrUnknown(String str) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            boolean z = false;
            for (int i = 0; i < length; i++) {
                if (Character.isWhitespace(str.charAt(i))) {
                    z = true;
                }
            }
            if (!z && !str.contains("")) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isInMainProcess(Context context) {
        String processName = getProcessName(context);
        return !isEmpty(processName) && processName.equals(context.getPackageName());
    }

    private void prepare() {
    }

    public String getAppVer() {
        if (!VERSIONNAME.isEmpty()) {
            return VERSIONNAME;
        }
        try {
            PackageInfo packageInfo = this.mLocalContext.getPackageManager().getPackageInfo(this.mLocalContext.getPackageName(), 64);
            if (packageInfo != null) {
                VERSIONNAME = packageInfo.versionName;
            }
        } catch (Throwable unused) {
        }
        return VERSIONNAME;
    }

    public String getHostApkMd5() {
        return "";
    }

    public String getKSGSPValue(String str) {
        return (str.length() == 0 || getKsSP() == null) ? "" : getKsSP().getString(str, "");
    }

    public SharedPreferences getKsSP() {
        return this.ksSP;
    }

    public String getProcessName() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (!isEmpty(appProcessName)) {
            return appProcessName;
        }
        try {
            int iMyPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) instance.mLocalContext.getSystemService("activity");
            if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == iMyPid) {
                        String str = runningAppProcessInfo.processName;
                        appProcessName = str;
                        return str;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Context getmLocalContext() {
        return this.mLocalContext;
    }

    public boolean isFirstRunHostApp() {
        if (isQueryedPerf) {
            KWLog.debug("read from volatile");
            return isFirstRunApp;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getmLocalContext());
        CRC32 crc32 = new CRC32();
        crc32.update(getmLocalContext().getApplicationInfo().packageName.getBytes());
        String str = String.format(Locale.getDefault(), "%s_%d", KSGUARDALEADYPERF, Long.valueOf(crc32.getValue()));
        boolean z = defaultSharedPreferences.getBoolean(str, false);
        if (!z) {
            SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
            editorEdit.putBoolean(str, true);
            editorEdit.apply();
        }
        isQueryedPerf = true;
        boolean z2 = !z;
        isFirstRunApp = z2;
        return z2;
    }

    public void setKSGSPValue(String str, String str2) {
        if (str.length() == 0 || str2.length() == 0 || getKsSP() == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = getKsSP().edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    public void setKsSP(SharedPreferences sharedPreferences) {
        this.ksSP = sharedPreferences;
    }

    public void setmLocalContext(Context context) {
        this.mLocalContext = context;
    }
}
