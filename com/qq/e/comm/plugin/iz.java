package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class iz {
    private final char a;
    private final float b;
    private Integer c;
    private Integer d;

    iz(Object obj) throws NumberFormatException {
        if (obj instanceof Number) {
            this.b = ((Number) obj).floatValue();
            this.a = (char) 0;
            return;
        }
        float f = 0.0f;
        if (!(obj instanceof String)) {
            this.b = 0.0f;
            this.a = (char) 0;
            return;
        }
        String str = (String) obj;
        int length = str.length();
        if (length < 2) {
            this.b = 0.0f;
            this.a = (char) 0;
            return;
        }
        int i = length - 1;
        char cCharAt = str.charAt(i);
        if (cCharAt >= 'a' && cCharAt <= 'h') {
            this.a = cCharAt;
            try {
                f = Float.parseFloat(str.substring(0, i));
            } catch (Exception unused) {
            }
            this.b = f;
        } else {
            try {
                f = Float.parseFloat(str);
            } catch (Exception unused2) {
            }
            this.b = f;
            this.a = (char) 0;
        }
    }

    public int e() {
        float f = this.b;
        if (f == 0.0f) {
            return 0;
        }
        switch (this.a) {
            case 'b':
                if (zu.d()) {
                    Integer numValueOf = this.c;
                    if (numValueOf == null) {
                        numValueOf = Integer.valueOf(a(zu.c()));
                        this.c = numValueOf;
                    }
                    break;
                } else {
                    Integer numValueOf2 = this.d;
                    if (numValueOf2 == null) {
                        numValueOf2 = Integer.valueOf(a(zu.c()));
                        this.d = numValueOf2;
                    }
                    break;
                }
            case 'c':
                if (zu.d()) {
                    Integer numValueOf3 = this.c;
                    if (numValueOf3 == null) {
                        numValueOf3 = Integer.valueOf(a(zu.b()));
                        this.c = numValueOf3;
                    }
                    break;
                } else {
                    Integer numValueOf4 = this.d;
                    if (numValueOf4 == null) {
                        numValueOf4 = Integer.valueOf(a(zu.b()));
                        this.d = numValueOf4;
                    }
                    break;
                }
            case 'd':
                break;
            case 'e':
            case 'f':
                break;
            default:
                Integer numValueOf5 = this.c;
                if (numValueOf5 == null) {
                    numValueOf5 = Integer.valueOf(zu.a(f));
                    this.c = numValueOf5;
                }
                break;
        }
        return 0;
    }

    public float b() {
        return this.b;
    }

    public boolean c() {
        char c = this.a;
        return c == 'f' || c == 'e';
    }

    public boolean d() {
        char c = this.a;
        return c == 'g' || c == 'h';
    }

    private int a(int i) {
        if (i == 0) {
            return 0;
        }
        double d = (this.b * i) / 100.0f;
        Double.isNaN(d);
        return (int) (d + 0.5d);
    }

    public boolean a() {
        char c = this.a;
        return c == 'e' || c == 'b';
    }

    public int a(int i, int i2) {
        if (this.b == 0.0f) {
            return 0;
        }
        char c = this.a;
        if (c == 'e') {
            return a(i);
        }
        if (c == 'f') {
            return a(i2);
        }
        return e();
    }

    public int a(r8 r8Var) {
        if (this.b == 0.0f) {
            return 0;
        }
        char c = this.a;
        if (c == 'g') {
            return a(r8Var.d());
        }
        if (c == 'h') {
            return a(r8Var.c());
        }
        return a(r8Var.b(), r8Var.a());
    }
}
