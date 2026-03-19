package com.bytedance.d.hc.gb;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class d {
    private static Field b = null;
    private static Field c = null;
    private static String d = null;
    private static Class<?> hc = null;
    private static boolean u = false;

    public static boolean b(Context context) {
        return false;
    }

    private static long d(int i) {
        if (i < 0) {
            return 0L;
        }
        return i * 1024;
    }

    public static boolean d(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ComponentName componentName;
        if (context == null) {
            return false;
        }
        String packageName = context.getPackageName();
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && !runningTasks.isEmpty() && (componentName = runningTasks.get(0).topActivity) != null) {
                if (packageName.equals(componentName.getPackageName())) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static ActivityManager.ProcessErrorStateInfo d(Context context, int i) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        for (int i2 = 0; i2 < i; i2++) {
            SystemClock.sleep(200L);
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                    if (processErrorStateInfo.condition == 2) {
                        return processErrorStateInfo;
                    }
                }
            }
        }
        return null;
    }

    public static boolean hc(Context context) {
        String strC = c(context);
        if (strC != null && strC.contains(":")) {
            return false;
        }
        if (strC == null || !strC.equals(context.getPackageName())) {
            return strC != null && strC.equals(context.getApplicationInfo().processName);
        }
        return true;
    }

    public static String c(Context context) {
        String str = d;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            d = mq.d(context);
        } catch (Throwable unused) {
        }
        String str2 = d;
        return str2 == null ? "" : str2;
    }

    public static void d(Context context, JSONObject jSONObject) {
        try {
            d(jSONObject);
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                hc(jSONObject, activityManager);
            }
            d(jSONObject, activityManager);
        } catch (Throwable unused) {
        }
    }

    private static void d(JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("native_heap_size", Debug.getNativeHeapSize());
        jSONObject2.put("native_heap_alloc_size", Debug.getNativeHeapAllocatedSize());
        jSONObject2.put("native_heap_free_size", Debug.getNativeHeapFreeSize());
        Runtime runtime = Runtime.getRuntime();
        jSONObject2.put("max_memory", runtime.maxMemory());
        jSONObject2.put("free_memory", runtime.freeMemory());
        jSONObject2.put("total_memory", runtime.totalMemory());
        if (activityManager != null) {
            jSONObject2.put("memory_class", activityManager.getMemoryClass());
            jSONObject2.put("large_memory_class", activityManager.getLargeMemoryClass());
        }
        jSONObject.put("app_memory_info", jSONObject2);
    }

    private static void hc(JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        jSONObject2.put("availMem", memoryInfo.availMem);
        jSONObject2.put("lowMemory", memoryInfo.lowMemory);
        jSONObject2.put("threshold", memoryInfo.threshold);
        jSONObject2.put("totalMem", h.d(memoryInfo));
        jSONObject.put("sys_memory_info", jSONObject2);
    }

    private static void d(JSONObject jSONObject) throws JSONException {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("dalvikPrivateDirty", d(memoryInfo.dalvikPrivateDirty));
        jSONObject2.put("dalvikPss", d(memoryInfo.dalvikPss));
        jSONObject2.put("dalvikSharedDirty", d(memoryInfo.dalvikSharedDirty));
        jSONObject2.put("nativePrivateDirty", d(memoryInfo.nativePrivateDirty));
        jSONObject2.put("nativePss", d(memoryInfo.nativePss));
        jSONObject2.put("nativeSharedDirty", d(memoryInfo.nativeSharedDirty));
        jSONObject2.put("otherPrivateDirty", d(memoryInfo.otherPrivateDirty));
        jSONObject2.put("otherPss", d(memoryInfo.otherPss));
        jSONObject2.put("otherSharedDirty", memoryInfo.otherSharedDirty);
        jSONObject2.put("totalPrivateClean", hc.d(memoryInfo));
        jSONObject2.put("totalPrivateDirty", memoryInfo.getTotalPrivateDirty());
        jSONObject2.put("totalPss", d(memoryInfo.getTotalPss()));
        jSONObject2.put("totalSharedClean", hc.hc(memoryInfo));
        jSONObject2.put("totalSharedDirty", d(memoryInfo.getTotalSharedDirty()));
        jSONObject2.put("totalSwappablePss", d(hc.b(memoryInfo)));
        jSONObject.put("memory_info", jSONObject2);
    }

    public static String u(Context context) {
        Class<?> clsH = h(context);
        if (b == null && clsH != null) {
            try {
                b = clsH.getDeclaredField("VERSION_NAME");
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = b;
        if (field == null) {
            return "";
        }
        try {
            return (String) field.get(null);
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static int an(Context context) {
        Class<?> clsH = h(context);
        if (c == null && clsH != null) {
            try {
                c = clsH.getDeclaredField("VERSION_CODE");
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = c;
        if (field == null) {
            return -1;
        }
        try {
            return ((Integer) field.get(null)).intValue();
        } catch (Throwable unused2) {
            return -1;
        }
    }

    private static Class<?> h(Context context) {
        if (hc == null && !u) {
            try {
                hc = Class.forName(context.getPackageName() + ".BuildConfig");
            } catch (ClassNotFoundException unused) {
            }
            u = true;
        }
        return hc;
    }
}
