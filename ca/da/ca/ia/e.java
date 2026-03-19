package ca.da.ca.ia;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.common.utility.NetworkUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Event.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class e extends b {
    public String l;
    public String m;
    public String n;
    public String o;
    public long p;
    public long q;

    public e(String str, String str2, String str3, long j, long j2, String str4) {
        a(0L);
        this.l = str;
        this.m = str2;
        this.n = str3;
        this.p = j;
        this.q = j2;
        this.o = str4;
    }

    @Override // ca.da.ca.ia.b
    public int a(Cursor cursor) {
        super.a(cursor);
        this.l = cursor.getString(9);
        this.m = cursor.getString(10);
        this.p = cursor.getLong(11);
        this.q = cursor.getLong(12);
        this.o = cursor.getString(13);
        this.n = cursor.getString(14);
        return 15;
    }

    @Override // ca.da.ca.ia.b
    public List<String> b() {
        List<String> listB = super.b();
        ArrayList arrayList = new ArrayList(listB.size());
        arrayList.addAll(listB);
        arrayList.addAll(Arrays.asList("category", "varchar", "tag", "varchar", com.alipay.sdk.m.p0.b.d, TypedValues.Custom.S_INT, "ext_value", TypedValues.Custom.S_INT, "params", "varchar", "label", "varchar"));
        return arrayList;
    }

    @Override // ca.da.ca.ia.b
    public String c() {
        return this.o;
    }

    @Override // ca.da.ca.ia.b
    public String d() {
        return ca.ca.ca.ca.a.a("").append(this.m).append(", ").append(this.n).toString();
    }

    @Override // ca.da.ca.ia.b
    public String e() {
        return NotificationCompat.CATEGORY_EVENT;
    }

    @Override // ca.da.ca.ia.b
    public JSONObject g() throws JSONException {
        JSONObject jSONObject = !TextUtils.isEmpty(this.o) ? new JSONObject(this.o) : null;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        jSONObject.put("local_time_ms", this.b);
        jSONObject.put("tea_event_index", this.c);
        jSONObject.put("session_id", this.d);
        long j = this.e;
        if (j > 0) {
            jSONObject.put("user_id", j);
        }
        if (this.i != NetworkUtils.NetworkType.UNKNOWN.getValue()) {
            jSONObject.put("nt", this.i);
        }
        if (!TextUtils.isEmpty(this.f)) {
            jSONObject.put("user_unique_id", this.f);
        }
        if (!TextUtils.isEmpty(this.g)) {
            jSONObject.put("ssid", this.g);
        }
        jSONObject.put("category", this.l);
        jSONObject.put("tag", this.m);
        jSONObject.put(com.alipay.sdk.m.p0.b.d, this.p);
        jSONObject.put("ext_value", this.q);
        jSONObject.put("label", this.n);
        jSONObject.put("datetime", this.j);
        if (!TextUtils.isEmpty(this.h)) {
            jSONObject.put("ab_sdk_version", this.h);
        }
        return jSONObject;
    }

    @Override // ca.da.ca.ia.b
    public void b(ContentValues contentValues) {
        super.b(contentValues);
        contentValues.put("category", this.l);
        contentValues.put("tag", this.m);
        contentValues.put(com.alipay.sdk.m.p0.b.d, Long.valueOf(this.p));
        contentValues.put("ext_value", Long.valueOf(this.q));
        contentValues.put("params", this.o);
        contentValues.put("label", this.n);
    }

    @Override // ca.da.ca.ia.b
    public b a(JSONObject jSONObject) {
        super.a(jSONObject);
        this.c = jSONObject.optLong("tea_event_index", 0L);
        this.l = jSONObject.optString("category", null);
        this.m = jSONObject.optString("tag", null);
        this.p = jSONObject.optLong(com.alipay.sdk.m.p0.b.d, 0L);
        this.q = jSONObject.optLong("ext_value", 0L);
        this.o = jSONObject.optString("params", null);
        this.n = jSONObject.optString("label", null);
        return this;
    }

    public e() {
    }
}
