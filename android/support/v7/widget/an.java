package android.support.v7.widget;

import android.support.v7.widget.aj;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class an {
    static int a(aj.u uVar, ai aiVar, View view, View view2, aj.i iVar, boolean z, boolean z2) {
        int iMax;
        if (iVar.getChildCount() == 0 || uVar.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMin = Math.min(iVar.getPosition(view), iVar.getPosition(view2));
        int iMax2 = Math.max(iVar.getPosition(view), iVar.getPosition(view2));
        if (z2) {
            iMax = Math.max(0, (uVar.getItemCount() - iMax2) - 1);
        } else {
            iMax = Math.max(0, iMin);
        }
        if (!z) {
            return iMax;
        }
        return Math.round((iMax * (Math.abs(aiVar.N(view2) - aiVar.M(view)) / (Math.abs(iVar.getPosition(view) - iVar.getPosition(view2)) + 1))) + (aiVar.dE() - aiVar.M(view)));
    }

    static int a(aj.u uVar, ai aiVar, View view, View view2, aj.i iVar, boolean z) {
        if (iVar.getChildCount() == 0 || uVar.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(iVar.getPosition(view) - iVar.getPosition(view2)) + 1;
        }
        return Math.min(aiVar.dG(), aiVar.N(view2) - aiVar.M(view));
    }

    static int b(aj.u uVar, ai aiVar, View view, View view2, aj.i iVar, boolean z) {
        if (iVar.getChildCount() == 0 || uVar.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return uVar.getItemCount();
        }
        return (int) (((aiVar.N(view2) - aiVar.M(view)) / (Math.abs(iVar.getPosition(view) - iVar.getPosition(view2)) + 1)) * uVar.getItemCount());
    }
}
