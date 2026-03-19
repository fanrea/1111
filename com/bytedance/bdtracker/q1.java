package com.bytedance.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.bdtracker.l0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class q1 {
    public final Context a;
    public final d b;
    public final InitConfig c;
    public final SharedPreferences d;
    public final SharedPreferences e;
    public final SharedPreferences f;
    public volatile JSONObject g;
    public volatile String h;
    public volatile JSONObject i;
    public final Set<String> j;
    public final Set<String> k;
    public volatile HashSet<String> l;
    public int m;
    public int n;
    public long o;
    public int p;
    public long q;
    public boolean r;
    public int s;

    public class a implements EventBus.DataFetcher {
        public a() {
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("appId", q1.this.b.m);
                long j = q1.this.f.getLong("session_interval", 0L);
                jSONObject2.put("后台会话时长", j > 0 ? j + "ms" : "--");
                long j2 = q1.this.f.getLong("batch_event_interval", 0L);
                jSONObject2.put("事件上报周期", j2 > 0 ? j2 + "ms" : "--");
                long j3 = q1.this.f.getLong("abtest_fetch_interval", 0L);
                jSONObject2.put("AB实验更新周期", j3 > 0 ? j3 + "ms" : "--");
                jSONObject2.put("全埋点开关", q1.this.f.getBoolean("bav_log_collect", false));
                jSONObject2.put("AB实验开关", q1.this.f.getBoolean("bav_ab_config", false));
                jSONObject2.put("实时埋点事件", q1.this.f.getString("real_time_events", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI));
                jSONObject2.put("禁止采集手机详情", q1.this.f.getBoolean("forbid_report_phone_detail_info", false));
                long j4 = q1.this.f.getLong("fetch_interval", 0L);
                jSONObject2.put("服务端配置更新周期", j4 > 0 ? j4 + "ms" : "--");
                jSONObject2.put("禁止内部监控开关", q1.this.f.getBoolean("applog_disable_monitor", false));
                int i = q1.this.f.getInt("batch_event_size", -1);
                jSONObject2.put("事件累计上报数量", (i >= 0 ? Integer.valueOf(i) : "--") + "条");
                jSONObject2.put("禁止采集的敏感字段", q1.this.f.getString("sensitive_fields", "--"));
                jSONObject2.put("服务端黑名单事件", q1.this.k);
                jSONObject.put("config", jSONObject2);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public q1(d dVar, Context context, InitConfig initConfig) {
        HashSet hashSet = new HashSet();
        this.j = hashSet;
        HashSet hashSet2 = new HashSet();
        this.k = hashSet2;
        this.m = 0;
        this.n = 27;
        this.o = 0L;
        this.p = 0;
        this.q = 0L;
        this.r = false;
        this.s = 1;
        this.b = dVar;
        this.a = context;
        this.c = initConfig;
        SharedPreferences sharedPreferencesA = f4.a(context, initConfig.getSpName(), 0);
        this.f = sharedPreferencesA;
        this.d = f4.a(context, b.a(dVar, "header_custom"), 0);
        this.e = f4.a(context, b.a(dVar, "last_sp_session"), 0);
        Set<String> stringSet = sharedPreferencesA.getStringSet("block_events_v1", null);
        if (stringSet != null) {
            hashSet.addAll(stringSet);
        }
        Set<String> stringSet2 = sharedPreferencesA.getStringSet("block_events_v3", null);
        if (stringSet2 != null) {
            hashSet2.addAll(stringSet2);
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = this.g;
        if (jSONObject == null) {
            synchronized (this) {
                try {
                    jSONObject = new JSONObject(this.d.getString("ab_configure", ""));
                } catch (Throwable unused) {
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                this.g = jSONObject;
            }
        }
        return jSONObject;
    }

    public void a(HashSet<String> hashSet, HashSet<String> hashSet2) {
        this.j.clear();
        this.k.clear();
        if (hashSet != null) {
            this.j.addAll(hashSet);
        }
        this.f.edit().putStringSet("block_events_v1", this.j).apply();
        if (hashSet2 != null) {
            this.k.addAll(hashSet2);
        }
        this.f.edit().putStringSet("block_events_v3", this.k).apply();
    }

    public boolean a(int i) {
        long j = i;
        return j >= 50 && j <= 9999;
    }

    public final boolean a(long j) {
        return j >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT && j <= 300000;
    }

    public final boolean a(String str) {
        String string = this.f.getString("sensitive_fields", "");
        return !TextUtils.isEmpty(string) && string.contains(str);
    }

    public boolean a(List<t3> list, e0 e0Var) {
        i2 i2Var;
        if (list == null || list.size() == 0 || (this.j.isEmpty() && this.k.isEmpty())) {
            return true;
        }
        Iterator<t3> it = list.iterator();
        while (it.hasNext()) {
            t3 next = it.next();
            if (next instanceof a4) {
                if (this.k.contains(((a4) next).u)) {
                    it.remove();
                    i2Var = e0Var.q;
                    l2.a(i2Var, 2L, e0Var.d(), 1002);
                }
            } else if (next instanceof w3) {
                JSONObject jSONObjectH = next.h();
                if (this.j.contains(jSONObjectH.optString("tag") + (!TextUtils.isEmpty(jSONObjectH.optString("label")) ? jSONObjectH.optString("label") : ""))) {
                    it.remove();
                    i2Var = e0Var.q;
                    l2.a(i2Var, 2L, e0Var.d(), 1002);
                }
            }
        }
        return true;
    }

    public String b() {
        String channel = this.c.getChannel();
        if (TextUtils.isEmpty(channel)) {
            channel = this.c.getTweakedChannel();
        }
        if (!TextUtils.isEmpty(channel)) {
            return channel;
        }
        try {
            return this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128).metaData.getString("UMENG_CHANNEL");
        } catch (Throwable th) {
            this.b.D.error(Collections.singletonList("ConfigManager"), "getChannel failed", th, new Object[0]);
            return channel;
        }
    }

    public String c() {
        String string = this.h;
        if (TextUtils.isEmpty(string)) {
            synchronized (this) {
                string = this.d.getString("external_ab_version", "");
                this.h = string;
            }
        }
        return string;
    }

    public long d() {
        return this.f.getLong("session_interval", 30000L);
    }

    public String e() {
        return com.bytedance.bdtracker.a.a("ssid_").append(this.c.getAid()).toString();
    }

    public String f() {
        return this.d.getString("user_unique_id", "");
    }

    public boolean g() {
        return this.c.isAbEnable() && this.f.getBoolean("bav_ab_config", this.c.isAbEnable());
    }

    public boolean h() {
        if (this.c.getProcess() == 0) {
            String strB = l0.b.b();
            if (TextUtils.isEmpty(strB)) {
                this.c.setProcess(0);
            } else {
                this.c.setProcess(strB.contains(":") ? 2 : 1);
            }
        }
        return this.c.getProcess() == 1;
    }

    public boolean i() {
        return this.f.getBoolean("monitor_enabled", this.c.isMonitorEnabled());
    }

    public boolean j() {
        return this.c.isOaidEnabled() && !a("oaid");
    }

    public void k() {
        if (this.f.getLong("app_log_last_config_time", 0L) <= 0) {
            return;
        }
        LogUtils.sendJsonFetcher("remote_settings", new a());
    }

    public List<t3> a(List<t3> list) {
        Iterator<t3> it = list.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            t3 next = it.next();
            if (next instanceof a4) {
                a4 a4Var = (a4) next;
                HashSet<String> hashSet = this.l;
                if (hashSet == null) {
                    try {
                        JSONArray jSONArray = new JSONArray(this.f.getString("real_time_events", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI));
                        int length = jSONArray.length();
                        HashSet<String> hashSet2 = new HashSet<>();
                        for (int i = 0; i < length; i++) {
                            String string = jSONArray.getString(i);
                            if (!TextUtils.isEmpty(string)) {
                                hashSet2.add(string);
                            }
                        }
                        hashSet = hashSet2;
                    } catch (Throwable th) {
                        this.b.D.error(Collections.singletonList("ConfigManager"), "getRealTimeEvents failed", th, new Object[0]);
                        hashSet = new HashSet<>();
                    }
                }
                this.l = hashSet;
                if (hashSet.contains(a4Var.u)) {
                    it.remove();
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public void a(JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("backoff_ratio", 0);
        this.m = iOptInt;
        if (iOptInt < 0 || iOptInt > 10000) {
            this.m = 0;
        }
        int i = this.m > 0 ? 1 : 27;
        int iOptInt2 = jSONObject.optInt("max_request_frequency", i);
        this.n = iOptInt2;
        if (iOptInt2 < 1 || iOptInt2 > 27) {
            this.n = i;
        }
        int i2 = this.m;
        if (i2 > 0 && this.o == 0) {
            this.o = System.currentTimeMillis();
            this.p = 1;
        } else if (i2 == 0) {
            this.o = 0L;
            this.p = 0;
        }
        this.q = jSONObject.optLong("batch_event_interval", 0L) * 1000;
        this.r = jSONObject.optInt("enter_background_not_send") == 1;
        this.b.D.debug(Collections.singletonList("ConfigManager"), com.bytedance.bdtracker.a.a("updateLogRespConfig mBackoffRatio: ").append(this.m).append(", mMaxRequestFrequency: ").append(this.n).append(", mBackoffWindowStartTime: ").append(this.o).append(", mBackoffWindowSendCount: ").append(this.p).append(", mEventIntervalFromLogResp: ").append(this.q).toString(), new Object[0]);
    }
}
