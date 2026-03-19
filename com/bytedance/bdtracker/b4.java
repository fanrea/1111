package com.bytedance.bdtracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.baidu.mobstat.forbes.Config;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b4 extends t3 {
    public int s;
    public String t;
    public boolean u;
    public String v;
    public int w;
    public String x;
    public String y;
    public boolean z;

    @Override // com.bytedance.bdtracker.t3
    public int a(Cursor cursor) {
        super.a(cursor);
        this.t = cursor.getString(14);
        this.s = cursor.getInt(15);
        this.v = cursor.getString(16);
        this.w = cursor.getInt(17);
        this.x = cursor.getString(18);
        this.y = cursor.getString(19);
        this.z = cursor.getInt(20) == 1;
        return 21;
    }

    @Override // com.bytedance.bdtracker.t3
    public t3 a(JSONObject jSONObject) {
        d().error(4, this.a, "Not allowed", new Object[0]);
        return null;
    }

    @Override // com.bytedance.bdtracker.t3
    public List<String> b() {
        List<String> listB = super.b();
        ArrayList arrayList = new ArrayList(listB.size());
        arrayList.addAll(listB);
        arrayList.addAll(Arrays.asList("ver_name", "varchar", "ver_code", TypedValues.Custom.S_INT, "last_session", "varchar", "is_first_time", TypedValues.Custom.S_INT, ArticleInfo.PAGE_TITLE, "varchar", "page_key", "varchar", "resume_from_background", TypedValues.Custom.S_INT));
        return arrayList;
    }

    @Override // com.bytedance.bdtracker.t3
    public void b(ContentValues contentValues) {
        super.b(contentValues);
        contentValues.put("ver_name", this.t);
        contentValues.put("ver_code", Integer.valueOf(this.s));
        contentValues.put("last_session", this.v);
        contentValues.put("is_first_time", Integer.valueOf(this.w));
        contentValues.put(ArticleInfo.PAGE_TITLE, this.x);
        contentValues.put("page_key", this.y);
        contentValues.put("resume_from_background", Integer.valueOf(this.z ? 1 : 0));
    }

    @Override // com.bytedance.bdtracker.t3
    public void b(JSONObject jSONObject) {
        d().error(4, this.a, "Not allowed", new Object[0]);
    }

    @Override // com.bytedance.bdtracker.t3
    public String c() {
        return this.u ? "bg" : "fg";
    }

    @Override // com.bytedance.bdtracker.t3
    public String f() {
        return Config.LAUNCH;
    }

    @Override // com.bytedance.bdtracker.t3
    public JSONObject i() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.c);
        jSONObject.put("tea_event_index", this.d);
        jSONObject.put("session_id", this.e);
        long j = this.f;
        if (j > 0) {
            jSONObject.put("user_id", j);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.g) ? JSONObject.NULL : this.g);
        if (!TextUtils.isEmpty(this.h)) {
            jSONObject.put("$user_unique_id_type", this.h);
        }
        if (!TextUtils.isEmpty(this.i)) {
            jSONObject.put("ssid", this.i);
        }
        boolean z = this.u;
        if (z) {
            jSONObject.put("is_background", z);
        }
        jSONObject.put("datetime", this.n);
        if (!TextUtils.isEmpty(this.j)) {
            jSONObject.put("ab_sdk_version", this.j);
        }
        d dVarA = b.a(this.m);
        if (dVarA != null) {
            String deepLinkUrl = dVarA.getDeepLinkUrl();
            if (!TextUtils.isEmpty(deepLinkUrl)) {
                jSONObject.put("$deeplink_url", deepLinkUrl);
            }
        }
        if (!TextUtils.isEmpty(this.v)) {
            jSONObject.put("uuid_changed", true);
            jSONObject.put("original_session_id", this.v);
        }
        if (this.w == 1) {
            jSONObject.put("$is_first_time", "true");
        }
        jSONObject.put("$page_title", TextUtils.isEmpty(this.x) ? "" : this.x);
        jSONObject.put("$page_key", TextUtils.isEmpty(this.y) ? "" : this.y);
        jSONObject.put("$resume_from_background", this.z ? "true" : "false");
        a(jSONObject, "");
        return jSONObject;
    }
}
