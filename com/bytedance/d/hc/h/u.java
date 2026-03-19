package com.bytedance.d.hc.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u {
    private boolean b;
    private boolean c;
    private String d;
    private String hc;
    private byte[] u;

    public String d() {
        return this.d;
    }

    public boolean hc() {
        return this.c;
    }

    public byte[] b() {
        return this.u;
    }

    public static class d {
        private boolean b;
        private boolean c;
        private String d;
        private String hc;
        private byte[] u;

        public d d(String str) {
            this.d = str;
            return this;
        }

        public d d(boolean z) {
            this.c = z;
            return this;
        }

        public d d(byte[] bArr) {
            this.u = bArr;
            return this;
        }

        public u d() {
            u uVar = new u();
            uVar.d = this.d;
            uVar.hc = this.hc;
            uVar.b = this.b;
            uVar.c = this.c;
            uVar.u = this.u;
            return uVar;
        }
    }
}
