package com.bytedance.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.bdtracker.l0;
import com.pandora.common.Constants;
import io.reactivex.annotations.SchedulerSupport;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class s1 {
    public static final String[] l = {"channel", "package", "app_version"};
    public volatile boolean a;
    public final Context b;
    public final q1 c;
    public volatile JSONObject d;
    public boolean e;
    public final SharedPreferences g;
    public final q4 h;
    public final d i;

    @Deprecated
    public boolean k;
    public final Set<l1> f = new HashSet(32);
    public int j = 0;

    public class a implements EventBus.DataFetcher {
        public a() {
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appId", s1.this.i.m);
                jSONObject.put(Constants.APPLog.DEVICE_ID, s1.this.d.optString(com.baidu.mobads.upgrade.remote.gray.c.l, ""));
                jSONObject.put("bdDid", s1.this.c());
                jSONObject.put("ssid", s1.this.i());
                jSONObject.put("installId", s1.this.f());
                jSONObject.put("uuid", s1.this.k());
                jSONObject.put("uuidType", s1.this.l());
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public s1(d dVar, Context context, q1 q1Var) {
        this.k = false;
        this.i = dVar;
        this.b = context;
        this.c = q1Var;
        SharedPreferences sharedPreferences = q1Var.f;
        this.g = sharedPreferences;
        this.d = new JSONObject();
        this.h = dVar.d.a(dVar, context, q1Var);
        this.k = sharedPreferences.getBoolean("forbid_report_phone_detail_info", false);
        boolean z = q1Var.f.getBoolean("is_first_app_launch", true);
        String userUniqueId = q1Var.c.getUserUniqueId();
        String userUniqueIdType = q1Var.c.getUserUniqueIdType();
        if (l0.b.d(userUniqueId) && z) {
            h(userUniqueId);
        }
        if (l0.b.d(userUniqueIdType) && z) {
            i(userUniqueIdType);
        }
        if (z) {
            q1Var.f.edit().putBoolean("is_first_app_launch", false).apply();
        }
    }

    public static void a(JSONObject jSONObject, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    public final String a(Set<String> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public final synchronized void a(String str) {
        String strOptString = this.d.optString("ab_sdk_version");
        if (!TextUtils.isEmpty(strOptString)) {
            for (String str2 : strOptString.split(",")) {
                if (!TextUtils.isEmpty(str2) && str2.equals(str)) {
                    this.i.D.debug(Collections.singletonList("DeviceManager"), "addExposedVid ready added: " + strOptString, new Object[0]);
                    return;
                }
            }
            str = strOptString + "," + str;
        }
        e(str);
        a(str, this.c.c());
    }

    public void b(String str) {
        q4 q4Var = this.h;
        if (q4Var instanceof m4) {
            m4 m4Var = (m4) q4Var;
            Context context = this.b;
            m4Var.e.D.debug(m4Var.g, "DeviceParamsProvider#clearDidAndIid clearKey=" + str + " sDeviceId=" + m4.l, new Object[0]);
            if (!TextUtils.isEmpty(str)) {
                m4.l = null;
                String str2 = "clear_key_prefix" + str;
                SharedPreferences sharedPreferencesA = f4.a(context, m4Var.f.c.getSpName(), 0);
                if (sharedPreferencesA.getBoolean(str2, false)) {
                    m4Var.e.D.debug(m4Var.g, "clearKey:{} is already cleared", str);
                } else {
                    SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
                    editorEdit.putBoolean(str2, true);
                    if (sharedPreferencesA.contains(com.baidu.mobads.upgrade.remote.gray.c.l)) {
                        editorEdit.remove(com.baidu.mobads.upgrade.remote.gray.c.l);
                    }
                    if (sharedPreferencesA.contains("install_id")) {
                        editorEdit.remove("install_id");
                    }
                    editorEdit.apply();
                    m4Var.b.a(com.baidu.mobads.upgrade.remote.gray.c.l);
                    m4Var.e.D.debug(m4Var.g, "clearKey:{} installId and deviceId finish", str);
                }
            }
        }
        this.c.f.edit().remove("device_token").apply();
    }

    public String c() {
        return this.d.optString("bd_did", "");
    }

    public final Set<String> c(String str) {
        String[] strArrSplit;
        HashSet hashSet = new HashSet();
        if (!TextUtils.isEmpty(str) && (strArrSplit = str.split(",")) != null && strArrSplit.length > 0) {
            for (String str2 : strArrSplit) {
                if (!TextUtils.isEmpty(str2)) {
                    hashSet.add(str2);
                }
            }
        }
        return hashSet;
    }

    public final JSONObject d() {
        if (this.a) {
            return this.d.optJSONObject(SchedulerSupport.CUSTOM);
        }
        q1 q1Var = this.c;
        if (q1Var == null) {
            return null;
        }
        try {
            return new JSONObject(q1Var.d.getString("header_custom_info", null));
        } catch (Exception unused) {
            return null;
        }
    }

    public void d(String str) {
        JSONObject jSONObjectD;
        if (TextUtils.isEmpty(str) || (jSONObjectD = d()) == null || !jSONObjectD.has(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        l0.b.a(jSONObject, jSONObjectD);
        jSONObject.remove(str);
        b(jSONObject);
    }

    public JSONObject e() {
        if (this.a) {
            return this.d;
        }
        return null;
    }

    public String f() {
        return this.d.optString("install_id", "");
    }

    public String g() {
        return this.d.optString("openudid", "");
    }

    public boolean g(String str) {
        if (!a("ssid", (Object) str)) {
            return false;
        }
        this.g.edit().putString(this.c.e(), str).apply();
        return true;
    }

    public int h() {
        if (p()) {
            return this.g.getInt("version_code", 0) == this.d.optInt("version_code", -1) ? 1 : 2;
        }
        return 0;
    }

    public String i() {
        if (this.a) {
            return this.d.optString("ssid", "");
        }
        q1 q1Var = this.c;
        return q1Var != null ? q1Var.f.getString(q1Var.e(), "") : "";
    }

    public String j() {
        return this.d.optString("udid", "");
    }

    public String k() {
        if (this.a) {
            return this.d.optString("user_unique_id", "");
        }
        q1 q1Var = this.c;
        return q1Var != null ? q1Var.f() : "";
    }

    public String l() {
        return this.d.optString("user_unique_id_type", this.c.d.getString("user_unique_id_type", null));
    }

    public int m() {
        int iOptInt = this.a ? this.d.optInt("version_code", -1) : t4.a(this.b);
        for (int i = 0; i < 3 && iOptInt == -1; i++) {
            iOptInt = this.a ? this.d.optInt("version_code", -1) : t4.a(this.b);
        }
        return iOptInt;
    }

    public String n() {
        String strOptString = this.a ? this.d.optString("app_version") : t4.b(this.b);
        for (int i = 0; i < 3 && TextUtils.isEmpty(strOptString); i++) {
            strOptString = this.a ? this.d.optString("app_version") : t4.b(this.b);
        }
        return strOptString;
    }

    public boolean o() {
        return this.e;
    }

    public boolean p() {
        JSONObject jSONObject = this.d;
        if (jSONObject != null) {
            String strOptString = jSONObject.optString(com.baidu.mobads.upgrade.remote.gray.c.l, "");
            String strOptString2 = jSONObject.optString("install_id", "");
            String strOptString3 = jSONObject.optString("bd_did", "");
            if ((l0.b.a(strOptString) || l0.b.a(strOptString3)) && l0.b.a(strOptString2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x016a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean q() {
        /*
            Method dump skipped, instructions count: 709
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.s1.q():boolean");
    }

    @Deprecated
    public boolean r() {
        return !this.k;
    }

    public void e(String str) {
        if (a("ab_sdk_version", (Object) str)) {
            com.bytedance.bdtracker.a.a(this.c.d, "ab_sdk_version", str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001d A[Catch: all -> 0x0085, TryCatch #0 {, blocks: (B:5:0x0004, B:6:0x000f, B:8:0x001d, B:10:0x0028, B:11:0x002c, B:13:0x0032, B:15:0x003a, B:17:0x0042, B:20:0x0051, B:21:0x0063, B:23:0x0080), top: B:29:0x0004, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void c(org.json.JSONObject r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 0
            if (r11 != 0) goto Lf
            com.bytedance.bdtracker.d r1 = r10.i     // Catch: java.lang.Throwable -> L85
            com.bytedance.applog.log.IAppLogLogger r1 = r1.D     // Catch: java.lang.Throwable -> L85
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L85
            java.lang.String r3 = "null abconfig"
            r1.warn(r3, r2)     // Catch: java.lang.Throwable -> L85
        Lf:
            org.json.JSONObject r1 = r10.d     // Catch: java.lang.Throwable -> L85
            java.lang.String r2 = "ab_sdk_version"
            java.lang.String r1 = r1.optString(r2)     // Catch: java.lang.Throwable -> L85
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L85
            if (r2 != 0) goto L83
            java.util.Set r2 = r10.c(r1)     // Catch: java.lang.Throwable -> L85
            java.util.HashSet r3 = new java.util.HashSet     // Catch: java.lang.Throwable -> L85
            r3.<init>()     // Catch: java.lang.Throwable -> L85
            if (r11 == 0) goto L63
            java.util.Iterator r4 = r11.keys()     // Catch: java.lang.Throwable -> L85
        L2c:
            boolean r5 = r4.hasNext()     // Catch: java.lang.Throwable -> L85
            if (r5 == 0) goto L63
            java.lang.Object r5 = r4.next()     // Catch: java.lang.Throwable -> L85
            boolean r6 = r5 instanceof java.lang.String     // Catch: java.lang.Throwable -> L85
            if (r6 == 0) goto L2c
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L85
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L85
            if (r6 != 0) goto L2c
            org.json.JSONObject r5 = r11.getJSONObject(r5)     // Catch: org.json.JSONException -> L50 java.lang.Throwable -> L85
            java.lang.String r6 = "vid"
            java.lang.String r5 = r5.optString(r6)     // Catch: org.json.JSONException -> L50 java.lang.Throwable -> L85
            r3.add(r5)     // Catch: org.json.JSONException -> L50 java.lang.Throwable -> L85
            goto L2c
        L50:
            r5 = move-exception
            com.bytedance.bdtracker.d r6 = r10.i     // Catch: java.lang.Throwable -> L85
            com.bytedance.applog.log.IAppLogLogger r6 = r6.D     // Catch: java.lang.Throwable -> L85
            java.lang.String r7 = "DeviceManager"
            java.util.List r7 = java.util.Collections.singletonList(r7)     // Catch: java.lang.Throwable -> L85
            java.lang.Object[] r8 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L85
            java.lang.String r9 = "JSON handle failed"
            r6.error(r7, r9, r5, r8)     // Catch: java.lang.Throwable -> L85
            goto L2c
        L63:
            com.bytedance.bdtracker.q1 r11 = r10.c     // Catch: java.lang.Throwable -> L85
            java.lang.String r11 = r11.c()     // Catch: java.lang.Throwable -> L85
            java.util.Set r0 = r10.c(r11)     // Catch: java.lang.Throwable -> L85
            r3.addAll(r0)     // Catch: java.lang.Throwable -> L85
            r2.retainAll(r3)     // Catch: java.lang.Throwable -> L85
            java.lang.String r0 = r10.a(r2)     // Catch: java.lang.Throwable -> L85
            r10.e(r0)     // Catch: java.lang.Throwable -> L85
            boolean r1 = android.text.TextUtils.equals(r1, r0)     // Catch: java.lang.Throwable -> L85
            if (r1 != 0) goto L83
            r10.a(r0, r11)     // Catch: java.lang.Throwable -> L85
        L83:
            monitor-exit(r10)
            return
        L85:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.s1.c(org.json.JSONObject):void");
    }

    public synchronized void f(String str) {
        Set<String> setC = c(this.c.c());
        Set<String> setC2 = c(this.d.optString("ab_sdk_version"));
        setC2.removeAll(setC);
        setC2.addAll(c(str));
        q1 q1Var = this.c;
        q1Var.b.D.debug(Collections.singletonList("ConfigManager"), "setExternalAbVersion:{}", str);
        com.bytedance.bdtracker.a.a(q1Var.d, "external_ab_version", str);
        q1Var.h = null;
        e(a(setC2));
    }

    public boolean h(String str) {
        if (!a("user_unique_id", (Object) str)) {
            return false;
        }
        this.c.d.edit().putString("user_unique_id", l0.b.a((Object) str)).apply();
        return true;
    }

    public String a() {
        if (this.a) {
            return this.d.optString("ab_sdk_version", "");
        }
        q1 q1Var = this.c;
        return q1Var != null ? q1Var.d.getString("ab_sdk_version", "") : "";
    }

    public void i(String str) {
        if (a("user_unique_id_type", (Object) str)) {
            com.bytedance.bdtracker.a.a(this.c.d, "user_unique_id_type", str);
        }
    }

    public <T> T a(String str, T t, Class<T> cls) {
        return (T) this.i.j.a(this.d, str, (String) t, (Class<String>) cls);
    }

    public final void a(String str, String str2) {
        if (this.c.g() && this.c.c.isAbEnable()) {
            Set<String> setC = c(str);
            setC.removeAll(c(str2));
            e1 e1Var = this.i.y;
            if (e1Var != null) {
                e1Var.onAbVidsChange(a(setC), str2);
            }
        }
    }

    public String b() {
        return this.c.c.getAid();
    }

    public final void b(JSONObject jSONObject) {
        if (a(SchedulerSupport.CUSTOM, jSONObject)) {
            this.c.d.edit().putString("header_custom_info", jSONObject != null ? jSONObject.toString() : "").apply();
        }
    }

    public synchronized boolean a(JSONObject jSONObject, String str, String str2, String str3, String str4, String str5, String str6) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean zA;
        SharedPreferences.Editor editorEdit;
        String strB;
        String string;
        boolean z4;
        this.i.D.debug(Collections.singletonList("DeviceManager"), "saveRegisterInfo -> uuid:" + str + ", did:" + str2 + ", iid:" + str3 + ", ssid:" + str4 + ", did:" + str5 + ", cd:" + str6 + ", response:{}", jSONObject);
        if (!l0.b.a(k(), str)) {
            this.i.D.debug(1, "saveRegisterInfo interrupted for uuid is changed", new Object[0]);
            return true;
        }
        this.e = jSONObject.optInt("new_user", 0) > 0;
        String strOptString = jSONObject.optString("device_token", "");
        boolean zA2 = l0.b.a(str2);
        boolean zA3 = l0.b.a(str3);
        boolean zA4 = l0.b.a(str5);
        boolean zA5 = l0.b.a(str6);
        try {
            zA = l0.b.a(str4);
            int i = this.g.getInt("version_code", 0);
            int iOptInt = this.d.optInt("version_code", 0);
            editorEdit = this.g.edit();
            if (i != iOptInt) {
                editorEdit.putInt("version_code", iOptInt);
            }
            String string2 = this.g.getString("channel", "");
            String strOptString2 = this.d.optString("channel", "");
            if (!TextUtils.equals(string2, strOptString2)) {
                editorEdit.putString("channel", strOptString2);
            }
            editorEdit.putString("device_token", strOptString);
            if ((zA2 || (zA4 && zA5)) && zA3) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                editorEdit.putLong("register_time", jCurrentTimeMillis);
                a("register_time", Long.valueOf(jCurrentTimeMillis));
            } else if (!zA2 && (!zA4 || !zA5)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("response", jSONObject);
                this.i.onEventV3("tt_fetch_did_error", jSONObject2, 0);
            }
            strB = ((m4) this.h).b();
            string = this.g.getString("bd_did", null);
            z = zA5;
        } catch (Throwable th) {
            th = th;
            z = zA5;
        }
        try {
            this.i.D.debug(Collections.singletonList("DeviceManager"), "device: od=" + strB + " nd=" + str2 + " ck=" + zA2, new Object[0]);
            if (zA2) {
                if (str2.equals(this.d.optString(com.baidu.mobads.upgrade.remote.gray.c.l))) {
                    z4 = false;
                } else {
                    JSONObject jSONObject3 = this.d;
                    JSONObject jSONObject4 = new JSONObject();
                    l0.b.a(jSONObject4, jSONObject3);
                    jSONObject4.put(com.baidu.mobads.upgrade.remote.gray.c.l, str2);
                    this.d = jSONObject4;
                    LogUtils.sendJsonFetcher("set_header", new t1(this, jSONObject4));
                    ((m4) this.h).b(str2);
                    z4 = true;
                }
                if (!str2.equals(strB)) {
                    z4 = true;
                }
            } else {
                z4 = false;
            }
            if (zA4 && a("bd_did", (Object) str5)) {
                editorEdit.putString("bd_did", str5);
                z4 = true;
            }
            String strOptString3 = this.d.optString("install_id", "");
            if (zA3 && a("install_id", (Object) str3)) {
                editorEdit.putString("install_id", str3);
                z4 = true;
            }
            String strOptString4 = this.d.optString("ssid", "");
            boolean z5 = (zA && g(str4)) ? true : z4;
            if (this.i.y != null) {
                this.i.y.onRemoteIdGet(z5, string, str5, strOptString3, str3, strOptString4, str4);
            }
            editorEdit.apply();
            z2 = false;
        } catch (Throwable th2) {
            th = th2;
            z2 = false;
            this.i.D.error(Collections.singletonList("DeviceManager"), "JSON handle failed", th, new Object[0]);
            z3 = zA2 ? true : true;
            return z3;
        }
        if ((zA2 && (!zA4 || !z)) || !zA3) {
            z3 = z2;
        }
        return z3;
    }

    public void a(JSONObject jSONObject) {
        q1 q1Var = this.c;
        q1Var.b.D.debug(Collections.singletonList("ConfigManager"), "setAbConfig:{}", jSONObject);
        com.bytedance.bdtracker.a.a(q1Var.d, "ab_configure", jSONObject == null ? "" : jSONObject.toString());
        q1Var.g = null;
        LogUtils.sendJsonFetcher("set_abconfig", new r1(q1Var, jSONObject));
        c(jSONObject);
    }

    public void a(HashMap<String, Object> map) {
        JSONObject jSONObject;
        if (map == null || map.isEmpty()) {
            jSONObject = null;
        } else {
            jSONObject = new JSONObject();
            JSONObject jSONObjectD = d();
            if (jSONObjectD != null) {
                l0.b.a(jSONObject, jSONObjectD);
            }
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (Throwable th) {
                this.i.D.error(Collections.singletonList("DeviceManager"), "Set custom header failed", th, new Object[0]);
            }
        }
        b(jSONObject);
    }

    public final boolean a(String str, Object obj) {
        Object objOpt = this.d.opt(str);
        if (l0.b.b(obj, objOpt)) {
            return false;
        }
        synchronized (this) {
            try {
                JSONObject jSONObject = this.d;
                JSONObject jSONObject2 = new JSONObject();
                l0.b.a(jSONObject2, jSONObject);
                jSONObject2.put(str, obj);
                this.d = jSONObject2;
                LogUtils.sendJsonFetcher("set_header", new t1(this, jSONObject2));
            } catch (JSONException e) {
                this.i.D.error(Collections.singletonList("DeviceManager"), "Update header:{} to value:{} failed", e, str, obj);
            }
        }
        this.i.D.debug(Collections.singletonList("DeviceManager"), "Update header:{} from old:{} to new value:{}", str, objOpt, obj);
        return true;
    }
}
