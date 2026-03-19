package ca.da.ca.ia;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import ca.da.ca.ja.r;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: EventMisc.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class f extends b {
    public String l;
    public String m;

    public f(String str, JSONObject jSONObject) {
        this.m = str;
        this.l = jSONObject.toString();
    }

    @Override // ca.da.ca.ia.b
    public int a(Cursor cursor) {
        super.a(cursor);
        this.l = cursor.getString(9);
        this.m = cursor.getString(10);
        return 11;
    }

    @Override // ca.da.ca.ia.b
    public List<String> b() {
        List<String> listB = super.b();
        ArrayList arrayList = new ArrayList(listB.size());
        arrayList.addAll(listB);
        arrayList.addAll(Arrays.asList("params", "varchar", "log_type", "varchar"));
        return arrayList;
    }

    @Override // ca.da.ca.ia.b
    public String c() {
        return this.l;
    }

    @Override // ca.da.ca.ia.b
    public String d() {
        return ca.ca.ca.ca.a.a("param:").append(this.l).append(" logType:").append(this.m).toString();
    }

    @Override // ca.da.ca.ia.b
    public String e() {
        return "event_misc";
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
        jSONObject.put("log_type", this.m);
        try {
            JSONObject jSONObject2 = new JSONObject(this.l);
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject2.get(next);
                if (jSONObject.opt(next) != null) {
                    r.a("misc事件存在重复的key", (Throwable) null);
                }
                jSONObject.put(next, obj);
            }
        } catch (Exception e) {
            r.a("解析 event misc 失败", e);
        }
        return jSONObject;
    }

    @Override // ca.da.ca.ia.b
    public b a(JSONObject jSONObject) {
        super.a(jSONObject);
        this.l = jSONObject.optString("params", null);
        this.m = jSONObject.optString("log_type", null);
        return this;
    }

    @Override // ca.da.ca.ia.b
    public void b(ContentValues contentValues) {
        super.b(contentValues);
        contentValues.put("params", this.l);
        contentValues.put("log_type", this.m);
    }
}
