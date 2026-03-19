package com.bytedance.framwork.core.de.de;

import android.text.TextUtils;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: MonitorConfigure.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    private static b a = new a();
    private static ConcurrentHashMap<String, b> b;

    static {
        ConcurrentHashMap<String, b> concurrentHashMap = new ConcurrentHashMap<>();
        b = concurrentHashMap;
        concurrentHashMap.put(ILogConst.PLAY_SOURCE_DEFAULT, a);
    }

    public static void a(String str, b bVar) {
        if (bVar == null) {
            return;
        }
        b.put(str, bVar);
    }

    public static int a(String str) {
        if (!TextUtils.isEmpty(str) && b.get(str) != null) {
            return b.get(str).reportInterval();
        }
        return a.reportInterval();
    }

    public static int b(String str) {
        if (!TextUtils.isEmpty(str) && b.get(str) != null) {
            return b.get(str).reportCount();
        }
        return a.reportCount();
    }

    public static List<String> a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && b.get(str) != null) {
            return b.get(str).reportUrl(str2);
        }
        return a.reportUrl(str2);
    }

    public static JSONObject c(String str) {
        if (!TextUtils.isEmpty(str) && b.get(str) != null) {
            return b.get(str).reportJsonHeaderInfo();
        }
        return a.reportJsonHeaderInfo();
    }

    public static int d(String str) {
        if (!TextUtils.isEmpty(str) && b.get(str) != null) {
            return b.get(str).reportFailRepeatCount();
        }
        return a.reportFailRepeatCount();
    }

    public static int e(String str) {
        int iReportFailRepeatBaseTime;
        if (!TextUtils.isEmpty(str) && b.get(str) != null) {
            iReportFailRepeatBaseTime = b.get(str).reportFailRepeatBaseTime();
        } else {
            iReportFailRepeatBaseTime = a.reportFailRepeatBaseTime();
        }
        return iReportFailRepeatBaseTime * 1000;
    }

    public static boolean f(String str) {
        if (!TextUtils.isEmpty(str) && b.get(str) != null) {
            return b.get(str).getRemoveSwitch();
        }
        return a.getRemoveSwitch();
    }
}
