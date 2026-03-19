package com.baidu.mobstat.forbes;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ExceptionAnalysis {
    private static ExceptionAnalysis a = new ExceptionAnalysis();
    private Context c;
    private String e;
    private List<String> f;
    public Callback mCallback;
    private boolean b = false;
    private HeadObject d = new HeadObject();
    private boolean g = true;

    public interface Callback {
        void onCallback(JSONObject jSONObject);
    }

    public static ExceptionAnalysis getInstance() {
        return a;
    }

    private ExceptionAnalysis() {
    }

    public ExceptionAnalysis(Callback callback) {
        this.mCallback = callback;
    }

    public void openExceptionAnalysis(Context context, boolean z) {
        if (context != null) {
            this.c = context.getApplicationContext();
        }
        if (this.c == null || this.b) {
            return;
        }
        this.b = true;
        a.a().a(this.c);
        if (!z) {
            NativeCrashHandler.init(this.c);
        }
    }

    public void saveCrashInfo(Context context, Throwable th, boolean z) {
        String str;
        int i;
        if (context != null) {
            this.c = context.getApplicationContext();
        }
        if (this.c == null) {
            return;
        }
        String string = th.toString();
        String str2 = "";
        if (!TextUtils.isEmpty(string)) {
            try {
                String[] strArrSplit = string.split(":");
                if (strArrSplit.length > 1) {
                    str2 = strArrSplit[0];
                } else {
                    str2 = string;
                }
            } catch (Exception e) {
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        } else {
            str = string;
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String string2 = stringWriter.toString();
        if (z) {
            i = 0;
        } else if (th instanceof Exception) {
            i = 11;
        } else {
            i = th instanceof Error ? 12 : 13;
        }
        saveCrashInfo(this.c, System.currentTimeMillis(), string2, str, 0, i);
    }

    public void saveCrashInfo(Context context, long j, String str, String str2, int i, int i2) {
        BDStatCore.instance().autoTrackSessionEndTime(context);
        if (context == null || str == null || str.trim().equals("")) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder(str);
            if (!TextUtils.isEmpty(this.e)) {
                sb.append("\n");
                sb.append("ExtraInfo:");
                sb.append(this.e);
            }
            String appVersionName = CooperService.instance().getAppVersionName(context);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("t", j);
            jSONObject.put("c", sb.toString());
            jSONObject.put("y", str2);
            jSONObject.put("v", appVersionName);
            jSONObject.put(Config.EXCEPTION_CRASH_TYPE, i);
            jSONObject.put("mem", a(context));
            jSONObject.put("ty", i2);
            jSONObject.put("sv", "4.1.0.9");
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            this.d.installHeader(context, jSONObject2);
            jSONObject2.put("ss", 0);
            jSONObject2.put(Config.SEQUENCE_INDEX, 0);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(Config.HEADER_PART, jSONObject2);
            jSONObject3.put(Config.PRINCIPAL_PART, new JSONArray());
            jSONObject3.put(Config.EVENT_PART, new JSONArray());
            jSONObject3.put(Config.EXCEPTION_PART, jSONArray);
            jSONObject3.put(Config.TRACE_PART, a());
            if (this.mCallback != null) {
                this.mCallback.onCallback(jSONObject3);
            }
            aj.a(context, Config.PREFIX_SEND_DATA + System.currentTimeMillis(), jSONObject3.toString(), false);
            v.c().a("dump exception, exception: " + str);
        } catch (Exception e) {
        }
    }

    private JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.TRACE_APPLICATION_SESSION, 0);
        } catch (Exception e) {
        }
        try {
            jSONObject.put(Config.TRACE_FAILED_CNT, 0);
        } catch (Exception e2) {
        }
        return jSONObject;
    }

    private JSONObject a(Context context) throws JSONException {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        JSONObject jSONObject = new JSONObject();
        try {
            if (Build.VERSION.SDK_INT >= 16) {
                jSONObject.put(Config.EXCEPTION_MEMORY_TOTAL, memoryInfo.totalMem);
            }
            jSONObject.put(Config.EXCEPTION_MEMORY_FREE, memoryInfo.availMem);
            jSONObject.put(Config.EXCEPTION_MEMORY_LOW, memoryInfo.lowMemory ? 1 : 0);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    public void setCrashExtraInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.length() > 256) {
            str = str.substring(0, 256);
        }
        this.e = str;
    }

    public void setFilterPackageList(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f = list;
    }

    public void setEnableSend(boolean z) {
        this.g = z;
    }
}
