package lkxssdk.o;

import lkxssdk.n.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class e extends lkxssdk.n.b {
    public static final byte[] b = new byte[0];
    public byte[] c;
    public final int[] d;
    public a e;

    public e(h hVar) {
        super(hVar);
        this.c = b;
        this.d = new int[32];
    }

    public final void a(int i) {
        if (this.c.length < i) {
            this.c = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.d[i2] = 0;
        }
    }
}
