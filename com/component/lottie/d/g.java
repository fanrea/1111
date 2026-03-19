package com.component.lottie.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class g {
    private static final String c = "\r";
    public final float a;
    public final float b;
    private final String d;

    public g(String str, float f, float f2) {
        this.d = str;
        this.b = f2;
        this.a = f;
    }

    public String a() {
        return this.d;
    }

    public float b() {
        return this.a;
    }

    public float c() {
        return this.b;
    }

    public boolean a(String str) {
        if (this.d.equalsIgnoreCase(str)) {
            return true;
        }
        return this.d.endsWith(c) && this.d.substring(0, this.d.length() - 1).equalsIgnoreCase(str);
    }
}
