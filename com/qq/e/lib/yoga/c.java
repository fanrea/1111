package com.qq.e.lib.yoga;

import com.qq.e.comm.plugin.q60;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class c {
    static final c c = new c(Float.NaN, q60.UNDEFINED);
    static final c d = new c(0.0f, q60.POINT);
    static final c e = new c(Float.NaN, q60.AUTO);
    public final float a;
    public final q60 b;

    /* compiled from: A */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[q60.values().length];
            a = iArr;
            try {
                iArr[q60.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[q60.POINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[q60.PERCENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[q60.AUTO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static c a(String str) {
        if (str == null) {
            return null;
        }
        return "undefined".equals(str) ? c : "auto".equals(str) ? e : str.endsWith("%") ? new c(Float.parseFloat(str.substring(0, str.length() - 1)), q60.PERCENT) : new c(Float.parseFloat(str), q60.POINT);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        q60 q60Var = this.b;
        if (q60Var == cVar.b) {
            return q60Var == q60.UNDEFINED || q60Var == q60.AUTO || Float.compare(this.a, cVar.a) == 0;
        }
        return false;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.a) + this.b.b();
    }

    public String toString() {
        int i = a.a[this.b.ordinal()];
        if (i == 1) {
            return "undefined";
        }
        if (i == 2) {
            return Float.toString(this.a);
        }
        if (i != 3) {
            if (i == 4) {
                return "auto";
            }
            throw new IllegalStateException();
        }
        return this.a + "%";
    }

    public c(float f, q60 q60Var) {
        this.a = f;
        this.b = q60Var;
    }

    c(float f, int i) {
        this(f, q60.a(i));
    }
}
