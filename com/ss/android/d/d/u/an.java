package com.ss.android.d.d.u;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class an {
    private String d;
    private String hc;

    public an(d dVar) {
        this.d = dVar.d;
        this.hc = dVar.hc;
    }

    public String d() {
        return this.d;
    }

    public static class d {
        private String d;
        private String hc;

        public d d(String str) {
            this.d = str;
            return this;
        }

        public d hc(String str) {
            this.hc = str;
            return this;
        }

        public an d() {
            return new an(this);
        }
    }
}
