package com.bytedance.embedapplog.util;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private final String an;
    private final String[] b;
    private final String c;
    private final String d;
    private final String h;
    private final String[] hc;
    private final String u;

    private d(C0206d c0206d) {
        this.d = c0206d.d;
        this.hc = c0206d.hc;
        this.b = c0206d.b;
        this.c = c0206d.c;
        this.u = c0206d.u;
        this.an = c0206d.an;
        this.h = c0206d.h;
    }

    /* renamed from: com.bytedance.embedapplog.util.d$d, reason: collision with other inner class name */
    public static class C0206d {
        private String an;
        private String[] b;
        private String c;
        private String d;
        private String h;
        private String[] hc;
        private String u;

        public C0206d d(String str) {
            this.d = str;
            return this;
        }

        public C0206d d(String[] strArr) {
            this.hc = strArr;
            return this;
        }

        public C0206d hc(String[] strArr) {
            this.b = strArr;
            return this;
        }

        public C0206d hc(String str) {
            this.c = str;
            return this;
        }

        public C0206d b(String str) {
            this.u = str;
            return this;
        }

        public C0206d c(String str) {
            this.h = str;
            return this;
        }

        public d d() {
            return new d(this);
        }
    }

    public String d() {
        return this.d;
    }

    public String[] hc() {
        return this.hc;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.u;
    }

    public static d d(int i) {
        return hc.d(i);
    }
}
