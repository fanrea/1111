package com.component.lottie;

import android.graphics.Bitmap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ax {
    private final int a;
    private final int b;
    private final String c;
    private final String d;
    private final String e;
    private Bitmap f;

    public ax(int i, int i2, String str, String str2, String str3) {
        this.a = i;
        this.b = i2;
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public Bitmap f() {
        return this.f;
    }

    public void a(Bitmap bitmap) {
        this.f = bitmap;
    }

    public boolean g() {
        return this.f != null || (this.d.startsWith("data:") && this.d.indexOf("base64,") > 0);
    }
}
