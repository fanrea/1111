package com.kwad.components.core.s;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a {
    private static volatile a ZJ;
    private int VQ;
    private int ZK;
    private boolean ZL;
    private boolean ZM;
    private int ZN;
    private boolean ZO;

    private a() {
    }

    public static a sX() {
        if (ZJ == null) {
            synchronized (a.class) {
                if (ZJ == null) {
                    ZJ = new a();
                }
            }
        }
        return ZJ;
    }

    public final int sY() {
        return this.ZK;
    }

    public final void bc(int i) {
        this.ZK = i;
    }

    public final boolean sZ() {
        return this.ZL;
    }

    public final void aP(boolean z) {
        this.ZL = true;
    }

    public final boolean ta() {
        return this.ZM;
    }

    public final void aQ(boolean z) {
        this.ZM = z;
    }

    public final boolean tb() {
        int i = this.ZN;
        return i == 1 || i == 3;
    }

    public final void bd(int i) {
        this.ZN = i;
    }

    public final int tc() {
        return this.ZN;
    }

    public final boolean td() {
        return this.ZO;
    }

    public final void aR(boolean z) {
        this.ZO = z;
    }

    public final int te() {
        return this.VQ;
    }

    public final void be(int i) {
        this.VQ = i;
    }

    public final void clear() {
        this.ZM = false;
        this.ZL = false;
        this.ZN = 0;
        this.ZO = false;
        this.ZK = -1;
        this.VQ = 0;
    }
}
