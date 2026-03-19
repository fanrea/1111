package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.baidu.mobads.sdk.api.ArticleInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class i extends to {
    public String cb;
    public String e;
    public String jh;
    public String k;
    public long mq;
    public int rf;
    public String uo;
    public String w;
    public String yo;

    @Override // com.bytedance.embedapplog.to
    String c() {
        return "page";
    }

    @Override // com.bytedance.embedapplog.to
    protected List<String> d() {
        List<String> listD = super.d();
        ArrayList arrayList = new ArrayList(listD.size());
        arrayList.addAll(listD);
        arrayList.addAll(Arrays.asList("page_key", "varchar", "refer_page_key", "varchar", "duration", TypedValues.Custom.S_INT, "is_back", TypedValues.Custom.S_INT, "last_session", "varchar", ArticleInfo.PAGE_TITLE, "varchar", "refer_page_title", "varchar", "page_path", "varchar", "referrer_page_path", "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.to
    public int d(Cursor cursor) {
        int iD = super.d(cursor);
        int i = iD + 1;
        this.k = cursor.getString(iD);
        int i2 = i + 1;
        this.uo = cursor.getString(i);
        int i3 = i2 + 1;
        this.mq = cursor.getLong(i2);
        int i4 = i3 + 1;
        this.rf = cursor.getInt(i3);
        int i5 = i4 + 1;
        this.jh = cursor.getString(i4);
        int i6 = i5 + 1;
        this.e = cursor.getString(i5);
        int i7 = i6 + 1;
        this.cb = cursor.getString(i6);
        int i8 = i7 + 1;
        this.w = cursor.getString(i7);
        int i9 = i8 + 1;
        this.yo = cursor.getString(i8);
        return i9;
    }

    @Override // com.bytedance.embedapplog.to
    protected void d(ContentValues contentValues) {
        super.d(contentValues);
        contentValues.put("page_key", this.k);
        contentValues.put("refer_page_key", this.uo);
        contentValues.put("duration", Long.valueOf(this.mq));
        contentValues.put("is_back", Integer.valueOf(this.rf));
        contentValues.put("last_session", this.jh);
        contentValues.put(ArticleInfo.PAGE_TITLE, this.e);
        contentValues.put("refer_page_title", this.cb);
        contentValues.put("page_path", this.w);
        contentValues.put("referrer_page_path", this.yo);
    }

    @Override // com.bytedance.embedapplog.to
    protected void d(JSONObject jSONObject) throws JSONException {
        super.d(jSONObject);
        jSONObject.put("page_key", this.k);
        jSONObject.put("refer_page_key", this.uo);
        jSONObject.put("duration", this.mq);
        jSONObject.put("is_back", this.rf);
        jSONObject.put(ArticleInfo.PAGE_TITLE, this.e);
        jSONObject.put("refer_page_title", this.cb);
        jSONObject.put("page_path", this.w);
        jSONObject.put("referrer_page_path", this.yo);
    }

    @Override // com.bytedance.embedapplog.to
    protected to hc(JSONObject jSONObject) {
        super.hc(jSONObject);
        this.k = jSONObject.optString("page_key", null);
        this.uo = jSONObject.optString("refer_page_key", null);
        this.mq = jSONObject.optLong("duration", 0L);
        this.rf = jSONObject.optInt("is_back", 0);
        this.e = jSONObject.optString(ArticleInfo.PAGE_TITLE, null);
        this.cb = jSONObject.optString("refer_page_title", null);
        this.w = jSONObject.optString("page_path", null);
        this.yo = jSONObject.optString("referrer_page_path", null);
        return this;
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
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, "bav2b_page");
        jSONObject.put("is_bav", 1);
        jSONObject.put("params", mq());
        jSONObject.put("datetime", this.mk);
        return jSONObject;
    }

    private JSONObject mq() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("page_key", this.k);
        jSONObject.put("refer_page_key", this.uo);
        jSONObject.put("is_back", this.rf);
        jSONObject.put("duration", this.mq);
        jSONObject.put(ArticleInfo.PAGE_TITLE, this.e);
        jSONObject.put("refer_page_title", this.cb);
        jSONObject.put("page_path", this.w);
        jSONObject.put("referrer_page_path", this.yo);
        return jSONObject;
    }

    public boolean tc() {
        return this.mq == -1;
    }

    public boolean mk() {
        return this.k.contains(":");
    }

    @Override // com.bytedance.embedapplog.to
    protected String gb() {
        return this.k + ", " + this.mq;
    }
}
