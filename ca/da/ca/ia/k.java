package ca.da.ca.ia;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.common.utility.NetworkUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Profile.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class k extends b {
    public String l;
    public String m;

    public k(String str, String str2) {
        this.m = str;
        this.l = str2;
    }

    @Override // ca.da.ca.ia.b
    public int a(Cursor cursor) {
        super.a(cursor);
        this.m = cursor.getString(9);
        this.l = cursor.getString(10);
        return 11;
    }

    @Override // ca.da.ca.ia.b
    public List<String> b() {
        List<String> listB = super.b();
        ArrayList arrayList = new ArrayList(listB.size());
        arrayList.addAll(listB);
        arrayList.addAll(Arrays.asList(NotificationCompat.CATEGORY_EVENT, "varchar", "params", "varchar"));
        return arrayList;
    }

    @Override // ca.da.ca.ia.b
    public String c() {
        return this.l;
    }

    @Override // ca.da.ca.ia.b
    public String d() {
        return this.m;
    }

    @Override // ca.da.ca.ia.b
    public String e() {
        return "profile";
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
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.m);
        if (!TextUtils.isEmpty(this.l)) {
            jSONObject.put("params", new JSONObject(this.l));
        }
        if (this.i != NetworkUtils.NetworkType.UNKNOWN.getValue()) {
            jSONObject.put("nt", this.i);
        }
        jSONObject.put("datetime", this.j);
        if (!TextUtils.isEmpty(this.h)) {
            jSONObject.put("ab_sdk_version", this.h);
        }
        return jSONObject;
    }

    @Override // ca.da.ca.ia.b
    public b a(JSONObject jSONObject) {
        super.a(jSONObject);
        this.m = jSONObject.optString(NotificationCompat.CATEGORY_EVENT, null);
        this.l = jSONObject.optString("params", null);
        return this;
    }

    @Override // ca.da.ca.ia.b
    public void b(ContentValues contentValues) {
        super.b(contentValues);
        contentValues.put(NotificationCompat.CATEGORY_EVENT, this.m);
        contentValues.put("params", this.l);
    }
}
