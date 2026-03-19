package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.io.File;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class gb {
    private final String a;
    private final File b;
    private final String c;
    private final boolean d;
    private boolean e;
    private boolean f;
    private String g;
    private long h;
    private double i;
    private String j;
    private f5 k;
    private boolean l;

    private gb(File file, String str, String str2, boolean z) {
        this.e = true;
        this.f = false;
        this.h = 0L;
        this.b = file;
        this.c = str;
        this.a = str2;
        this.d = z;
    }

    public String f() {
        return this.j;
    }

    public String d() {
        return this.c;
    }

    public String g() {
        return this.a;
    }

    public boolean k() {
        return this.d;
    }

    public boolean i() {
        return this.e;
    }

    public boolean j() {
        return this.f;
    }

    public File b() {
        return this.b;
    }

    public String e() {
        if (TextUtils.isEmpty(this.g)) {
            return this.a;
        }
        return this.g;
    }

    public double c() {
        return this.i;
    }

    public boolean h() {
        return this.l;
    }

    /* compiled from: A */
    public static class b {
        private String a;
        private File b;
        private String c;
        private String g;
        private long h;
        private String j;
        private f5 k;
        private boolean d = true;
        private boolean e = true;
        private boolean f = false;
        private double i = 1.0d;
        private boolean l = true;

        public b d(String str) {
            this.a = str;
            return this;
        }

        public b c(boolean z) {
            this.f = z;
            return this;
        }

        public b b(boolean z) {
            this.e = z;
            return this;
        }

        public gb a() {
            gb gbVar = new gb(this.b, this.c, this.a, this.d);
            gbVar.f = this.f;
            gbVar.e = this.e;
            gbVar.g = this.g;
            gbVar.h = this.h;
            gbVar.i = this.i;
            gbVar.j = this.j;
            gbVar.k = this.k;
            gbVar.l = this.l || this.d;
            return gbVar;
        }

        public b c(String str) {
            this.j = str;
            return this;
        }

        public b d(boolean z) {
            this.d = z;
            return this;
        }

        public b b(String str) {
            this.g = str;
            return this;
        }

        public b a(boolean z) {
            this.l = z;
            return this;
        }

        public b a(f5 f5Var) {
            this.k = f5Var;
            return this;
        }

        public b a(File file) {
            this.b = file;
            return this;
        }

        public b a(double d) {
            if (d <= 0.0d || d > 1.0d) {
                d = 1.0d;
            }
            this.i = d;
            return this;
        }

        public b a(String str) {
            this.c = str;
            return this;
        }
    }

    public f5 a() {
        return this.k;
    }
}
