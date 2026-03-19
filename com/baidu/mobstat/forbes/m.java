package com.baidu.mobstat.forbes;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class m {
    private static final m d = new m();
    private boolean a = false;
    private float b = 50.0f;
    private long c = 500;

    public static m a() {
        return d;
    }

    public boolean b() {
        return this.a;
    }

    public float c() {
        float f = this.b;
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 100.0f) {
            f = 100.0f;
        }
        return f / 100.0f;
    }

    public long d() {
        return this.c;
    }
}
