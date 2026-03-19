package android.support.v4.e;

import android.view.View;
import android.view.ViewGroup;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class m {
    private final ViewGroup cx;
    private int cy;

    public m(ViewGroup viewGroup) {
        this.cx = viewGroup;
    }

    public final void onNestedScrollAccepted(View view, View view2, int i) {
        p(i);
    }

    public final void p(int i) {
        this.cy = i;
    }

    public final int getNestedScrollAxes() {
        return this.cy;
    }

    public final void Z() {
        this.cy = 0;
    }
}
