package com.bytedance.bdtracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.applog.log.AbstractAppLogLogger;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.bdtracker.l0;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class t3 implements Cloneable {
    public static final SimpleDateFormat q = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    public static final i4<HashMap<String, t3>> r = new a();
    public List<String> a;
    public long b;
    public long c;
    public long d;
    public String e;
    public long f;
    public String g;
    public String h;
    public String i;
    public String j;
    public int k;
    public int l;
    public String m;
    public String n;
    public JSONObject o;
    public String p;

    public static class a extends i4<HashMap<String, t3>> {
        @Override // com.bytedance.bdtracker.i4
        public HashMap<String, t3> a(Object[] objArr) {
            return t3.j();
        }
    }

    public t3() {
        a(0L);
        this.a = Collections.singletonList(f());
        this.p = l0.b.c();
    }

    public static t3 a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return r.b(new Object[0]).get(jSONObject.optString("k_cls", "")).m347clone().a(jSONObject);
        } catch (Throwable th) {
            LoggerImpl.global().error(4, "JSON handle failed", th, new Object[0]);
            return null;
        }
    }

    public static void a(t3 t3Var, String str) {
        try {
            JSONObject jSONObject = t3Var.o;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            jSONObject.put("$app_version", str);
            t3Var.o = jSONObject;
        } catch (Throwable unused) {
        }
    }

    public static String b(long j) {
        return q.format(new Date(j));
    }

    public static HashMap<String, t3> j() {
        HashMap<String, t3> map = new HashMap<>();
        map.put("page", new d4());
        map.put(Config.LAUNCH, new b4());
        map.put("terminate", new g4());
        map.put("packV2", new c4());
        map.put("eventv3", new a4());
        map.put("custom_event", new w3());
        map.put("profile", new e4(null, null));
        map.put(Config.TRACE_PART, new h4());
        return map;
    }

    public int a(Cursor cursor) {
        this.b = cursor.getLong(0);
        this.c = cursor.getLong(1);
        this.d = cursor.getLong(2);
        this.k = cursor.getInt(3);
        this.f = cursor.getLong(4);
        this.e = cursor.getString(5);
        this.g = cursor.getString(6);
        this.h = cursor.getString(7);
        this.i = cursor.getString(8);
        this.j = cursor.getString(9);
        this.l = cursor.getInt(10);
        this.m = cursor.getString(11);
        String string = cursor.getString(12);
        this.p = cursor.getString(13);
        this.o = new JSONObject();
        if (TextUtils.isEmpty(string)) {
            return 14;
        }
        try {
            this.o = new JSONObject(string);
            return 14;
        } catch (Exception unused) {
            return 14;
        }
    }

    public final ContentValues a(ContentValues contentValues) {
        if (contentValues == null) {
            contentValues = new ContentValues();
        } else {
            contentValues.clear();
        }
        b(contentValues);
        return contentValues;
    }

    public t3 a(JSONObject jSONObject) {
        this.c = jSONObject.optLong("local_time_ms", 0L);
        this.b = 0L;
        this.d = 0L;
        this.k = 0;
        this.f = 0L;
        this.e = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.m = jSONObject.optString("_app_id");
        this.o = jSONObject.optJSONObject("properties");
        this.p = jSONObject.optString("local_event_id", l0.b.c());
        return this;
    }

    public final String a() {
        List<String> listB = b();
        if (listB == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("create table if not exists ").append(f()).append("(");
        for (int i = 0; i < listB.size(); i += 2) {
            sb.append(listB.get(i)).append(" ").append(listB.get(i + 1)).append(",");
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append(")");
        return sb.toString();
    }

    public void a(long j) {
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        this.c = j;
    }

    public void a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            a(jSONObject, new JSONObject());
            return;
        }
        try {
            a(jSONObject, new JSONObject(str));
        } catch (Throwable th) {
            d().error(4, this.a, "Merge params failed", th, new Object[0]);
        }
    }

    public void a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObject2 != null && jSONObject2.length() > 0) {
            l0.b.b(jSONObject2, jSONObject3);
        }
        JSONObject jSONObject4 = this.o;
        if (jSONObject4 != null && jSONObject4.length() > 0) {
            l0.b.b(this.o, jSONObject3);
        }
        try {
            jSONObject.put("params", jSONObject3);
        } catch (Throwable th) {
            d().error(4, this.a, "Merge params failed", th, new Object[0]);
        }
    }

    public List<String> b() {
        return Arrays.asList("_id", "integer primary key autoincrement", "local_time_ms", TypedValues.Custom.S_INT, "tea_event_index", TypedValues.Custom.S_INT, "nt", TypedValues.Custom.S_INT, "user_id", TypedValues.Custom.S_INT, "session_id", "varchar", "user_unique_id", "varchar", "user_unique_id_type", "varchar", "ssid", "varchar", "ab_sdk_version", "varchar", ICEffectKeys.KEY_IS_IC_EFFECT_EVENT_TYPE, TypedValues.Custom.S_INT, "_app_id", "varchar", "properties", "varchar", "local_event_id", "varchar");
    }

    public void b(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.c));
        contentValues.put("tea_event_index", Long.valueOf(this.d));
        contentValues.put("nt", Integer.valueOf(this.k));
        contentValues.put("user_id", Long.valueOf(this.f));
        contentValues.put("session_id", this.e);
        contentValues.put("user_unique_id", l0.b.a((Object) this.g));
        contentValues.put("user_unique_id_type", this.h);
        contentValues.put("ssid", this.i);
        contentValues.put("ab_sdk_version", this.j);
        contentValues.put(ICEffectKeys.KEY_IS_IC_EFFECT_EVENT_TYPE, Integer.valueOf(this.l));
        contentValues.put("_app_id", this.m);
        JSONObject jSONObject = this.o;
        contentValues.put("properties", jSONObject != null ? jSONObject.toString() : "");
        contentValues.put("local_event_id", this.p);
    }

    public void b(JSONObject jSONObject) throws JSONException {
        jSONObject.put("local_time_ms", this.c);
        jSONObject.put("_app_id", this.m);
        jSONObject.put("properties", this.o);
        jSONObject.put("local_event_id", this.p);
    }

    public String c() {
        return com.bytedance.bdtracker.a.a("sid:").append(this.e).toString();
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public t3 m347clone() {
        try {
            t3 t3Var = (t3) super.clone();
            t3Var.p = l0.b.c();
            return t3Var;
        } catch (CloneNotSupportedException e) {
            d().error(4, this.a, "Clone data failed", e, new Object[0]);
            return null;
        }
    }

    public IAppLogLogger d() {
        IAppLogLogger logger = AbstractAppLogLogger.getLogger(this.m);
        return logger != null ? logger : LoggerImpl.global();
    }

    public String e() {
        return null;
    }

    public abstract String f();

    public final JSONObject g() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("k_cls", f());
            b(jSONObject);
        } catch (JSONException e) {
            d().error(4, this.a, "JSON handle failed", e, new Object[0]);
        }
        return jSONObject;
    }

    public final JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        try {
            this.n = b(this.c);
            return i();
        } catch (JSONException e) {
            d().error(4, this.a, "JSON handle failed", e, new Object[0]);
            return jSONObject;
        }
    }

    public abstract JSONObject i();

    public String toString() {
        String strF = f();
        if (!getClass().getSimpleName().equalsIgnoreCase(strF)) {
            strF = strF + ", " + getClass().getSimpleName();
        }
        String strSubstring = this.e;
        if (strSubstring != null) {
            int iIndexOf = strSubstring.indexOf("-");
            if (iIndexOf >= 0) {
                strSubstring = strSubstring.substring(0, iIndexOf);
            }
        } else {
            strSubstring = "-";
        }
        return "{" + strF + ", " + c() + ", " + strSubstring + ", " + this.c + com.alipay.sdk.m.u.i.d;
    }
}
