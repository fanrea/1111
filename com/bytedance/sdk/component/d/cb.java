package com.bytedance.sdk.component.d;

import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class cb {
    public final String an;
    public final String b;
    public final String c;
    public final int d;
    public final String gb;
    public final String h;
    public final String hc;
    public final String u;

    public static d d() {
        return new d();
    }

    public static cb d(String str, int i) {
        return new cb(str, i);
    }

    private cb(String str, int i) {
        this.hc = null;
        this.b = null;
        this.c = null;
        this.u = null;
        this.an = str;
        this.h = null;
        this.d = i;
        this.gb = null;
    }

    private cb(d dVar) {
        this.hc = dVar.d;
        this.b = dVar.hc;
        this.c = dVar.b;
        this.u = dVar.c;
        this.an = dVar.u;
        this.h = dVar.an;
        this.d = 1;
        this.gb = dVar.h;
    }

    public static boolean d(cb cbVar) {
        return cbVar == null || cbVar.d != 1 || TextUtils.isEmpty(cbVar.c) || TextUtils.isEmpty(cbVar.u);
    }

    public String toString() {
        return "methodName: " + this.c + ", params: " + this.u + ", callbackId: " + this.an + ", type: " + this.b + ", version: " + this.hc + ", ";
    }

    public static final class d {
        private String an;
        private String b;
        private String c;
        private String d;
        private String h;
        private String hc;
        private String u;

        private d() {
        }

        public d d(String str) {
            this.d = str;
            return this;
        }

        public d hc(String str) {
            this.hc = str;
            return this;
        }

        public d b(String str) {
            this.b = str;
            return this;
        }

        public d c(String str) {
            this.c = str;
            return this;
        }

        public d u(String str) {
            this.u = str;
            return this;
        }

        public d an(String str) {
            this.an = str;
            return this;
        }

        public d h(String str) {
            this.h = str;
            return this;
        }

        public cb d() {
            return new cb(this);
        }
    }
}
