package com.apm.insight.o;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class w {
    private static long a() {
        try {
            return b(Environment.getRootDirectory());
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long a(File file) {
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

    public static JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("inner_free", a());
            jSONObject.put("inner_total", b());
            jSONObject.put("sdcard_free", e());
            jSONObject.put("sdcard_total", f());
            jSONObject.put("inner_free_real", c());
            jSONObject.put("inner_total_real", d());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private static long b() {
        try {
            return a(Environment.getRootDirectory());
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long b(File file) {
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

    private static long c() {
        try {
            return b(com.apm.insight.g.f().getFilesDir());
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private static long d() {
        try {
            return a(com.apm.insight.g.f().getFilesDir());
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private static long e() {
        return 0L;
    }

    private static long f() {
        return 0L;
    }
}
