package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class to implements Cloneable {
    private static final SimpleDateFormat mq = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    public String an;
    public long b;
    public String c;
    long d;
    public String gb;
    public String h;
    public long hc;
    String mk;
    public int tc;
    public int tt;
    public long u;

    abstract String c();

    protected abstract JSONObject hc();

    protected String tt() {
        return null;
    }

    public to() {
        d(0L);
    }

    public void d(long j) {
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        this.hc = j;
    }

    protected List<String> d() {
        return Arrays.asList("_id", "integer primary key autoincrement", "local_time_ms", TypedValues.Custom.S_INT, "tea_event_index", TypedValues.Custom.S_INT, "nt", TypedValues.Custom.S_INT, "user_id", TypedValues.Custom.S_INT, "session_id", "varchar", "user_unique_id", "varchar", "ssid", "varchar", "ab_sdk_version", "varchar", ICEffectKeys.KEY_IS_IC_EFFECT_EVENT_TYPE, TypedValues.Custom.S_INT);
    }

    public int d(Cursor cursor) {
        this.d = cursor.getLong(0);
        this.hc = cursor.getLong(1);
        this.b = cursor.getLong(2);
        this.tt = cursor.getInt(3);
        this.u = cursor.getLong(4);
        this.c = cursor.getString(5);
        this.an = cursor.getString(6);
        this.h = cursor.getString(7);
        this.gb = cursor.getString(8);
        this.tc = cursor.getInt(9);
        return 10;
    }

    protected void d(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.hc));
        contentValues.put("tea_event_index", Long.valueOf(this.b));
        contentValues.put("nt", Integer.valueOf(this.tt));
        contentValues.put("user_id", Long.valueOf(this.u));
        contentValues.put("session_id", this.c);
        contentValues.put("user_unique_id", this.an);
        contentValues.put("ssid", this.h);
        contentValues.put("ab_sdk_version", this.gb);
        contentValues.put(ICEffectKeys.KEY_IS_IC_EFFECT_EVENT_TYPE, Integer.valueOf(this.tc));
    }

    public static String hc(long j) {
        return mq.format(new Date(j));
    }

    protected void d(JSONObject jSONObject) throws JSONException {
        jSONObject.put("local_time_ms", this.hc);
    }

    protected to hc(JSONObject jSONObject) {
        this.hc = jSONObject.optLong("local_time_ms", 0L);
        this.d = 0L;
        this.b = 0L;
        this.tt = 0;
        this.u = 0L;
        this.c = null;
        this.an = null;
        this.h = null;
        this.gb = null;
        return this;
    }

    final ContentValues hc(ContentValues contentValues) {
        if (contentValues == null) {
            contentValues = new ContentValues();
        } else {
            contentValues.clear();
        }
        d(contentValues);
        return contentValues;
    }

    final String b() {
        List<String> listD = d();
        if (listD == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("create table if not exists ").append(c()).append("(");
        for (int i = 0; i < listD.size(); i += 2) {
            sb.append(listD.get(i)).append(" ").append(listD.get(i + 1)).append(",");
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append(")");
        return sb.toString();
    }

    public final JSONObject u() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("k_cls", c());
            d(jSONObject);
        } catch (JSONException e) {
            um.hc(e);
        }
        return jSONObject;
    }

    public final JSONObject an() {
        try {
            this.mk = hc(this.hc);
            return hc();
        } catch (JSONException e) {
            um.hc(e);
            return null;
        }
    }

    public static to d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return ra.hc.get(jSONObject.optString("k_cls", "")).clone().hc(jSONObject);
        } catch (Throwable th) {
            um.hc(th);
            return null;
        }
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public to clone() {
        try {
            return (to) super.clone();
        } catch (CloneNotSupportedException e) {
            um.hc(e);
            return null;
        }
    }

    public String toString() {
        String strC = c();
        if (!getClass().getSimpleName().equalsIgnoreCase(strC)) {
            strC = strC + ", " + getClass().getSimpleName();
        }
        String strSubstring = this.c;
        String str = "-";
        if (strSubstring != null) {
            int iIndexOf = strSubstring.indexOf("-");
            if (iIndexOf >= 0) {
                strSubstring = strSubstring.substring(0, iIndexOf);
            }
            str = strSubstring;
        }
        return "{" + strC + ", " + gb() + ", " + str + ", " + this.hc + com.alipay.sdk.m.u.i.d;
    }

    protected String gb() {
        return "sid:" + this.c;
    }
}
