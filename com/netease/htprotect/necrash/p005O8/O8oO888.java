package com.netease.htprotect.necrash.p005O8;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.kwad.components.ct.api.tube.KSTubeParamInner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

/* renamed from: com.netease.htprotect.necrash.〇O8.O8〇oO8〇88, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O8oO888 {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static final String f181O8oO888 = ".CMDatsetRequireXGame530c.dat";

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static final String f182O8 = "necrash_info";

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static final String f183Ooo = "userid";

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static String m613O8oO888(Context context) {
        try {
            return context.getPackageName();
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static void m614O8oO888(Context context, String str) {
        try {
            context.getSharedPreferences(f182O8, 0).edit().putString(f183Ooo, str).apply();
        } catch (Exception unused) {
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static boolean m615O8oO888() {
        int iMyUid = Process.myUid() % KSTubeParamInner.FREE_ALL;
        if (iMyUid < 99000 || iMyUid > 99999) {
            return iMyUid >= 90000 && iMyUid <= 98999;
        }
        return true;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static boolean m616O8oO888(int i) {
        int i2 = i % KSTubeParamInner.FREE_ALL;
        if (i2 < 99000 || i2 > 99999) {
            return i2 >= 90000 && i2 <= 98999;
        }
        return true;
    }

    private static String Oo0(Context context) throws IOException {
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream fileInputStreamOpenFileInput = context.openFileInput(f181O8oO888);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStreamOpenFileInput);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
            }
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStreamOpenFileInput.close();
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    public static String m617O8(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f182O8, 0);
            if (sharedPreferences.contains(f183Ooo)) {
                return sharedPreferences.getString(f183Ooo, "");
            }
        } catch (Exception unused) {
        }
        return "";
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static int m618Ooo(int i) {
        return i % KSTubeParamInner.FREE_ALL;
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static String m619Ooo() {
        if (Build.VERSION.SDK_INT >= 21) {
            return TextUtils.join(",", Build.SUPPORTED_ABIS);
        }
        String str = Build.CPU_ABI;
        String str2 = Build.CPU_ABI2;
        return TextUtils.isEmpty(str2) ? str : str + "," + str2;
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public static String m620Ooo(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            return applicationInfo == null ? "" : applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static void m621Ooo(Context context, String str) throws IOException {
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput(f181O8oO888, 0);
            fileOutputStreamOpenFileOutput.write(str.getBytes());
            fileOutputStreamOpenFileOutput.close();
        } catch (Exception unused) {
        }
    }

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    public static String m622o0o0(Context context) throws IOException {
        String strOo0;
        String strReplace = "";
        try {
            strOo0 = Oo0(context);
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(strOo0)) {
            return strOo0;
        }
        strReplace = UUID.randomUUID().toString().replace("-", "");
        FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput(f181O8oO888, 0);
        fileOutputStreamOpenFileOutput.write(strReplace.getBytes());
        fileOutputStreamOpenFileOutput.close();
        return strReplace;
    }

    /* renamed from: 〇oO, reason: contains not printable characters */
    public static String m623oO(Context context) {
        try {
            return context.getApplicationInfo().nativeLibraryDir;
        } catch (Exception unused) {
            return "";
        }
    }
}
