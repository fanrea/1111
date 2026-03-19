package com.bytedance.embedapplog;

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
public class dz extends to {
    public int cb;
    public String e;
    public boolean jh;
    public boolean k;
    public int mq;
    public boolean rf;
    public String uo;
    public String w;
    public String yo;

    @Override // com.bytedance.embedapplog.to
    String c() {
        return Config.LAUNCH;
    }

    public dz(boolean z) {
        this.jh = z;
    }

    @Override // com.bytedance.embedapplog.to
    protected List<String> d() {
        List<String> listD = super.d();
        ArrayList arrayList = new ArrayList(listD.size());
        arrayList.addAll(listD);
        arrayList.addAll(Arrays.asList("ver_name", "varchar", "ver_code", TypedValues.Custom.S_INT, "last_session", "varchar", "is_first_time", TypedValues.Custom.S_INT, ArticleInfo.PAGE_TITLE, "varchar", "page_key", "varchar", "resume_from_background", TypedValues.Custom.S_INT));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.to
    public int d(Cursor cursor) {
        int iD = super.d(cursor);
        int i = iD + 1;
        this.uo = cursor.getString(iD);
        int i2 = i + 1;
        this.mq = cursor.getInt(i);
        int i3 = i2 + 1;
        this.e = cursor.getString(i2);
        int i4 = i3 + 1;
        this.cb = cursor.getInt(i3);
        int i5 = i4 + 1;
        this.w = cursor.getString(i4);
        int i6 = i5 + 1;
        this.yo = cursor.getString(i5);
        int i7 = i6 + 1;
        this.rf = cursor.getInt(i6) == 0;
        return i7;
    }

    @Override // com.bytedance.embedapplog.to
    protected void d(ContentValues contentValues) {
        super.d(contentValues);
        contentValues.put("ver_name", this.uo);
        contentValues.put("ver_code", Integer.valueOf(this.mq));
        contentValues.put("last_session", this.e);
        contentValues.put("is_first_time", Integer.valueOf(this.cb));
        contentValues.put(ArticleInfo.PAGE_TITLE, this.w);
        contentValues.put("page_key", this.yo);
        contentValues.put("resume_from_background", Integer.valueOf(this.rf ? 1 : 0));
    }

    @Override // com.bytedance.embedapplog.to
    protected void d(JSONObject jSONObject) {
        um.hc((Throwable) null);
    }

    @Override // com.bytedance.embedapplog.to
    protected JSONObject hc() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.hc);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("session_id", this.c);
        if (this.u > 0) {
            jSONObject.put("user_id", this.u);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.an) ? JSONObject.NULL : this.an);
        if (!TextUtils.isEmpty(this.h)) {
            jSONObject.put("ssid", this.h);
        }
        boolean z = this.k;
        if (z) {
            jSONObject.put("is_background", z);
        }
        jSONObject.put("datetime", this.mk);
        if (!TextUtils.isEmpty(this.gb)) {
            jSONObject.put("ab_sdk_version", this.gb);
        }
        if (!TextUtils.isEmpty(this.e)) {
            jSONObject.put("uuid_changed", true);
            jSONObject.put("original_session_id", this.e);
        }
        if (this.cb == 1) {
            jSONObject.put("$is_first_time", "true");
        }
        jSONObject.put("$resume_from_background", !this.jh);
        jSONObject.put("is_background", !this.jh);
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.to
    protected to hc(JSONObject jSONObject) {
        um.hc((Throwable) null);
        return null;
    }

    @Override // com.bytedance.embedapplog.to
    protected String gb() {
        return this.k ? "bg" : "fg";
    }
}
