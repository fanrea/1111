package com.apm.insight;

import android.content.Context;
import android.text.TextUtils;
import com.apm.applog.AppLog;
import com.apm.insight.n.o;
import com.apm.insight.o.m;
import com.apm.insight.o.v;
import com.apm.insight.runtime.j;
import com.bytedance.apm.common.utility.PackageUtils;
import io.reactivex.annotations.SchedulerSupport;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class f {
    protected static volatile MonitorCrash b;
    protected static volatile ConcurrentHashMap<String, MonitorCrash> c = new ConcurrentHashMap<>();
    protected MonitorCrash a;

    private f(MonitorCrash monitorCrash) {
        this.a = monitorCrash;
        com.apm.insight.entity.b.a(this);
        com.apm.insight.m.b.d();
        o.e();
    }

    public static MonitorCrash a(String str) {
        return c.get(str);
    }

    public static Object a() {
        return b;
    }

    private JSONObject a(boolean z) throws JSONException {
        AppLog appLog;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.a.mConfig.f == null) {
                Context contextF = g.f();
                if (this.a.mConfig.d == -1) {
                    this.a.mConfig.d = PackageUtils.getVersionCode(contextF);
                }
                if (this.a.mConfig.e == null) {
                    this.a.mConfig.e = PackageUtils.getVersionName(contextF);
                }
            }
        } catch (Throwable unused) {
        }
        if ((TextUtils.isEmpty(this.a.mConfig.getDeviceId()) || "0".equals(this.a.mConfig.getDeviceId())) && (appLog = AppLog.getInstance(this.a.mConfig.a)) != null) {
            this.a.mConfig.setDeviceId(appLog.getDid(), false);
        }
        try {
            jSONObject.put("aid", String.valueOf(this.a.mConfig.a));
            if (z && !TextUtils.isEmpty(this.a.mConfig.b)) {
                jSONObject.put("x-auth-token", this.a.mConfig.b);
            }
            jSONObject.put("update_version_code", this.a.mConfig.d);
            jSONObject.put("version_code", this.a.mConfig.d);
            jSONObject.put("app_version", this.a.mConfig.e);
            jSONObject.put("channel", this.a.mConfig.c);
            jSONObject.put("package", m.a(this.a.mConfig.f));
            jSONObject.put(com.baidu.mobads.upgrade.remote.gray.c.l, this.a.mConfig.getDeviceId());
            jSONObject.put("user_id", this.a.mConfig.getUID());
            jSONObject.put("ssid", this.a.mConfig.getSSID());
            jSONObject.put("os", "Android");
            jSONObject.put("so_list", m.a(this.a.mConfig.g));
            jSONObject.put("single_upload", e() ? 1 : 0);
        } catch (JSONException unused2) {
        }
        return jSONObject;
    }

    static void a(Context context, final MonitorCrash monitorCrash) {
        b = monitorCrash;
        g.a(context, new ICommonParams() { // from class: com.apm.insight.f.1
            @Override // com.apm.insight.ICommonParams
            public Map<String, Object> getCommonParams() {
                return m.b(f.this.i());
            }

            @Override // com.apm.insight.ICommonParams
            public String getDeviceId() {
                String deviceId = monitorCrash.mConfig.getDeviceId();
                return TextUtils.isEmpty(deviceId) ? j.a(g.g()).d() : deviceId;
            }

            @Override // com.apm.insight.ICommonParams
            public List<String> getPatchInfo() {
                return null;
            }

            @Override // com.apm.insight.ICommonParams
            public Map<String, Integer> getPluginInfo() {
                return null;
            }

            @Override // com.apm.insight.ICommonParams
            public String getSessionId() {
                return null;
            }

            @Override // com.apm.insight.ICommonParams
            public long getUserId() {
                return 0L;
            }
        });
    }

    static void a(MonitorCrash monitorCrash) {
        new f(monitorCrash);
        if (monitorCrash == null || monitorCrash.mConfig == null) {
            return;
        }
        c.put(monitorCrash.mConfig.a, monitorCrash);
    }

    public static Map<String, MonitorCrash> b() {
        return c;
    }

    private JSONObject b(CrashType crashType) {
        Map<? extends String, ? extends String> userData;
        if (this.a.mCustomData == null || (userData = this.a.mCustomData.getUserData(crashType)) == null) {
            return null;
        }
        return new JSONObject(userData);
    }

    public static String c(String str) {
        MonitorCrash monitorCrash;
        if (b != null && TextUtils.equals(str, b.mConfig.a)) {
            monitorCrash = b;
        } else if (c == null || (monitorCrash = c.get(str)) == null) {
            return null;
        }
        return monitorCrash.mConfig.b;
    }

    private JSONObject c(CrashType crashType) {
        return new JSONObject(this.a.mTagMap);
    }

    public static String d(String str) {
        MonitorCrash monitorCrash;
        if (b != null && TextUtils.equals(str, b.mConfig.a)) {
            monitorCrash = b;
        } else if (c == null || (monitorCrash = c.get(str)) == null) {
            return null;
        }
        return monitorCrash.mConfig.getDeviceId();
    }

    public static String f() {
        if (b == null) {
            return null;
        }
        return b.mConfig.a;
    }

    public static long g() {
        long j = b == null ? 0L : b.mConfig.d;
        if (j > 0) {
            return j;
        }
        try {
            return PackageUtils.getVersionCode(g.f());
        } catch (Throwable unused) {
            return j;
        }
    }

    public static MonitorCrash h() {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject i() {
        return a(false);
    }

    public JSONArray a(StackTraceElement[] stackTraceElementArr, Throwable th) {
        if (this.a.mConfig.f == null) {
            return new JSONArray().put(new v.a(0, stackTraceElementArr.length).a());
        }
        if (th == null || stackTraceElementArr == null) {
            return null;
        }
        return v.a(stackTraceElementArr, this.a.mConfig.f);
    }

    public JSONArray a(String[] strArr) {
        if (this.a.config().f == null) {
            return new JSONArray().put(new v.a(0, strArr.length).a());
        }
        JSONArray jSONArrayA = v.a(strArr, this.a.mConfig.f);
        try {
            if (m.a(jSONArrayA) && this.a.mConfig.i) {
                String strH = com.apm.insight.runtime.a.b.d().h();
                if (!TextUtils.isEmpty(strH)) {
                    for (String str : this.a.mConfig.f) {
                        if (strH.contains(str)) {
                            return new JSONArray().put(new v.a(0, strArr.length).a());
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return jSONArrayA;
    }

    public JSONObject a(CrashType crashType) {
        return a(crashType, (JSONArray) null);
    }

    public JSONObject a(CrashType crashType, JSONArray jSONArray) {
        return a(crashType, jSONArray, false);
    }

    public JSONObject a(CrashType crashType, JSONArray jSONArray, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("header", a(z));
            if (crashType != null) {
                jSONObject.put(SchedulerSupport.CUSTOM, b(crashType));
                jSONObject.put("filters", c(crashType));
            }
            jSONObject.put("line_num", jSONArray);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public boolean a(Object obj) {
        return this.a == obj;
    }

    public JSONArray b(String str) {
        if (this.a == b) {
            return new JSONArray();
        }
        if (this.a.mConfig.g == null || this.a.mConfig.g.length <= 0) {
            return null;
        }
        for (String str2 : this.a.mConfig.g) {
            if (str.contains(str2)) {
                return new JSONArray();
            }
        }
        return null;
    }

    public String c() {
        return this.a.mConfig.a;
    }

    public JSONObject d() {
        return a(true);
    }

    public boolean e() {
        return false;
    }
}
