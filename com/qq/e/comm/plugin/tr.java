package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.mediation.interfaces.IBaseAd;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class tr {
    public static String x;
    public static String y;
    public static String z;
    private int a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g;
    private int h;
    private int i = -1;
    private int j = -1;
    private String k;
    private String l;
    private int m;
    private boolean n;
    private boolean o;
    private int p;
    private int q;
    private WeakReference<IBaseAd> r;
    private int s;
    private int t;
    private Integer u;
    private String v;
    private Integer w;

    public String toString() {
        return "name: " + this.b + ", posId: " + this.c + ", price: " + this.h;
    }

    public tr(JSONObject jSONObject, String str, boolean z2, int i, int i2) {
        if (jSONObject == null) {
            return;
        }
        this.a = jSONObject.optInt("adnet_id");
        this.b = jSONObject.optString("name");
        this.c = jSONObject.optString(PointParamKey.PLACEMENT_ID);
        this.d = jSONObject.optString(com.alipay.sdk.m.k.b.D0);
        this.e = jSONObject.optString("class_name");
        this.f = jSONObject.optString("ext");
        this.g = jSONObject.optInt("timeout");
        this.h = jSONObject.optInt("price", -1);
        if (TextUtils.isEmpty(x) && this.a == 103) {
            x = this.d;
        }
        if (TextUtils.isEmpty(z) && this.a == 101) {
            z = this.d;
        }
        if (TextUtils.isEmpty(y) && this.a == 102) {
            y = this.d;
        }
        this.l = str;
        this.o = z2;
        this.p = i;
        this.q = i2;
    }

    public String o() {
        return this.b;
    }

    public String p() {
        return this.c;
    }

    public String e() {
        return this.e;
    }

    public String j() {
        return this.f;
    }

    public int a() {
        return this.a;
    }

    public String b() {
        return this.d;
    }

    public int q() {
        return this.h;
    }

    public int f() {
        return this.i;
    }

    public int r() {
        return this.j;
    }

    public String s() {
        return this.k;
    }

    public String n() {
        return this.l;
    }

    public int m() {
        return this.m;
    }

    public boolean v() {
        return this.n;
    }

    public boolean u() {
        return this.o;
    }

    public int i() {
        return this.p;
    }

    public int k() {
        return this.q;
    }

    public IBaseAd c() {
        WeakReference<IBaseAd> weakReference = this.r;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int t() {
        return this.s;
    }

    public int d() {
        return this.t;
    }

    public Integer g() {
        return this.u;
    }

    public String h() {
        return this.v;
    }

    public Integer l() {
        return this.w;
    }

    public void w() {
        this.m = 0;
        this.n = false;
        this.i = -1;
        this.j = -1;
        this.k = null;
        this.r = null;
        this.t = -1;
        this.s = -1;
        this.u = null;
        this.v = null;
        this.w = null;
    }

    public void b(int i) {
        this.i = i;
    }

    public void e(int i) {
        this.s = i;
    }

    public void a(IBaseAd iBaseAd) {
        this.r = new WeakReference<>(iBaseAd);
    }

    public void d(int i) {
        this.j = i;
    }

    public void c(int i) {
        this.m = i;
    }

    public void b(Integer num) {
        this.w = num;
    }

    public void a(int i) {
        this.t = i;
    }

    public void b(String str) {
        this.k = str;
    }

    public void a(Integer num) {
        this.u = num;
    }

    public void a(String str) {
        this.v = str;
    }

    public void a(boolean z2) {
        this.n = z2;
    }
}
