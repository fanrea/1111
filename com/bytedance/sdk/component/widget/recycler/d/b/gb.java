package com.bytedance.sdk.component.widget.recycler.d.b;

import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import com.bytedance.sdk.component.utils.mq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class gb {
    public static boolean d(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof an) {
            return ((an) viewParent).d(view, view2, i, i2);
        }
        if (i2 != 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onStartNestedScroll(view, view2, i);
            } catch (AbstractMethodError e) {
                mq.b("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e);
                return false;
            }
        }
        if (viewParent instanceof u) {
            return ((u) viewParent).onStartNestedScroll(view, view2, i);
        }
        return false;
    }

    public static void hc(ViewParent viewParent, View view, View view2, int i, int i2) {
        if ((viewParent instanceof an) || i2 != 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                viewParent.onNestedScrollAccepted(view, view2, i);
                return;
            } catch (AbstractMethodError e) {
                mq.b("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e);
                return;
            }
        }
        if (viewParent instanceof u) {
            ((u) viewParent).onNestedScrollAccepted(view, view2, i);
        }
    }

    public static void d(ViewParent viewParent, View view, int i) {
        if ((viewParent instanceof an) || i != 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                viewParent.onStopNestedScroll(view);
                return;
            } catch (AbstractMethodError e) {
                mq.b("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e);
                return;
            }
        }
        if (viewParent instanceof u) {
            ((u) viewParent).onStopNestedScroll(view);
        }
    }

    public static void d(ViewParent viewParent, View view, int i, int i2, int i3, int i4, int i5) {
        if ((viewParent instanceof an) || i5 != 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                viewParent.onNestedScroll(view, i, i2, i3, i4);
                return;
            } catch (AbstractMethodError e) {
                mq.b("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e);
                return;
            }
        }
        if (viewParent instanceof u) {
            ((u) viewParent).onNestedScroll(view, i, i2, i3, i4);
        }
    }

    public static void d(ViewParent viewParent, View view, int i, int i2, int[] iArr, int i3) {
        if (viewParent instanceof an) {
            ((an) viewParent).d(view, i, i2, iArr, i3);
            return;
        }
        if (i3 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedPreScroll(view, i, i2, iArr);
                    return;
                } catch (AbstractMethodError e) {
                    mq.b("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e);
                    return;
                }
            }
            if (viewParent instanceof u) {
                ((u) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }
    }

    public static boolean d(ViewParent viewParent, View view, float f, float f2, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedFling(view, f, f2, z);
            } catch (AbstractMethodError e) {
                mq.b("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e);
                return false;
            }
        }
        if (viewParent instanceof u) {
            return ((u) viewParent).onNestedFling(view, f, f2, z);
        }
        return false;
    }

    public static boolean d(ViewParent viewParent, View view, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedPreFling(view, f, f2);
            } catch (AbstractMethodError e) {
                mq.b("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e);
                return false;
            }
        }
        if (viewParent instanceof u) {
            return ((u) viewParent).onNestedPreFling(view, f, f2);
        }
        return false;
    }
}
