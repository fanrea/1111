package com.bytedance.d.hc.b;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.t.a;
import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import com.bytedance.d.hc.gb.k;
import com.bytedance.d.hc.gb.tc;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.component.utils.mq;
import com.sigmob.sdk.base.n;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    protected JSONObject d;

    public d() {
        this.d = new JSONObject();
    }

    public d(JSONObject jSONObject) {
        this.d = jSONObject;
    }

    public static d d(long j, Context context, Thread thread, Throwable th) throws JSONException {
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        d dVar = new d();
        dVar.d("isJava", (Object) 1);
        dVar.d(ICEffectKeys.KEY_IS_IC_EFFECT_EVENT_TYPE, "java_crash");
        dVar.d(a.k, Long.valueOf(System.currentTimeMillis()));
        dVar.d("data", k.d(th));
        dVar.d("isOOM", Boolean.valueOf(k.hc(th)));
        dVar.d("crash_time", Long.valueOf(j));
        dVar.d(ContentProviderManager.PLUGIN_PROCESS_NAME, com.bytedance.d.hc.gb.d.c(context));
        if (!com.bytedance.d.hc.gb.d.hc(context)) {
            dVar.d("remote_process", (Object) 1);
        }
        com.bytedance.d.hc.gb.d.d(context, dVar.d());
        String name = thread == null ? null : thread.getName();
        if (name != null) {
            dVar.d("crash_thread_name", name);
        }
        dVar.d("all_thread_stacks", k.d(name));
        return dVar;
    }

    public JSONObject d() {
        return this.d;
    }

    public d d(hc hcVar) throws JSONException {
        d("header", hcVar.d());
        return this;
    }

    public d d(long j) {
        try {
            d(MetricsSQLiteCacheKt.METRICS_START_TIME, Long.valueOf(j));
            d("app_start_time_readable", new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date(j)));
        } catch (Exception e) {
            mq.d(e);
        }
        return this;
    }

    public d d(String str) throws JSONException {
        if (!TextUtils.isEmpty(str)) {
            d("session_id", str);
        }
        return this;
    }

    public d d(com.bytedance.d.hc.u.d.hc hcVar) throws JSONException {
        d("activity_trace", hcVar.d());
        d("running_tasks", hcVar.hc());
        return this;
    }

    public d d(Map<String, Integer> map) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        if (map == null) {
            this.d.put("plugin_info", jSONArray);
            return this;
        }
        for (String str : map.keySet()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(n.p, str);
            jSONObject.put("version_code", map.get(str));
            jSONArray.put(jSONObject);
        }
        this.d.put("plugin_info", jSONArray);
        return this;
    }

    public d hc(Map<Integer, String> map) throws JSONException {
        if (map != null && map.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            for (Integer num : map.keySet()) {
                try {
                    jSONObject.put(String.valueOf(num), map.get(num));
                } catch (JSONException e) {
                    tc.hc(e);
                }
            }
            try {
                this.d.put("sdk_info", jSONObject);
            } catch (JSONException e2) {
                mq.d(e2);
            }
        }
        return this;
    }

    public d d(int i, String str) throws JSONException {
        try {
            this.d.put("miniapp_id", i);
            this.d.put("miniapp_version", str);
        } catch (JSONException e) {
            mq.d(e);
        }
        return this;
    }

    public d d(List<String> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.isEmpty()) {
            d("patch_info", jSONArray);
            return this;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        d("patch_info", jSONArray);
        return this;
    }

    public d d(JSONObject jSONObject) throws JSONException {
        d("storage", jSONObject);
        return this;
    }

    public d hc(List<String> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        d("logcat", jSONArray);
        return this;
    }

    public d b(Map<? extends String, ? extends String> map) throws JSONException {
        if (map != null) {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                try {
                    jSONObject.put(str, map.get(str));
                } catch (JSONException e) {
                    mq.d(e);
                }
            }
            d("filters", jSONObject);
        }
        return this;
    }

    public void d(String str, Object obj) throws JSONException {
        try {
            this.d.put(str, obj);
        } catch (Exception e) {
            tc.hc(e);
        }
    }
}
