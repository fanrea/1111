package com.kwad.components.ct.detail.photo.d;

import com.kwad.components.ct.response.model.CtAdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class h {
    public boolean atj;
    public boolean atk;
    public boolean atl;
    public boolean atm;
    public boolean atn;
    public final CtAdTemplate mAdTemplate;

    /* synthetic */ h(a aVar, byte b) {
        this(aVar);
    }

    private h(a aVar) {
        CtAdTemplate ctAdTemplate = aVar.mAdTemplate;
        this.mAdTemplate = ctAdTemplate;
        if (com.kwad.components.core.a.qr.booleanValue() && ctAdTemplate == null) {
            throw new IllegalStateException("mAdTemplate need to be set!");
        }
        this.atn = aVar.atn;
        this.atj = aVar.atj;
        this.atk = aVar.atk;
        this.atl = aVar.atl;
        this.atm = aVar.atm;
    }

    public static final class a {
        private boolean atj;
        private boolean atk;
        private boolean atl;
        private boolean atm;
        private boolean atn;
        private CtAdTemplate mAdTemplate;

        public final a f(CtAdTemplate ctAdTemplate) {
            this.mAdTemplate = ctAdTemplate;
            return this;
        }

        public final a bt(boolean z) {
            this.atn = true;
            return this;
        }

        public final a bu(boolean z) {
            this.atj = z;
            return this;
        }

        public final a bv(boolean z) {
            this.atk = z;
            return this;
        }

        public final a bw(boolean z) {
            this.atl = z;
            return this;
        }

        public final a bx(boolean z) {
            this.atm = z;
            return this;
        }

        public final h Ak() {
            return new h(this, (byte) 0);
        }
    }
}
