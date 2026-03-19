package com.baidu.mobads.container.util.b.a;

import android.text.TextUtils;
import com.baidu.mobads.container.util.d.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b {
    public String a;
    public d.e b;
    public boolean c;
    public String d;
    public String e;
    public long f;
    public long g;
    public int h;
    public int i;
    public String j;
    public boolean k;
    public boolean l;

    private b() {
        this.c = true;
        this.f = -1L;
        this.h = 10000;
        this.i = 10000;
        this.k = false;
        this.l = false;
    }

    public static class a {
        private final String a;
        private final String b;
        private String c;
        private d.e g;
        private long d = -1;
        private boolean e = true;
        private long f = 0;
        private int h = 10000;
        private int i = 10000;
        private boolean j = false;

        public a(String str) {
            this.a = str;
            this.b = com.baidu.mobads.container.util.b.a.b(str);
        }

        public a a(d.e eVar) {
            this.g = eVar;
            return this;
        }

        public a a(boolean z) {
            this.j = z;
            return this;
        }

        public a a(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.g = d.e.CUSTOM;
            }
            this.c = str;
            return this;
        }

        public a a(long j) {
            this.d = j;
            return this;
        }

        public a b(long j) {
            this.f = j;
            return this;
        }

        public a b(boolean z) {
            this.e = z;
            return this;
        }

        public a a(int i) {
            this.h = i;
            return this;
        }

        public a b(int i) {
            this.i = i;
            return this;
        }

        public b a() {
            b bVar = new b();
            bVar.a = this.a;
            bVar.d = this.b;
            bVar.k = this.j;
            bVar.e = this.c;
            bVar.f = this.d;
            bVar.c = this.e;
            bVar.g = this.f;
            if (this.g != null) {
                bVar.b = this.g;
            } else if (com.baidu.mobads.container.util.d.d.k(this.a)) {
                bVar.b = d.e.COMMON;
            } else if (com.baidu.mobads.container.util.d.d.j(this.a)) {
                bVar.b = d.e.VIDEO;
            } else {
                bVar.b = d.e.PICTURE;
            }
            bVar.h = this.h;
            bVar.i = this.i;
            return bVar;
        }
    }
}
