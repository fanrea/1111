package android.support.v7.widget;

import android.support.v7.widget.aj;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class ab {
    int fx;
    int mCurrentPosition;
    int pT;
    int pU;
    boolean pX;
    boolean pY;
    boolean pS = true;
    int pV = 0;
    int pW = 0;

    ab() {
    }

    final boolean a(aj.u uVar) {
        int i = this.mCurrentPosition;
        return i >= 0 && i < uVar.getItemCount();
    }

    final View a(aj.p pVar) {
        View viewAu = pVar.au(this.mCurrentPosition);
        this.mCurrentPosition += this.pU;
        return viewAu;
    }

    public final String toString() {
        return "LayoutState{mAvailable=" + this.pT + ", mCurrentPosition=" + this.mCurrentPosition + ", mItemDirection=" + this.pU + ", mLayoutDirection=" + this.fx + ", mStartLine=" + this.pV + ", mEndLine=" + this.pW + '}';
    }
}
