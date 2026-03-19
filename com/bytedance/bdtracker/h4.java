package com.bytedance.bdtracker;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.bdtracker.s4;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h4 extends t3 {
    public static final JSONObject s;

    static {
        JSONObject jSONObject = new JSONObject();
        s = jSONObject;
        try {
            jSONObject.put("_staging_flag", 1);
            jSONObject.put("params_for_special", "applog_trace");
        } catch (Throwable th) {
            LoggerImpl.global().error(4, Collections.singletonList(Config.TRACE_PART), "JSON handle failed", th, new Object[0]);
        }
    }

    @Override // com.bytedance.bdtracker.t3
    public String f() {
        return Config.TRACE_PART;
    }

    @Override // com.bytedance.bdtracker.t3
    public JSONObject i() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.c);
        jSONObject.put("tea_event_index", this.d);
        jSONObject.put("session_id", this.e);
        long j = this.f;
        if (j > 0) {
            jSONObject.put("user_id", j);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.g) ? JSONObject.NULL : this.g);
        if (!TextUtils.isEmpty(this.h)) {
            jSONObject.put("$user_unique_id_type", this.h);
        }
        if (!TextUtils.isEmpty(this.i)) {
            jSONObject.put("ssid", this.i);
        }
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, "rangersapplog_trace");
        a(jSONObject, s);
        int i = this.k;
        if (i != s4.a.UNKNOWN.a) {
            jSONObject.put("nt", i);
        }
        jSONObject.put("datetime", this.n);
        return jSONObject;
    }
}
