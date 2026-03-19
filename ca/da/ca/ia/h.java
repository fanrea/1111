package ca.da.ca.ia;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ca.da.ca.ja.r;
import com.baidu.mobstat.forbes.Config;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Launch.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class h extends b {
    public int l;
    public String m;
    public boolean n;
    public String o;
    public int p;
    public JSONObject q = new JSONObject();

    @Override // ca.da.ca.ia.b
    public int a(Cursor cursor) {
        super.a(cursor);
        this.m = cursor.getString(9);
        this.l = cursor.getInt(10);
        this.o = cursor.getString(11);
        this.p = cursor.getInt(12);
        return 13;
    }

    @Override // ca.da.ca.ia.b
    public List<String> b() {
        List<String> listB = super.b();
        ArrayList arrayList = new ArrayList(listB.size());
        arrayList.addAll(listB);
        arrayList.addAll(Arrays.asList("ver_name", "varchar", "ver_code", TypedValues.Custom.S_INT, "last_session", "varchar", "is_first_time", TypedValues.Custom.S_INT));
        return arrayList;
    }

    @Override // ca.da.ca.ia.b
    public String d() {
        return this.n ? "bg" : "fg";
    }

    @Override // ca.da.ca.ia.b
    public String e() {
        return Config.LAUNCH;
    }

    @Override // ca.da.ca.ia.b
    public JSONObject g() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.b);
        jSONObject.put("tea_event_index", this.c);
        jSONObject.put("session_id", this.d);
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
        boolean z = this.n;
        if (z) {
            jSONObject.put("is_background", z);
        }
        jSONObject.put("datetime", this.j);
        if (!TextUtils.isEmpty(this.h)) {
            jSONObject.put("ab_sdk_version", this.h);
        }
        if (!TextUtils.isEmpty(this.o)) {
            jSONObject.put("uuid_changed", true);
            jSONObject.put("original_session_id", this.o);
        }
        if (this.p == 1) {
            jSONObject.put("$is_first_time", "true");
        }
        JSONObject jSONObject2 = this.q;
        if (jSONObject2 != null) {
            jSONObject.put("pv_filters", jSONObject2);
        }
        return jSONObject;
    }

    @Override // ca.da.ca.ia.b
    public void b(ContentValues contentValues) {
        super.b(contentValues);
        contentValues.put("ver_name", this.m);
        contentValues.put("ver_code", Integer.valueOf(this.l));
        contentValues.put("last_session", this.o);
        contentValues.put("is_first_time", Integer.valueOf(this.p));
    }

    @Override // ca.da.ca.ia.b
    public b a(JSONObject jSONObject) {
        r.a((Throwable) null);
        return null;
    }
}
