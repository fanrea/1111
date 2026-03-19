package com.ss.android.d.d.u;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d {
    public String b;
    public String c;
    public String d;
    public String hc;
    public String u;

    public d(C0749d c0749d) {
        this.hc = "";
        this.d = c0749d.d;
        this.hc = c0749d.hc;
        this.b = c0749d.b;
        this.c = c0749d.c;
        this.u = c0749d.u;
    }

    /* renamed from: com.ss.android.d.d.u.d$d, reason: collision with other inner class name */
    public static class C0749d {
        private String b;
        private String c;
        private String d;
        private String hc;
        private String u;

        public C0749d d(String str) {
            this.d = str;
            return this;
        }

        public C0749d hc(String str) {
            this.hc = str;
            return this;
        }

        public C0749d b(String str) {
            this.c = str;
            return this;
        }

        public C0749d c(String str) {
            this.u = str;
            return this;
        }

        public d d() {
            return new d(this);
        }
    }
}
