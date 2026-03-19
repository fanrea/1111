package com.bytedance.msdk.api.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb {
    private boolean b;
    private boolean c;
    private boolean d;
    private String hc;

    private gb(d dVar) {
        this.d = dVar.d;
        this.hc = dVar.hc;
        this.b = dVar.b;
        this.c = dVar.c;
    }

    public static class d {
        private boolean d = false;
        private String hc = null;
        private boolean b = false;
        private boolean c = false;

        public d d(boolean z) {
            this.d = z;
            return this;
        }

        public d d(String str) {
            this.hc = str;
            return this;
        }

        public d hc(boolean z) {
            this.b = z;
            return this;
        }

        public d b(boolean z) {
            this.c = z;
            return this;
        }

        public gb d() {
            return new gb(this);
        }
    }

    public String d() {
        return this.hc;
    }

    public boolean hc() {
        return this.d;
    }

    public boolean b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }
}
