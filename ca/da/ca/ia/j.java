package ca.da.ca.ia;

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

/* compiled from: Page.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class j extends b {
    public long l;
    public String m;
    public String n;
    public int o;
    public String p;

    @Override // ca.da.ca.ia.b
    public int a(Cursor cursor) {
        super.a(cursor);
        this.n = cursor.getString(9);
        this.m = cursor.getString(10);
        this.l = cursor.getLong(11);
        this.o = cursor.getInt(12);
        this.p = cursor.getString(13);
        return 14;
    }

    @Override // ca.da.ca.ia.b
    public List<String> b() {
        List<String> listB = super.b();
        ArrayList arrayList = new ArrayList(listB.size());
        arrayList.addAll(listB);
        arrayList.addAll(Arrays.asList("page_key", "varchar", "refer_page_key", "varchar", "duration", TypedValues.Custom.S_INT, "is_back", TypedValues.Custom.S_INT, "last_session", "varchar"));
        return arrayList;
    }

    @Override // ca.da.ca.ia.b
    public String d() {
        return this.n + ", " + this.l;
    }

    @Override // ca.da.ca.ia.b
    public String e() {
        return "page";
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
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, "bav2b_page");
        jSONObject.put("is_bav", 1);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("page_key", this.n);
        jSONObject2.put("refer_page_key", this.m);
        jSONObject2.put("is_back", this.o);
        jSONObject2.put("duration", this.l);
        jSONObject.put("params", jSONObject2);
        jSONObject.put("datetime", this.j);
        return jSONObject;
    }

    public boolean h() {
        return this.l == -1;
    }

    @Override // ca.da.ca.ia.b
    public void b(ContentValues contentValues) {
        super.b(contentValues);
        contentValues.put("page_key", this.n);
        contentValues.put("refer_page_key", this.m);
        contentValues.put("duration", Long.valueOf(this.l));
        contentValues.put("is_back", Integer.valueOf(this.o));
        contentValues.put("last_session", this.p);
    }

    @Override // ca.da.ca.ia.b
    public b a(JSONObject jSONObject) {
        super.a(jSONObject);
        this.n = jSONObject.optString("page_key", null);
        this.m = jSONObject.optString("refer_page_key", null);
        this.l = jSONObject.optLong("duration", 0L);
        this.o = jSONObject.optInt("is_back", 0);
        return this;
    }
}
