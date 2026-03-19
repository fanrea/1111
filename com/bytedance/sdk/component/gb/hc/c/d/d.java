package com.bytedance.sdk.component.gb.hc.c.d;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.mq;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d implements com.bytedance.sdk.component.gb.d.hc {
    private long an;
    private byte b;
    private byte c;
    protected JSONObject d;
    private String gb;
    private long h;
    private hc hc;
    private String mk;
    private int mq;
    private byte tc;
    private String tt;
    private long u;

    public d(String str, JSONObject jSONObject) {
        this.tt = str;
        this.d = jSONObject;
    }

    public d(String str, hc hcVar) {
        this.tt = str;
        this.hc = hcVar;
    }

    @Override // com.bytedance.sdk.component.gb.d.hc
    public hc d() {
        return this.hc;
    }

    private d() {
    }

    public void b(String str) {
        this.mk = str;
    }

    public String tc() {
        return this.mk;
    }

    @Override // com.bytedance.sdk.component.gb.d.hc
    public synchronized JSONObject h() {
        hc hcVar;
        if (this.d == null && (hcVar = this.hc) != null) {
            this.d = hcVar.d(tc());
        }
        return this.d;
    }

    @Override // com.bytedance.sdk.component.gb.d.hc
    public void d(JSONObject jSONObject) {
        this.d = jSONObject;
    }

    public static com.bytedance.sdk.component.gb.d.hc c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("type");
            int iOptInt2 = jSONObject.optInt("priority");
            d dVar = new d();
            dVar.d((byte) iOptInt);
            dVar.hc((byte) iOptInt2);
            dVar.d(jSONObject.optJSONObject(NotificationCompat.CATEGORY_EVENT));
            dVar.d(jSONObject.optString("localId"));
            dVar.hc(jSONObject.optString("genTime"));
            dVar.d(jSONObject.optInt("channel"));
            return dVar;
        } catch (JSONException e) {
            mq.d(e);
            return null;
        }
    }

    public void b(byte b) {
        this.tc = b;
    }

    @Override // com.bytedance.sdk.component.gb.d.hc
    public byte hc() {
        return this.tc;
    }

    @Override // com.bytedance.sdk.component.gb.d.hc
    public String b() {
        return this.tt;
    }

    @Override // com.bytedance.sdk.component.gb.d.hc
    public byte c() {
        return this.b;
    }

    @Override // com.bytedance.sdk.component.gb.d.hc
    public void d(byte b) {
        this.b = b;
    }

    @Override // com.bytedance.sdk.component.gb.d.hc
    public void d(String str) {
        this.tt = str;
    }

    @Override // com.bytedance.sdk.component.gb.d.hc
    public void hc(String str) {
        this.gb = str;
    }

    @Override // com.bytedance.sdk.component.gb.d.hc
    public void d(long j) {
        this.u = j;
    }

    @Override // com.bytedance.sdk.component.gb.d.hc
    public long gb() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.gb.d.hc
    public void hc(long j) {
        this.an = j;
    }

    @Override // com.bytedance.sdk.component.gb.d.hc
    public long tt() {
        return this.an;
    }

    @Override // com.bytedance.sdk.component.gb.d.hc
    public void b(long j) {
        this.h = j;
    }

    @Override // com.bytedance.sdk.component.gb.d.hc
    public void d(int i) {
        this.mq = i;
    }

    public String mk() {
        return this.gb;
    }

    @Override // com.bytedance.sdk.component.gb.d.hc
    public void hc(byte b) {
        this.c = b;
    }

    @Override // com.bytedance.sdk.component.gb.d.hc
    public byte u() {
        return this.c;
    }

    @Override // com.bytedance.sdk.component.gb.d.hc
    public String an() {
        if (TextUtils.isEmpty(this.tt)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("localId", this.tt);
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, h());
            jSONObject.put("genTime", mk());
            jSONObject.put("priority", (int) this.c);
            jSONObject.put("type", (int) this.b);
            jSONObject.put("channel", this.mq);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }
}
