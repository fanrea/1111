package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class rw extends to {
    public long cb;
    public String e;
    public String k;
    public String mq;
    public String uo;
    long w;

    @Override // com.bytedance.embedapplog.to
    String c() {
        return NotificationCompat.CATEGORY_EVENT;
    }

    rw() {
    }

    @Override // com.bytedance.embedapplog.to
    protected List<String> d() {
        List<String> listD = super.d();
        ArrayList arrayList = new ArrayList(listD.size());
        arrayList.addAll(listD);
        arrayList.addAll(Arrays.asList("category", "varchar", "tag", "varchar", com.alipay.sdk.m.p0.b.d, TypedValues.Custom.S_INT, "ext_value", TypedValues.Custom.S_INT, "params", "varchar", "label", "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.to
    public int d(Cursor cursor) {
        int iD = super.d(cursor);
        int i = iD + 1;
        this.mq = cursor.getString(iD);
        int i2 = i + 1;
        this.uo = cursor.getString(i);
        int i3 = i2 + 1;
        this.cb = cursor.getLong(i2);
        int i4 = i3 + 1;
        this.w = cursor.getLong(i3);
        int i5 = i4 + 1;
        this.e = cursor.getString(i4);
        int i6 = i5 + 1;
        this.k = cursor.getString(i5);
        return i6;
    }

    @Override // com.bytedance.embedapplog.to
    protected void d(ContentValues contentValues) {
        super.d(contentValues);
        contentValues.put("category", this.mq);
        contentValues.put("tag", this.uo);
        contentValues.put(com.alipay.sdk.m.p0.b.d, Long.valueOf(this.cb));
        contentValues.put("ext_value", Long.valueOf(this.w));
        contentValues.put("params", this.e);
        contentValues.put("label", this.k);
    }

    @Override // com.bytedance.embedapplog.to
    protected void d(JSONObject jSONObject) throws JSONException {
        super.d(jSONObject);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("category", this.mq);
        jSONObject.put("tag", this.uo);
        jSONObject.put(com.alipay.sdk.m.p0.b.d, this.cb);
        jSONObject.put("ext_value", this.w);
        jSONObject.put("params", this.e);
        jSONObject.put("label", this.k);
    }

    @Override // com.bytedance.embedapplog.to
    protected to hc(JSONObject jSONObject) {
        super.hc(jSONObject);
        this.b = jSONObject.optLong("tea_event_index", 0L);
        this.mq = jSONObject.optString("category", null);
        this.uo = jSONObject.optString("tag", null);
        this.cb = jSONObject.optLong(com.alipay.sdk.m.p0.b.d, 0L);
        this.w = jSONObject.optLong("ext_value", 0L);
        this.e = jSONObject.optString("params", null);
        this.k = jSONObject.optString("label", null);
        return this;
    }

    @Override // com.bytedance.embedapplog.to
    protected JSONObject hc() throws JSONException {
        JSONObject jSONObject = !TextUtils.isEmpty(this.e) ? new JSONObject(this.e) : null;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        jSONObject.put("local_time_ms", this.hc);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("session_id", this.c);
        if (this.u > 0) {
            jSONObject.put("user_id", this.u);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.an) ? JSONObject.NULL : this.an);
        if (!TextUtils.isEmpty(this.h)) {
            jSONObject.put("ssid", this.h);
        }
        jSONObject.put("category", this.mq);
        jSONObject.put("tag", this.uo);
        jSONObject.put(com.alipay.sdk.m.p0.b.d, this.cb);
        jSONObject.put("ext_value", this.w);
        jSONObject.put("label", this.k);
        jSONObject.put("datetime", this.mk);
        if (!TextUtils.isEmpty(this.gb)) {
            jSONObject.put("ab_sdk_version", this.gb);
        }
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.to
    protected String gb() {
        return this.uo + ", " + this.k;
    }

    @Override // com.bytedance.embedapplog.to
    protected String tt() {
        return this.e;
    }
}
