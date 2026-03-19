package com.bytedance.msdk.gb;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class rf {
    private static final HashSet d = new HashSet(Arrays.asList("dalvik.system.VMStack.getThreadStackTrace", "java.lang.Thread.getStackTrace"));

    public static String d() {
        StackTraceElement[] stackTrace;
        try {
            stackTrace = Thread.currentThread().getStackTrace();
        } catch (Throwable unused) {
            stackTrace = null;
        }
        if (stackTrace == null || stackTrace.length == 0) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (stackTraceElement != null && !d.contains(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName())) {
                    String className = stackTraceElement.getClassName();
                    if (className != null && className.startsWith("android.app")) {
                        break;
                    }
                    jSONArray.put(stackTraceElement.toString());
                }
            }
            return jSONArray.toString();
        } catch (OutOfMemoryError e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return "";
        }
    }

    public static String d(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : map.keySet()) {
            if (d(map.get(str))) {
                jSONArray.put(str);
            }
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        try {
            return jSONArray.toString();
        } catch (OutOfMemoryError e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return "";
        }
    }

    private static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Class.forName(str) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String hc() {
        StackTraceElement[] stackTrace;
        Map<String, List<String>> mapFs;
        try {
            stackTrace = Thread.currentThread().getStackTrace();
        } catch (Throwable unused) {
            stackTrace = null;
        }
        if (stackTrace != null && stackTrace.length != 0 && (mapFs = com.bytedance.msdk.core.hc.hc().fs()) != null && !mapFs.isEmpty()) {
            for (String str : mapFs.keySet()) {
                if (d(mapFs.get(str), stackTrace)) {
                    return str;
                }
            }
        }
        return null;
    }

    private static boolean d(List<String> list, StackTraceElement[] stackTraceElementArr) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                    if (list.get(i) != null) {
                        try {
                            if (stackTraceElement.toString().contains(list.get(i))) {
                                return true;
                            }
                        } catch (OutOfMemoryError e) {
                            com.bytedance.sdk.component.utils.mq.d(e);
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean d(com.bytedance.msdk.hc.b bVar) {
        if (bVar == null || !bVar.wz()) {
            return false;
        }
        return c();
    }

    public static boolean d(com.bytedance.msdk.core.tc.tc tcVar) {
        if (tcVar == null || !tcVar.hv()) {
            return false;
        }
        return c();
    }

    private static boolean c() {
        Map<String, List<String>> mapFs = com.bytedance.msdk.core.hc.hc().fs();
        if (mapFs == null || mapFs.size() == 0) {
            return false;
        }
        return d(com.bytedance.msdk.core.hc.hc().ba());
    }

    public static boolean d(double d2) {
        return d2 > 0.0d && Math.random() <= d2;
    }

    public static double b() {
        return com.bytedance.msdk.core.hc.hc().ba();
    }
}
