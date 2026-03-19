package com.bytedance.sdk.component.widget.recycler.d.b;

import android.view.View;
import android.view.ViewParent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    private final View b;
    private boolean c;
    private ViewParent d;
    private ViewParent hc;
    private int[] u;

    public c(View view) {
        this.b = view;
    }

    public void d(boolean z) {
        if (this.c) {
            h.tc(this.b);
        }
        this.c = z;
    }

    public boolean d() {
        return this.c;
    }

    public boolean hc() {
        return d(0);
    }

    public boolean d(int i) {
        return c(i) != null;
    }

    public boolean hc(int i) {
        return d(i, 0);
    }

    public boolean d(int i, int i2) {
        if (d(i2)) {
            return true;
        }
        if (!d()) {
            return false;
        }
        View view = this.b;
        for (ViewParent parent = this.b.getParent(); parent != null; parent = parent.getParent()) {
            if (gb.d(parent, view, this.b, i, i2)) {
                d(i2, parent);
                gb.hc(parent, view, this.b, i, i2);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void b() {
        b(0);
    }

    public void b(int i) {
        ViewParent viewParentC = c(i);
        if (viewParentC != null) {
            gb.d(viewParentC, this.b, i);
            d(i, (ViewParent) null);
        }
    }

    public boolean d(int i, int i2, int i3, int i4, int[] iArr) {
        return d(i, i2, i3, i4, iArr, 0);
    }

    public boolean d(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        ViewParent viewParentC;
        int i6;
        int i7;
        if (!d() || (viewParentC = c(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.b.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        gb.d(viewParentC, this.b, i, i2, i3, i4, i5);
        if (iArr != null) {
            this.b.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    public boolean d(int i, int i2, int[] iArr, int[] iArr2) {
        return d(i, i2, iArr, iArr2, 0);
    }

    public boolean d(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent viewParentC;
        int i4;
        int i5;
        if (!d() || (viewParentC = c(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.b.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            if (this.u == null) {
                this.u = new int[2];
            }
            iArr = this.u;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        gb.d(viewParentC, this.b, i, i2, iArr, i3);
        if (iArr2 != null) {
            this.b.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public boolean d(float f, float f2, boolean z) {
        ViewParent viewParentC;
        if (!d() || (viewParentC = c(0)) == null) {
            return false;
        }
        return gb.d(viewParentC, this.b, f, f2, z);
    }

    public boolean d(float f, float f2) {
        ViewParent viewParentC;
        if (!d() || (viewParentC = c(0)) == null) {
            return false;
        }
        return gb.d(viewParentC, this.b, f, f2);
    }

    private ViewParent c(int i) {
        if (i == 0) {
            return this.d;
        }
        if (i != 1) {
            return null;
        }
        return this.hc;
    }

    private void d(int i, ViewParent viewParent) {
        if (i == 0) {
            this.d = viewParent;
        } else {
            if (i != 1) {
                return;
            }
            this.hc = viewParent;
        }
    }
}
