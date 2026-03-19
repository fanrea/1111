package ca.da.ca.ia;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import ca.da.ca.ja.r;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Terminate.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class m extends b {
    public long l;
    public long m;
    public String n;

    @Override // ca.da.ca.ia.b
    public int a(Cursor cursor) {
        r.a((Throwable) null);
        return 0;
    }

    @Override // ca.da.ca.ia.b
    public List<String> b() {
        return null;
    }

    @Override // ca.da.ca.ia.b
    public void b(ContentValues contentValues) {
        r.a((Throwable) null);
    }

    @Override // ca.da.ca.ia.b
    public String d() {
        return String.valueOf(this.l);
    }

    @Override // ca.da.ca.ia.b
    public String e() {
        return "terminate";
    }

    @Override // ca.da.ca.ia.b
    public JSONObject g() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.b);
        jSONObject.put("tea_event_index", this.c);
        jSONObject.put("session_id", this.d);
        jSONObject.put("stop_timestamp", this.m / 1000);
        jSONObject.put("duration", this.l / 1000);
        jSONObject.put("datetime", this.j);
        long j = this.e;
        if (j > 0) {
            jSONObject.put("user_id", j);
        }
        if (!TextUtils.isEmpty(this.f)) {
            jSONObject.put("user_unique_id", this.f);
        }
        if (!TextUtils.isEmpty(this.g)) {
            jSONObject.put("ssid", this.g);
        }
        if (!TextUtils.isEmpty(this.h)) {
            jSONObject.put("ab_sdk_version", this.h);
        }
        if (!TextUtils.isEmpty(this.n)) {
            jSONObject.put("uuid_changed", true);
            if (!TextUtils.equals(this.n, this.d)) {
                jSONObject.put("original_session_id", this.n);
            }
        }
        return jSONObject;
    }

    @Override // ca.da.ca.ia.b
    public b a(JSONObject jSONObject) {
        r.a((Throwable) null);
        return this;
    }
}
