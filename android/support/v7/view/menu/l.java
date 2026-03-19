package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.support.v7.a.a;
import android.support.v7.view.menu.m;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.core.view.GravityCompat;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class l {
    private boolean hD;
    private m.a hF;
    private PopupWindow.OnDismissListener hH;
    private final g ha;
    private final int hl;
    private final int hm;
    private final boolean hn;
    private int hv;
    private View hw;
    private k je;
    private final PopupWindow.OnDismissListener jf;
    private final Context mContext;

    public l(Context context, g gVar, View view, boolean z, int i) {
        this(context, gVar, view, z, i, 0);
    }

    public l(Context context, g gVar, View view, boolean z, int i, int i2) {
        this.hv = GravityCompat.START;
        this.jf = new PopupWindow.OnDismissListener() { // from class: android.support.v7.view.menu.l.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                l.this.onDismiss();
            }
        };
        this.mContext = context;
        this.ha = gVar;
        this.hw = view;
        this.hn = z;
        this.hl = i;
        this.hm = i2;
    }

    public final void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.hH = onDismissListener;
    }

    public final void setAnchorView(View view) {
        this.hw = view;
    }

    public final void setForceShowIcon(boolean z) {
        this.hD = z;
        k kVar = this.je;
        if (kVar != null) {
            kVar.setForceShowIcon(z);
        }
    }

    public final void setGravity(int i) {
        this.hv = GravityCompat.END;
    }

    public final void show() {
        if (!bN()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public final k bM() {
        if (this.je == null) {
            this.je = bO();
        }
        return this.je;
    }

    public final boolean bN() {
        if (isShowing()) {
            return true;
        }
        if (this.hw == null) {
            return false;
        }
        a(0, 0, false, false);
        return true;
    }

    public final boolean m(int i, int i2) {
        if (isShowing()) {
            return true;
        }
        if (this.hw == null) {
            return false;
        }
        a(i, i2, true, true);
        return true;
    }

    private k bO() {
        k rVar;
        Display defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        if (Math.min(point.x, point.y) >= this.mContext.getResources().getDimensionPixelSize(a.d.abc_cascading_menus_min_smallest_width)) {
            rVar = new e(this.mContext, this.hw, this.hl, this.hm, this.hn);
        } else {
            rVar = new r(this.mContext, this.ha, this.hw, this.hl, this.hm, this.hn);
        }
        rVar.a(this.ha);
        rVar.setOnDismissListener(this.jf);
        rVar.setAnchorView(this.hw);
        rVar.a(this.hF);
        rVar.setForceShowIcon(this.hD);
        rVar.setGravity(this.hv);
        return rVar;
    }

    private void a(int i, int i2, boolean z, boolean z2) {
        k kVarBM = bM();
        kVarBM.m(z2);
        if (z) {
            if ((android.support.v4.e.d.getAbsoluteGravity(this.hv, android.support.v4.e.o.g(this.hw)) & 7) == 5) {
                i -= this.hw.getWidth();
            }
            kVarBM.setHorizontalOffset(i);
            kVarBM.setVerticalOffset(i2);
            int i3 = (int) ((this.mContext.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            kVarBM.setEpicenterBounds(new Rect(i - i3, i2 - i3, i + i3, i2 + i3));
        }
        kVarBM.show();
    }

    public final void dismiss() {
        if (isShowing()) {
            this.je.dismiss();
        }
    }

    protected void onDismiss() {
        this.je = null;
        PopupWindow.OnDismissListener onDismissListener = this.hH;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final boolean isShowing() {
        k kVar = this.je;
        return kVar != null && kVar.isShowing();
    }

    public final void b(m.a aVar) {
        this.hF = aVar;
        k kVar = this.je;
        if (kVar != null) {
            kVar.a(aVar);
        }
    }
}
