package android.support.v7.widget;

import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface be {

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    interface b {
        int ap(View view);

        int aq(View view);

        int eS();

        int eT();

        View getChildAt(int i);
    }

    CharSequence getHint();

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    static class a {
        int Ac = 0;
        int Ad;
        int Ae;
        int Af;
        int Ag;

        private static int compare(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        a() {
        }

        final void setBounds(int i, int i2, int i3, int i4) {
            this.Ad = i;
            this.Ae = i2;
            this.Af = i3;
            this.Ag = i4;
        }

        final void addFlags(int i) {
            this.Ac = i | this.Ac;
        }

        final void hm() {
            this.Ac = 0;
        }

        final boolean hn() {
            int i = this.Ac;
            if ((i & 7) != 0 && (i & (compare(this.Af, this.Ad) << 0)) == 0) {
                return false;
            }
            int i2 = this.Ac;
            if ((i2 & 112) != 0 && (i2 & (compare(this.Af, this.Ae) << 4)) == 0) {
                return false;
            }
            int i3 = this.Ac;
            if ((i3 & 1792) != 0 && (i3 & (compare(this.Ag, this.Ad) << 8)) == 0) {
                return false;
            }
            int i4 = this.Ac;
            return (i4 & 28672) == 0 || (i4 & (compare(this.Ag, this.Ae) << 12)) != 0;
        }
    }
}
