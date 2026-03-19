package com.android.gdt.qone.ag;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class q {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;

    public static boolean b(String str, String str2) {
        if (str2 == null) {
            return true;
        }
        return (str == null || str2.equals(str)) ? false : true;
    }

    public final String a(int i) {
        switch (i) {
            case 1:
                return this.a;
            case 2:
                return this.b;
            case 3:
                return this.c;
            case 4:
                return this.d;
            case 5:
                return this.e;
            case 6:
                return this.f;
            case 7:
                return this.g;
            case 8:
                return this.h;
            case 9:
                return this.i;
            case 10:
                return this.j;
            case 11:
                return this.k;
            default:
                return null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q.class != obj.getClass()) {
            return false;
        }
        q qVar = (q) obj;
        return a(this.a, qVar.a) && a(this.b, qVar.b) && a(this.c, qVar.c) && a(this.d, qVar.d) && a(this.e, qVar.e) && a(this.f, qVar.f) && a(this.g, qVar.g) && a(this.h, qVar.h) && a(this.i, qVar.i) && a(this.j, qVar.j) && a(this.k, qVar.k);
    }

    public final boolean a(int i, String str) {
        boolean z = true;
        switch (i) {
            case 1:
                if (!b(this.a, str)) {
                    this.a = str;
                }
                return z;
            case 2:
                if (!b(this.b, str)) {
                    this.b = str;
                }
                return z;
            case 3:
                if (!b(this.c, str)) {
                    this.c = str;
                }
                return z;
            case 4:
                if (!b(this.d, str)) {
                    this.d = str;
                }
                return z;
            case 5:
                if (!b(this.e, str)) {
                    this.e = str;
                }
                return z;
            case 6:
                if (!b(this.f, str)) {
                    this.f = str;
                }
                return z;
            case 7:
                if (!b(this.g, str)) {
                    this.g = str;
                }
                return z;
            case 8:
                if (!b(this.h, str)) {
                    this.h = str;
                }
                return z;
            case 9:
                if (!b(this.i, str)) {
                    this.i = str;
                }
                return z;
            case 10:
                if (!b(this.j, str)) {
                    this.j = str;
                }
                return z;
            case 11:
                if (!b(this.k, str)) {
                    this.k = str;
                }
                return z;
            default:
                return false;
        }
        z = false;
        return z;
    }

    public static boolean a(String str, String str2) {
        if (str2 == null) {
            return str == null;
        }
        return str2.equals(str);
    }
}
