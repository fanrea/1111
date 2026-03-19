package com.bytedance.sdk.component.hc.d.d.hc;

import android.text.TextUtils;
import com.bytedance.sdk.component.b.hc.zw;
import com.bytedance.sdk.component.hc.d.cb;
import com.bytedance.sdk.component.hc.d.k;
import com.bytedance.sdk.component.hc.d.mk;
import com.bytedance.sdk.component.hc.d.uo;
import com.bytedance.sdk.component.hc.d.w;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an extends cb {
    public long b;
    public long c;
    HttpURLConnection d;
    k hc;
    zw u = null;

    public String toString() {
        return "";
    }

    public an(HttpURLConnection httpURLConnection, k kVar) {
        this.d = httpURLConnection;
        this.hc = kVar;
    }

    @Override // com.bytedance.sdk.component.hc.d.cb
    public long d() {
        return this.b;
    }

    @Override // com.bytedance.sdk.component.hc.d.cb
    public long hc() {
        return this.c;
    }

    @Override // com.bytedance.sdk.component.hc.d.cb
    public int b() {
        try {
            return this.d.getResponseCode();
        } catch (Exception unused) {
            return -1;
        }
    }

    @Override // com.bytedance.sdk.component.hc.d.cb
    public boolean c() {
        return b() >= 200 && b() < 300;
    }

    @Override // com.bytedance.sdk.component.hc.d.cb
    public String u() throws IOException {
        return this.d.getResponseMessage();
    }

    @Override // com.bytedance.sdk.component.hc.d.cb
    public w an() {
        try {
            return new h(this.d);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.hc.d.cb
    public com.bytedance.sdk.component.hc.d.an h() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<String>> entry : this.d.getHeaderFields().entrySet()) {
            for (String str : entry.getValue()) {
                if (!"Content-Range".equalsIgnoreCase(entry.getKey()) || b() != 206) {
                    arrayList.add(entry.getKey());
                    arrayList.add(str);
                }
            }
        }
        return new com.bytedance.sdk.component.hc.d.an((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    @Override // com.bytedance.sdk.component.hc.d.cb
    public String d(String str) {
        return this.d.getHeaderField(str);
    }

    @Override // com.bytedance.sdk.component.hc.d.cb
    public String d(String str, String str2) {
        return !TextUtils.isEmpty(d(str)) ? d(str) : str2;
    }

    @Override // com.bytedance.sdk.component.hc.d.cb, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            an().close();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.hc.d.cb
    public uo gb() {
        return uo.HTTP_1_1;
    }

    @Override // com.bytedance.sdk.component.hc.d.cb
    public mk tt() {
        return new mk(this.u);
    }
}
