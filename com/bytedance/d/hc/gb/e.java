package com.bytedance.d.hc.gb;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class e {
    public static JSONObject d(Context context) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("inner_app_used", hc(context));
            jSONObject.put("inner_free", hc());
            jSONObject.put("inner_total", b());
            jSONObject.put("sdcard_app_used", b(context));
            jSONObject.put("sdcard_free", c());
            jSONObject.put("sdcard_total", u());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static long hc(Context context) {
        try {
            return b(com.bytedance.sdk.openadsdk.api.plugin.hc.d(context).getParentFile());
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long hc() {
        try {
            return hc(Environment.getRootDirectory());
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long b() {
        try {
            return d(Environment.getRootDirectory());
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long b(Context context) {
        File fileD;
        try {
            if (!d() || (fileD = com.bytedance.sdk.openadsdk.api.plugin.hc.d(context, (String) null)) == null) {
                return 0L;
            }
            return b(fileD.getParentFile());
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long c() {
        try {
            if (d()) {
                return Environment.getExternalStorageDirectory().getFreeSpace();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long u() {
        try {
            if (d()) {
                return Environment.getExternalStorageDirectory().getTotalSpace();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static boolean d() {
        return com.component.c.c.a.equals(Environment.getExternalStorageState());
    }

    public static long d(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getTotalBytes();
            }
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long hc(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getFreeBytes();
            }
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long b(File file) {
        long length;
        File[] fileArrListFiles = file.listFiles();
        long j = 0;
        if (fileArrListFiles == null) {
            return 0L;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                length = b(file2);
            } else {
                length = file2.length();
            }
            j += length;
        }
        return j;
    }
}
