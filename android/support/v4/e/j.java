package android.support.v4.e;

import android.view.View;
import android.view.ViewParent;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class j {
    private ViewParent cr;
    private ViewParent ct;
    private final View cu;
    private boolean cv;
    private int[] cw;

    public j(View view) {
        this.cu = view;
    }

    public final void setNestedScrollingEnabled(boolean z) {
        if (this.cv) {
            o.p(this.cu);
        }
        this.cv = z;
    }

    public final boolean isNestedScrollingEnabled() {
        return this.cv;
    }

    public final boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    public final boolean hasNestedScrollingParent(int i) {
        return n(i) != null;
    }

    public final boolean startNestedScroll(int i) {
        return startNestedScroll(i, 0);
    }

    public final boolean startNestedScroll(int i, int i2) {
        if (hasNestedScrollingParent(i2)) {
            return true;
        }
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        View view = this.cu;
        for (ViewParent parent = this.cu.getParent(); parent != null; parent = parent.getParent()) {
            if (q.a(parent, view, this.cu, i, i2)) {
                a(i2, parent);
                q.b(parent, view, this.cu, i, i2);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public final void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public final void stopNestedScroll(int i) {
        ViewParent viewParentN = n(i);
        if (viewParentN != null) {
            q.a(viewParentN, this.cu, i);
            a(i, null);
        }
    }

    public final boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return dispatchNestedScroll(i, i2, i3, i4, iArr, 0);
    }

    public final boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        ViewParent viewParentN;
        int i6;
        int i7;
        if (!isNestedScrollingEnabled() || (viewParentN = n(i5)) == null) {
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
            this.cu.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        q.a(viewParentN, this.cu, i, i2, i3, i4, i5);
        if (iArr != null) {
            this.cu.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    public final boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return dispatchNestedPreScroll(i, i2, iArr, iArr2, 0);
    }

    public final boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent viewParentN;
        int i4;
        int i5;
        if (!isNestedScrollingEnabled() || (viewParentN = n(i3)) == null) {
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
            this.cu.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            if (this.cw == null) {
                this.cw = new int[2];
            }
            iArr = this.cw;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        q.a(viewParentN, this.cu, i, i2, iArr, i3);
        if (iArr2 != null) {
            this.cu.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public final boolean dispatchNestedFling(float f, float f2, boolean z) {
        ViewParent viewParentN;
        if (!isNestedScrollingEnabled() || (viewParentN = n(0)) == null) {
            return false;
        }
        return q.a(viewParentN, this.cu, f, f2, z);
    }

    public final boolean dispatchNestedPreFling(float f, float f2) {
        ViewParent viewParentN;
        if (!isNestedScrollingEnabled() || (viewParentN = n(0)) == null) {
            return false;
        }
        return q.a(viewParentN, this.cu, f, f2);
    }

    private ViewParent n(int i) {
        if (i == 0) {
            return this.cr;
        }
        if (i != 1) {
            return null;
        }
        return this.ct;
    }

    private void a(int i, ViewParent viewParent) {
        if (i == 0) {
            this.cr = viewParent;
        } else {
            if (i != 1) {
                return;
            }
            this.ct = viewParent;
        }
    }
}
