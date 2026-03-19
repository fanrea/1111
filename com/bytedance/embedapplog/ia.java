package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ia extends to {
    private String mq;
    private String uo;

    @Override // com.bytedance.embedapplog.to
    String c() {
        return "event_misc";
    }

    public ia(String str, JSONObject jSONObject) {
        this.uo = str;
        this.mq = jSONObject.toString();
        this.tc = 0;
    }

    @Override // com.bytedance.embedapplog.to
    protected List<String> d() {
        List<String> listD = super.d();
        ArrayList arrayList = new ArrayList(listD.size());
        arrayList.addAll(listD);
        arrayList.addAll(Arrays.asList("params", "varchar", "log_type", "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.to
    public int d(Cursor cursor) {
        int iD = super.d(cursor);
        int i = iD + 1;
        this.mq = cursor.getString(iD);
        int i2 = i + 1;
        this.uo = cursor.getString(i);
        return i2;
    }

    @Override // com.bytedance.embedapplog.to
    protected void d(ContentValues contentValues) {
        super.d(contentValues);
        contentValues.put("params", this.mq);
        contentValues.put("log_type", this.uo);
    }

    @Override // com.bytedance.embedapplog.to
    protected void d(JSONObject jSONObject) throws JSONException {
        super.d(jSONObject);
        jSONObject.put("params", this.mq);
        jSONObject.put("log_type", this.uo);
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
        jSONObject.put("log_type", this.uo);
        try {
            JSONObject jSONObject2 = new JSONObject(this.mq);
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject2.get(next);
                if (jSONObject.opt(next) != null) {
                    um.hc("misc事件存在重复的key", null);
                }
                jSONObject.put(next, obj);
            }
        } catch (Exception e) {
            um.b("解析 event misc 失败", e);
        }
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.to
    protected to hc(JSONObject jSONObject) {
        super.hc(jSONObject);
        this.mq = jSONObject.optString("params", null);
        this.uo = jSONObject.optString("log_type", null);
        return this;
    }

    @Override // com.bytedance.embedapplog.to
    protected String gb() {
        return "param:" + this.mq + " logType:" + this.uo;
    }

    @Override // com.bytedance.embedapplog.to
    protected String tt() {
        return this.mq;
    }
}
