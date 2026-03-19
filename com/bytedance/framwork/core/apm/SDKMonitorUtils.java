package com.bytedance.framwork.core.apm;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.apmplus.sdk.event.SDKEventIDynamicParams;
import com.bytedance.framwork.core.apm.SDKMonitor;
import com.bytedance.framwork.core.fg.g;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class SDKMonitorUtils {
    private static ConcurrentHashMap<String, SDKMonitor> a = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, List<String>> b = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, List<String>> c = new ConcurrentHashMap<>();

    public static synchronized void setConfigUrl(String str, List<String> list) {
        if (!TextUtils.isEmpty(str) && !g.a(list)) {
            c.put(str, list);
        }
    }

    public static synchronized void setDefaultReportUrl(String str, List<String> list) {
        if (!TextUtils.isEmpty(str) && !g.a(list)) {
            b.put(str, list);
        }
    }

    public static List<String> convertReportUrl(List<String> list) {
        LinkedList linkedList = new LinkedList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            try {
                linkedList.add(("https://" + new URL(it.next()).getHost()) + "/monitor/collect/");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return linkedList;
    }

    public static synchronized void initMonitor(Context context, String str, JSONObject jSONObject, SDKMonitor.IGetExtendParams iGetExtendParams) {
        initMonitor(context, str, jSONObject, false, true, iGetExtendParams);
    }

    public static synchronized void initMonitor(Context context, String str, JSONObject jSONObject, boolean z, SDKMonitor.IGetExtendParams iGetExtendParams) {
        initMonitor(context, str, jSONObject, z, true, iGetExtendParams);
    }

    public static synchronized void initMonitor(Context context, String str, JSONObject jSONObject, boolean z, boolean z2, SDKMonitor.IGetExtendParams iGetExtendParams) {
        initMonitor(context, str, "", jSONObject, z, z2, iGetExtendParams);
    }

    public static synchronized void initMonitor(Context context, String str, String str2, JSONObject jSONObject, boolean z, SDKMonitor.IGetExtendParams iGetExtendParams) {
        initMonitor(context, str, str2, jSONObject, z, true, iGetExtendParams);
    }

    public static synchronized void initMonitor(Context context, String str, String str2, JSONObject jSONObject, boolean z, boolean z2, SDKMonitor.IGetExtendParams iGetExtendParams) {
        initMonitor(context, str, str2, jSONObject, z, false, iGetExtendParams, null);
    }

    public static synchronized void initMonitor(Context context, String str, String str2, JSONObject jSONObject, boolean z, boolean z2, SDKMonitor.IGetExtendParams iGetExtendParams, SDKEventIDynamicParams sDKEventIDynamicParams) {
        if (context == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("param 'aid' is not allowed to assigned empty string");
        }
        if (jSONObject == null) {
            throw new IllegalArgumentException("param 'headerInfo' is not allowed to be null");
        }
        if (a.get(str) == null || !a.get(str).a()) {
            if (TextUtils.isEmpty(str2)) {
                Log.e(SDKMonitor.TAG, "Token can not be null!");
            }
            SDKMonitor sDKMonitor = a.get(str);
            if (sDKMonitor == null) {
                sDKMonitor = new SDKMonitor(str, str2);
                a.put(str, sDKMonitor);
            } else {
                sDKMonitor.setToken(str2);
            }
            sDKMonitor.setDebug(z);
            sDKMonitor.setDynamicParams(sDKEventIDynamicParams);
            sDKMonitor.a(c.remove(str));
            sDKMonitor.b(b.remove(str));
            sDKMonitor.init(context, jSONObject, iGetExtendParams);
        }
    }

    public static SDKMonitor getInstance(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("param 'aid' is not allowed to assigned empty string");
        }
        if (a.get(str) == null) {
            synchronized (SDKMonitorUtils.class) {
                if (a.get(str) == null) {
                    a.put(str, new SDKMonitor(str));
                }
            }
        }
        return a.get(str);
    }
}
