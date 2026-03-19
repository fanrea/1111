package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class fs {
    private volatile JSONObject an;
    private final SharedPreferences b;
    private final SharedPreferences c;
    private final Context d;
    private volatile JSONObject h;
    private final gb hc;
    private final SharedPreferences u;

    public boolean d(ArrayList<to> arrayList) {
        return true;
    }

    String yi() {
        return null;
    }

    public fs(Context context, gb gbVar) {
        this.d = context;
        this.hc = gbVar;
        this.u = com.bytedance.sdk.openadsdk.api.plugin.hc.hc(context, "embed_applog_stats", 0);
        this.b = com.bytedance.sdk.openadsdk.api.plugin.hc.hc(context, "embed_header_custom", 0);
        this.c = com.bytedance.sdk.openadsdk.api.plugin.hc.hc(context, "embed_last_sp_session", 0);
    }

    String d() {
        return this.hc.gb();
    }

    public String hc() {
        return this.c.getString("session_last_day", "");
    }

    public void d(String str, int i) {
        this.c.edit().putString("session_last_day", str).putInt("session_order", i).apply();
    }

    public int b() {
        return this.c.getInt("session_order", 0);
    }

    public SharedPreferences c() {
        return this.u;
    }

    public boolean u() {
        return this.hc.hc();
    }

    public JSONObject an() {
        return this.h;
    }

    public void d(JSONObject jSONObject) {
        if (um.hc) {
            um.d("setConfig, " + jSONObject.toString(), null);
        }
        this.h = jSONObject;
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editorEdit = this.u.edit();
        long jOptInt = jSONObject.optInt("session_interval", 0);
        if (jOptInt > 0 && jOptInt <= 604800) {
            editorEdit.putLong("session_interval", jOptInt * 1000);
        } else {
            editorEdit.remove("session_interval");
        }
        long jOptInt2 = jSONObject.optInt("batch_event_interval", 0);
        if (jOptInt2 > 0 && jOptInt2 <= 604800) {
            editorEdit.putLong("batch_event_interval", jOptInt2 * 1000);
        } else {
            editorEdit.remove("batch_event_interval");
        }
        int iOptInt = jSONObject.optInt("send_launch_timely", 0);
        if (iOptInt > 0 && iOptInt <= 604800) {
            editorEdit.putInt("send_launch_timely", iOptInt);
        } else {
            editorEdit.remove("send_launch_timely");
        }
        long jOptInt3 = jSONObject.optInt("abtest_fetch_interval", 0);
        if (jOptInt3 > 20 && jOptInt3 <= 604800) {
            editorEdit.putLong("abtest_fetch_interval", jOptInt3 * 1000);
        } else {
            editorEdit.remove("abtest_fetch_interval");
        }
        boolean zOptBoolean = jSONObject.optBoolean("bav_log_collect", true);
        if (zOptBoolean) {
            editorEdit.putBoolean("bav_log_collect", true);
        } else {
            editorEdit.remove("bav_log_collect");
        }
        um.d = zOptBoolean;
        if (jSONObject.optBoolean("bav_ab_config", false)) {
            editorEdit.putBoolean("bav_ab_config", true);
        } else {
            editorEdit.remove("bav_ab_config");
        }
        int iOptInt2 = jSONObject.optInt("bav_monitor_rate", 0);
        if (iOptInt2 > 0 && iOptInt2 <= 100) {
            editorEdit.putInt("bav_monitor_rate", iOptInt2);
            gw.d(true);
        } else {
            editorEdit.remove("bav_monitor_rate");
            gw.d(false);
        }
        editorEdit.putLong("app_log_last_config_time", jCurrentTimeMillis);
        editorEdit.apply();
    }

    public long h() {
        return this.u.getLong("app_log_last_config_time", 0L);
    }

    public int gb() {
        return this.u.getInt("bav_monitor_rate", 0);
    }

    public String tt() {
        return this.hc.b();
    }

    String tc() {
        return this.hc.c();
    }

    String mk() {
        return this.hc.u();
    }

    String mq() {
        return this.hc.an();
    }

    String uo() {
        return this.hc.h();
    }

    void hc(JSONObject jSONObject) {
        this.b.edit().putString("header_custom_info", jSONObject != null ? jSONObject.toString() : "").apply();
    }

    String k() {
        return this.b.getString("header_custom_info", null);
    }

    String e() {
        return this.b.getString("ab_sdk_version", "");
    }

    String cb() {
        return this.b.getString("user_unique_id", null);
    }

    public boolean w() {
        if (this.hc.tt() == 0) {
            String strD = fv.d(this.d);
            if (!TextUtils.isEmpty(strD)) {
                this.hc.d(strD.contains(":") ? 2 : 1);
            } else {
                this.hc.d(0);
            }
        }
        return this.hc.tt() == 1;
    }

    public long yo() {
        return this.u.getLong("abtest_fetch_interval", 0L);
    }

    void b(JSONObject jSONObject) {
        um.d("setAbConfig, " + jSONObject.toString(), null);
        this.b.edit().putString("ab_configure", jSONObject.toString()).apply();
        this.an = null;
    }

    public String rf() {
        if (!TextUtils.isEmpty(this.hc.rf())) {
            return this.hc.rf();
        }
        return this.b.getString("ab_version", null);
    }

    public JSONObject jh() {
        JSONObject jSONObject = this.an;
        if (jSONObject == null) {
            synchronized (this) {
                try {
                    if (sy()) {
                        jSONObject = new JSONObject(this.b.getString("ab_configure", ""));
                    }
                } catch (JSONException unused) {
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                this.an = jSONObject;
            }
        }
        return jSONObject;
    }

    public boolean sy() {
        return this.u.getBoolean("bav_ab_config", false);
    }

    public boolean de() {
        return this.u.getBoolean("bav_log_collect", false);
    }

    public long v() {
        return this.u.getLong("session_interval", 30000L);
    }

    public long np() {
        return this.u.getLong("batch_event_interval", 30000L);
    }

    String he() {
        return this.hc.d();
    }

    String vv() {
        return this.u.getString(com.alipay.sdk.m.l.b.b, null);
    }

    public String zw() {
        return this.hc.mq();
    }

    public int j() {
        return this.hc.e();
    }

    public int s() {
        return this.hc.cb();
    }

    public int us() {
        return this.hc.w();
    }

    public String z() {
        return this.hc.uo();
    }

    public String fs() {
        return this.hc.k();
    }

    public String ba() {
        return this.hc.yo();
    }

    public String mt() {
        return this.hc.jh();
    }

    public String r() {
        return this.hc.sy();
    }

    public String hv() {
        return this.hc.de();
    }

    public String bc() {
        return this.hc.zw() == null ? "" : this.hc.zw();
    }

    public String dc() {
        return this.hc.j() == null ? "" : this.hc.j();
    }

    public boolean tr() {
        return this.hc.np();
    }

    public boolean nv() {
        return this.hc.yi();
    }

    public String y() {
        return this.hc.vv();
    }

    public gb wl() {
        return this.hc;
    }

    public CharSequence q() {
        return this.hc.v();
    }
}
