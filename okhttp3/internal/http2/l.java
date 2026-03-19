package okhttp3.internal.http2;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class l {
    private int Dl;
    private final int[] Dm = new int[10];

    final l Y(int i, int i2) {
        int[] iArr = this.Dm;
        if (i >= iArr.length) {
            return this;
        }
        this.Dl = (1 << i) | this.Dl;
        iArr[i] = i2;
        return this;
    }

    final boolean isSet(int i) {
        return ((1 << i) & this.Dl) != 0;
    }

    final int get(int i) {
        return this.Dm[i];
    }

    final int size() {
        return Integer.bitCount(this.Dl);
    }

    final int hg() {
        if ((this.Dl & 2) != 0) {
            return this.Dm[1];
        }
        return -1;
    }

    final int bG(int i) {
        if ((this.Dl & 16) != 0) {
            return this.Dm[4];
        }
        return Integer.MAX_VALUE;
    }

    final int bH(int i) {
        return (this.Dl & 32) != 0 ? this.Dm[5] : i;
    }

    final int hh() {
        if ((this.Dl & 128) != 0) {
            return this.Dm[7];
        }
        return 65535;
    }

    final void c(l lVar) {
        for (int i = 0; i < 10; i++) {
            if (lVar.isSet(i)) {
                Y(i, lVar.get(i));
            }
        }
    }
}
