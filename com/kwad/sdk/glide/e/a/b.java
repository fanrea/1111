package com.kwad.sdk.glide.e.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class b {
    public abstract void ajJ();

    abstract void cW(boolean z);

    /* synthetic */ b(byte b) {
        this();
    }

    public static b ajI() {
        return new a();
    }

    private b() {
    }

    static class a extends b {
        private volatile boolean bTi;

        a() {
            super((byte) 0);
        }

        @Override // com.kwad.sdk.glide.e.a.b
        public final void ajJ() {
            if (this.bTi) {
                throw new IllegalStateException("Already released");
            }
        }

        @Override // com.kwad.sdk.glide.e.a.b
        public final void cW(boolean z) {
            this.bTi = z;
        }
    }
}
