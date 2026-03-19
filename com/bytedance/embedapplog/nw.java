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
public class nw extends to {
    private boolean k;
    protected String mq;
    protected String uo;

    @Override // com.bytedance.embedapplog.to
    String c() {
        return "eventv3";
    }

    public nw(String str, boolean z, String str2) {
        this.uo = str;
        this.k = z;
        this.mq = str2;
        this.tc = 0;
    }

    public nw(String str, boolean z, String str2, int i) {
        this.uo = str;
        this.k = z;
        this.mq = str2;
        this.tc = i;
    }

    @Override // com.bytedance.embedapplog.to
    protected List<String> d() {
        List<String> listD = super.d();
        ArrayList arrayList = new ArrayList(listD.size());
        arrayList.addAll(listD);
        arrayList.addAll(Arrays.asList(NotificationCompat.CATEGORY_EVENT, "varchar", "params", "varchar", "is_bav", TypedValues.Custom.S_INT));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.to
    public int d(Cursor cursor) {
        int iD = super.d(cursor);
        int i = iD + 1;
        this.uo = cursor.getString(iD);
        int i2 = i + 1;
        this.mq = cursor.getString(i);
        int i3 = i2 + 1;
        this.k = cursor.getInt(i2) == 1;
        return i3;
    }

    @Override // com.bytedance.embedapplog.to
    protected void d(ContentValues contentValues) {
        super.d(contentValues);
        contentValues.put(NotificationCompat.CATEGORY_EVENT, this.uo);
        contentValues.put("params", this.mq);
        contentValues.put("is_bav", Integer.valueOf(this.k ? 1 : 0));
    }

    @Override // com.bytedance.embedapplog.to
    protected void d(JSONObject jSONObject) throws JSONException {
        super.d(jSONObject);
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.uo);
        jSONObject.put("params", this.mq);
        jSONObject.put("is_bav", this.k);
    }

    @Override // com.bytedance.embedapplog.to
    protected JSONObject hc() throws JSONException {
        JSONObject jSONObject = new JSONObject();
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
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.uo);
        if (this.k) {
            jSONObject.put("is_bav", 1);
        }
        if (!TextUtils.isEmpty(this.mq)) {
            jSONObject.put("params", new JSONObject(this.mq));
        }
        jSONObject.put("datetime", this.mk);
        if (!TextUtils.isEmpty(this.gb)) {
            jSONObject.put("ab_sdk_version", this.gb);
        }
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.to
    protected to hc(JSONObject jSONObject) {
        super.hc(jSONObject);
        this.uo = jSONObject.optString(NotificationCompat.CATEGORY_EVENT, null);
        this.mq = jSONObject.optString("params", null);
        this.k = jSONObject.optBoolean("is_bav", false);
        return this;
    }

    @Override // com.bytedance.embedapplog.to
    protected String gb() {
        return this.uo;
    }

    @Override // com.bytedance.embedapplog.to
    public String tt() {
        return this.mq;
    }
}
