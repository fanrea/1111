package com.bytedance.bdtracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.bytedance.bdtracker.l0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d4 extends t3 {
    public int A;
    public String B;
    public boolean C;
    public boolean D;
    public Class<?> E;
    public long s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public long z;

    @Override // com.bytedance.bdtracker.t3
    public int a(Cursor cursor) {
        super.a(cursor);
        this.u = cursor.getString(14);
        this.t = cursor.getString(15);
        this.s = cursor.getLong(16);
        this.A = cursor.getInt(17);
        this.B = cursor.getString(18);
        this.v = cursor.getString(19);
        this.w = cursor.getString(20);
        this.x = cursor.getString(21);
        this.y = cursor.getString(22);
        this.C = cursor.getInt(23) == 1;
        this.D = cursor.getInt(24) == 1;
        this.z = cursor.getLong(25);
        return 26;
    }

    @Override // com.bytedance.bdtracker.t3
    public t3 a(JSONObject jSONObject) {
        super.a(jSONObject);
        this.u = jSONObject.optString("page_key", "");
        this.t = jSONObject.optString("refer_page_key", null);
        this.s = jSONObject.optLong("duration", 0L);
        this.A = jSONObject.optInt("is_back", 0);
        this.v = jSONObject.optString(ArticleInfo.PAGE_TITLE, "");
        this.w = jSONObject.optString("refer_page_title", null);
        this.x = jSONObject.optString("page_path", null);
        this.y = jSONObject.optString("referrer_page_path", null);
        this.C = jSONObject.optBoolean("is_custom", false);
        this.D = jSONObject.optBoolean("is_fragment", false);
        this.z = jSONObject.optLong("resume_at", 0L);
        return this;
    }

    @Override // com.bytedance.bdtracker.t3
    public List<String> b() {
        List<String> listB = super.b();
        ArrayList arrayList = new ArrayList(listB.size());
        arrayList.addAll(listB);
        arrayList.addAll(Arrays.asList("page_key", "varchar", "refer_page_key", "varchar", "duration", TypedValues.Custom.S_INT, "is_back", TypedValues.Custom.S_INT, "last_session", "varchar", ArticleInfo.PAGE_TITLE, "varchar", "refer_page_title", "varchar", "page_path", "varchar", "referrer_page_path", "varchar", "is_custom", TypedValues.Custom.S_INT, "is_fragment", TypedValues.Custom.S_INT, "resume_at", TypedValues.Custom.S_INT));
        return arrayList;
    }

    @Override // com.bytedance.bdtracker.t3
    public void b(ContentValues contentValues) {
        super.b(contentValues);
        contentValues.put("page_key", l0.b.a((Object) this.u));
        contentValues.put("refer_page_key", this.t);
        contentValues.put("duration", Long.valueOf(this.s));
        contentValues.put("is_back", Integer.valueOf(this.A));
        contentValues.put("last_session", this.B);
        contentValues.put(ArticleInfo.PAGE_TITLE, this.v);
        contentValues.put("refer_page_title", this.w);
        contentValues.put("page_path", this.x);
        contentValues.put("referrer_page_path", this.y);
        contentValues.put("is_custom", Integer.valueOf(this.C ? 1 : 0));
        contentValues.put("is_fragment", Integer.valueOf(this.D ? 1 : 0));
        long j = this.z;
        if (j <= 0) {
            j = this.c;
        }
        contentValues.put("resume_at", Long.valueOf(j));
    }

    @Override // com.bytedance.bdtracker.t3
    public String c() {
        return l0.b.a((Object) this.u) + ", " + this.s;
    }

    @Override // com.bytedance.bdtracker.t3
    public String f() {
        return "page";
    }

    @Override // com.bytedance.bdtracker.t3
    public JSONObject i() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        long j = this.z;
        if (j <= 0) {
            j = this.c;
        }
        jSONObject.put("local_time_ms", j);
        jSONObject.put("datetime", t3.b(j));
        jSONObject.put("tea_event_index", this.d);
        jSONObject.put("session_id", this.e);
        long j2 = this.f;
        if (j2 > 0) {
            jSONObject.put("user_id", j2);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.g) ? JSONObject.NULL : this.g);
        if (!TextUtils.isEmpty(this.h)) {
            jSONObject.put("$user_unique_id_type", this.h);
        }
        if (!TextUtils.isEmpty(this.i)) {
            jSONObject.put("ssid", this.i);
        }
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, "bav2b_page");
        jSONObject.put("is_bav", 1);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("page_key", l0.b.a((Object) this.u));
        jSONObject2.put("refer_page_key", this.t);
        jSONObject2.put("is_back", this.A);
        jSONObject2.put("duration", this.s);
        jSONObject2.put(ArticleInfo.PAGE_TITLE, this.v);
        jSONObject2.put("refer_page_title", this.w);
        jSONObject2.put("page_path", this.x);
        jSONObject2.put("referrer_page_path", this.y);
        a(jSONObject, jSONObject2);
        return jSONObject;
    }

    public boolean k() {
        return this.s == -1;
    }

    @Override // com.bytedance.bdtracker.t3
    public void b(JSONObject jSONObject) throws JSONException {
        super.b(jSONObject);
        jSONObject.put("page_key", l0.b.a((Object) this.u));
        jSONObject.put("refer_page_key", this.t);
        jSONObject.put("duration", this.s);
        jSONObject.put("is_back", this.A);
        jSONObject.put(ArticleInfo.PAGE_TITLE, this.v);
        jSONObject.put("refer_page_title", this.w);
        jSONObject.put("page_path", this.x);
        jSONObject.put("referrer_page_path", this.y);
        jSONObject.put("is_custom", this.C);
        jSONObject.put("is_fragment", this.D);
        jSONObject.put("resume_at", this.z);
    }
}
