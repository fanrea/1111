package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.baidu.mobstat.forbes.Config;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class nr extends to {
    long cb;
    private JSONArray de;
    JSONArray e;
    JSONArray jh;
    public int k;
    public byte[] mq;
    private JSONObject np;
    dz rf;
    long sy;
    int uo;
    private ey v;
    JSONArray w;
    long yo;

    @Override // com.bytedance.embedapplog.to
    String c() {
        return "pack";
    }

    void d(JSONObject jSONObject, dz dzVar, ey eyVar, JSONArray jSONArray, JSONArray[] jSONArrayArr, long[] jArr, int i) {
        d(0L);
        this.np = jSONObject;
        this.rf = dzVar;
        this.v = eyVar;
        this.de = jSONArray;
        this.e = jSONArrayArr[0];
        this.cb = jArr[0];
        this.w = jSONArrayArr[1];
        this.yo = jArr[1];
        this.jh = jSONArrayArr[2];
        this.sy = jArr[2];
        this.tc = i;
    }

    @Override // com.bytedance.embedapplog.to
    protected List<String> d() {
        return Arrays.asList("_id", "integer primary key autoincrement", "local_time_ms", TypedValues.Custom.S_INT, "_data", "blob", "_fail", TypedValues.Custom.S_INT, ICEffectKeys.KEY_IS_IC_EFFECT_EVENT_TYPE, TypedValues.Custom.S_INT);
    }

    @Override // com.bytedance.embedapplog.to
    public int d(Cursor cursor) {
        this.d = cursor.getLong(0);
        this.hc = cursor.getLong(1);
        this.mq = cursor.getBlob(2);
        this.uo = cursor.getInt(3);
        this.tc = cursor.getInt(4);
        this.c = "";
        this.np = null;
        this.rf = null;
        this.v = null;
        this.de = null;
        this.e = null;
        this.w = null;
        this.jh = null;
        return 5;
    }

    @Override // com.bytedance.embedapplog.to
    protected void d(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.hc));
        contentValues.put("_data", tc());
        contentValues.put(ICEffectKeys.KEY_IS_IC_EFFECT_EVENT_TYPE, Integer.valueOf(this.tc));
    }

    public byte[] tc() {
        this.mq = null;
        try {
            byte[] bArrD = t.d(an().toString());
            this.mq = bArrD;
            return bArrD;
        } catch (OutOfMemoryError e) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ra.b.length; i++) {
                if (ra.b[i] != null) {
                    sb.append(ra.b[i].toString()).append(com.alipay.sdk.m.u.i.b);
                }
            }
            throw new RuntimeException(sb.toString(), e);
        }
    }

    @Override // com.bytedance.embedapplog.to
    protected void d(JSONObject jSONObject) {
        um.hc((Throwable) null);
    }

    @Override // com.bytedance.embedapplog.to
    protected JSONObject hc() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", this.np);
        jSONObject.put("time_sync", fu.d);
        jSONObject.put("local_time", System.currentTimeMillis() / 1000);
        if (this.rf != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.rf.an());
            jSONObject.put(Config.LAUNCH, jSONArray);
        }
        ey eyVar = this.v;
        int i = 0;
        if (eyVar != null) {
            JSONObject jSONObjectAn = eyVar.an();
            JSONArray jSONArray2 = this.de;
            int length = jSONArray2 != null ? jSONArray2.length() : 0;
            JSONArray jSONArray3 = new JSONArray();
            int i2 = 0;
            long j = 0;
            while (i2 < length) {
                JSONArray jSONArray4 = new JSONArray();
                JSONObject jSONObject2 = new JSONObject(this.de.optString(i2));
                JSONObject jSONObject3 = new JSONObject(jSONObject2.optString("params"));
                jSONArray4.put(i, jSONObject3.optString("page_key", ""));
                jSONArray4.put(1, (jSONObject3.optInt("duration", i) + 999) / 1000);
                jSONArray3.put(jSONArray4);
                int i3 = length;
                long jOptLong = jSONObject2.optLong("local_time_ms", 0L);
                if (jOptLong > j) {
                    jSONObjectAn.put("$page_title", jSONObject3.optString(ArticleInfo.PAGE_TITLE, ""));
                    jSONObjectAn.put("$page_key", jSONObject3.optString("page_key", ""));
                    j = jOptLong;
                }
                i2++;
                length = i3;
                i = 0;
            }
            if (length > 0) {
                jSONObjectAn.put("activites", jSONArray3);
            }
            JSONArray jSONArray5 = new JSONArray();
            jSONArray5.put(jSONObjectAn);
            jSONObject.put("terminate", jSONArray5);
        }
        JSONArray jSONArray6 = this.e;
        int length2 = jSONArray6 != null ? jSONArray6.length() : 0;
        if (length2 > 0) {
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.e);
        }
        JSONArray jSONArray7 = this.de;
        int length3 = jSONArray7 != null ? jSONArray7.length() : 0;
        JSONArray jSONArray8 = this.w;
        int length4 = jSONArray8 != null ? jSONArray8.length() : 0;
        if (length4 > 0) {
            jSONObject.put("event_v3", this.w);
        }
        JSONArray jSONArray9 = this.jh;
        int length5 = jSONArray9 != null ? jSONArray9.length() : 0;
        if (length5 > 0) {
            jSONObject.put("log_data", this.jh);
        }
        StringBuilder sb = new StringBuilder("pack {");
        sb.append("ts:").append(this.hc);
        StringBuilder sbAppend = sb.append(", la:");
        Object obj = this.rf;
        if (obj == null) {
            obj = "0";
        }
        sbAppend.append(obj);
        StringBuilder sbAppend2 = sb.append(", te:");
        ey eyVar2 = this.v;
        sbAppend2.append(eyVar2 != null ? eyVar2 : "0");
        sb.append(", p:").append(length3);
        sb.append(", v1:").append(length2);
        sb.append(", v3:").append(length4);
        sb.append(", m:").append(length5);
        um.d(sb.toString());
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.to
    protected to hc(JSONObject jSONObject) {
        um.hc((Throwable) null);
        return null;
    }

    @Override // com.bytedance.embedapplog.to
    protected String gb() {
        return String.valueOf(this.d);
    }
}
