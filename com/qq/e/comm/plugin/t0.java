package com.qq.e.comm.plugin;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.qq.e.comm.plugin.aw;
import com.qq.e.comm.plugin.s20;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class t0 implements aw {
    private int c;
    private int d;
    private String e;
    private aw.a j;
    private s20.h m;
    private int n;
    private Map<String, String> p;
    private byte[] q;
    private String r;
    private boolean a = true;
    private boolean b = true;
    private Map<String, String> f = new HashMap();
    private Map<String, String> g = new HashMap();
    private Map<String, String> h = Collections.unmodifiableMap(this.f);
    private Map<String, String> i = Collections.unmodifiableMap(this.g);
    private boolean k = false;
    private boolean l = false;
    private boolean o = true;

    public t0(String str, aw.a aVar, byte[] bArr) {
        this.e = str;
        this.j = aVar;
        if (bArr == null) {
            this.q = null;
        } else {
            this.q = (byte[]) bArr.clone();
        }
    }

    @Override // com.qq.e.comm.plugin.aw
    public byte[] c() throws Exception {
        return this.q;
    }

    @Override // com.qq.e.comm.plugin.aw
    public String f() {
        return this.r;
    }

    @Override // com.qq.e.comm.plugin.aw
    public aw.a o() {
        return this.j;
    }

    @Override // com.qq.e.comm.plugin.aw
    public String e() {
        return this.e;
    }

    @Override // com.qq.e.comm.plugin.aw
    public Map<String, String> q() {
        return this.h;
    }

    @Override // com.qq.e.comm.plugin.aw
    public Map<String, String> i() {
        return this.i;
    }

    @Override // com.qq.e.comm.plugin.aw
    public void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f.put(str, str2);
    }

    public t0(String str, Map<String, String> map, aw.a aVar) throws UnsupportedEncodingException {
        this.e = str;
        this.j = aVar;
        if (aw.a.POST == aVar) {
            StringBuilder sb = new StringBuilder();
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String strEncode = URLEncoder.encode(entry.getKey(), "UTF-8");
                    String strEncode2 = URLEncoder.encode(entry.getValue(), "UTF-8");
                    if (sb.length() > 0) {
                        sb.append(com.alipay.sdk.m.s.a.n);
                    }
                    sb.append(strEncode);
                    sb.append("=");
                    sb.append(strEncode2);
                }
                if (sb.length() > 0) {
                    a(sb.toString());
                }
            } catch (UnsupportedEncodingException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.aw
    public void a(String str, String str2) {
        this.g.put(str, str2);
    }

    @Override // com.qq.e.comm.plugin.aw
    public String h() {
        if (i().isEmpty()) {
            return e();
        }
        Uri.Builder builderBuildUpon = Uri.parse(e()).buildUpon();
        for (Map.Entry<String, String> entry : i().entrySet()) {
            builderBuildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return builderBuildUpon.build().toString();
    }

    @Override // com.qq.e.comm.plugin.aw
    public int g() {
        return this.c;
    }

    @Override // com.qq.e.comm.plugin.aw
    public boolean j() {
        return this.b;
    }

    @Override // com.qq.e.comm.plugin.aw
    public boolean n() {
        return this.a;
    }

    @Override // com.qq.e.comm.plugin.aw
    public boolean k() {
        return this.l;
    }

    @Override // com.qq.e.comm.plugin.aw
    public s20.h m() {
        return this.m;
    }

    @Override // com.qq.e.comm.plugin.aw
    public int l() {
        return this.n;
    }

    @Override // com.qq.e.comm.plugin.aw
    public Map<String, String> p() {
        return this.p;
    }

    @Override // com.qq.e.comm.plugin.aw
    public boolean d() {
        return this.o;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((o() == aw.a.GET ? "get " : "post ").concat("url, "));
        sb.append(h());
        if (o() == aw.a.POST) {
            try {
                sb.append(" , " + URLDecoder.decode(new String(this.q, d6.a)));
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return sb.toString();
    }

    @Override // com.qq.e.comm.plugin.aw
    public void c(boolean z) {
        this.b = z;
    }

    @Override // com.qq.e.comm.plugin.aw
    public int b() {
        return this.d;
    }

    @Override // com.qq.e.comm.plugin.aw
    public void e(boolean z) {
        this.k = z;
    }

    @Override // com.qq.e.comm.plugin.aw
    public boolean a() {
        return this.k;
    }

    @Override // com.qq.e.comm.plugin.aw
    public void d(boolean z) {
        this.o = z;
    }

    @Override // com.qq.e.comm.plugin.aw
    public void b(boolean z) {
        this.a = z;
    }

    @Override // com.qq.e.comm.plugin.aw
    public void a(int i) {
        this.n = i;
    }

    @Override // com.qq.e.comm.plugin.aw
    public void a(boolean z) {
        this.l = z;
    }

    public final void a(String str) {
        this.r = str;
        this.q = str.getBytes(d6.a);
        b("Content-Type", MediaTypeUtils.APPLICATION_FORM);
    }

    @Override // com.qq.e.comm.plugin.aw
    public void a(s20.h hVar) {
        this.m = hVar;
    }

    @Override // com.qq.e.comm.plugin.aw
    public void a(Map<String, String> map) {
        this.p = map;
    }
}
