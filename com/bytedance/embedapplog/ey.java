package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ey extends to {
    public int e = 0;
    String k;
    long mq;
    long uo;

    @Override // com.bytedance.embedapplog.to
    String c() {
        return "terminate";
    }

    @Override // com.bytedance.embedapplog.to
    protected List<String> d() {
        return null;
    }

    @Override // com.bytedance.embedapplog.to
    public int d(Cursor cursor) {
        um.hc((Throwable) null);
        return 0;
    }

    @Override // com.bytedance.embedapplog.to
    protected void d(ContentValues contentValues) {
        um.hc((Throwable) null);
    }

    @Override // com.bytedance.embedapplog.to
    protected void d(JSONObject jSONObject) {
        um.hc((Throwable) null);
    }

    @Override // com.bytedance.embedapplog.to
    protected JSONObject hc() throws JSONException {
        dz dzVar;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.hc);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("session_id", this.c);
        jSONObject.put("stop_timestamp", this.uo / 1000);
        jSONObject.put("duration", this.mq / 1000);
        jSONObject.put("datetime", this.mk);
        if (this.u > 0) {
            jSONObject.put("user_id", this.u);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.an) ? JSONObject.NULL : this.an);
        if (!TextUtils.isEmpty(this.h)) {
            jSONObject.put("ssid", this.h);
        }
        if (!TextUtils.isEmpty(this.gb)) {
            jSONObject.put("ab_sdk_version", this.gb);
        }
        if (!TextUtils.isEmpty(this.k)) {
            jSONObject.put("uuid_changed", true);
            if (!TextUtils.equals(this.k, this.c)) {
                jSONObject.put("original_session_id", this.k);
            }
        }
        if (this.e == 0 && (dzVar = (dz) ra.hc.get(Config.LAUNCH)) != null && !dzVar.jh) {
            this.e = 6;
        }
        jSONObject.put("launch_from", this.e);
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.to
    protected to hc(JSONObject jSONObject) {
        um.hc((Throwable) null);
        return this;
    }

    @Override // com.bytedance.embedapplog.to
    protected String gb() {
        return String.valueOf(this.mq);
    }
}
