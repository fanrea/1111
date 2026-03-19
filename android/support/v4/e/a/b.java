package android.support.v4.e.a;

import android.graphics.Rect;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class b {
    private final AccessibilityNodeInfo cJ;
    public int cK = -1;

    private static String q(int i) {
        if (i == 1) {
            return "ACTION_FOCUS";
        }
        if (i == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public static class a {
        final Object cL;

        public static a a(int i, int i2, boolean z, int i3) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new a(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new a(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z));
            }
            return new a(null);
        }

        private a(Object obj) {
            this.cL = obj;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    /* renamed from: android.support.v4.e.a.b$b, reason: collision with other inner class name */
    public static class C0008b {
        final Object cL;

        public static C0008b a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new C0008b(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, false));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new C0008b(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z));
            }
            return new C0008b(null);
        }

        private C0008b(Object obj) {
            this.cL = obj;
        }
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    public static class c {
        final Object dl;

        public static c a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, false));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z));
            }
            return new c(null);
        }

        private c(Object obj) {
            this.dl = obj;
        }
    }

    private b(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.cJ = accessibilityNodeInfo;
    }

    public static b a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new b(accessibilityNodeInfo);
    }

    public final AccessibilityNodeInfo aa() {
        return this.cJ;
    }

    private int getActions() {
        return this.cJ.getActions();
    }

    public final void addAction(int i) {
        this.cJ.addAction(i);
    }

    private void getBoundsInParent(Rect rect) {
        this.cJ.getBoundsInParent(rect);
    }

    private void getBoundsInScreen(Rect rect) {
        this.cJ.getBoundsInScreen(rect);
    }

    private boolean isCheckable() {
        return this.cJ.isCheckable();
    }

    private boolean isChecked() {
        return this.cJ.isChecked();
    }

    private boolean isFocusable() {
        return this.cJ.isFocusable();
    }

    private boolean isFocused() {
        return this.cJ.isFocused();
    }

    private boolean isSelected() {
        return this.cJ.isSelected();
    }

    private boolean isClickable() {
        return this.cJ.isClickable();
    }

    private boolean isLongClickable() {
        return this.cJ.isLongClickable();
    }

    private boolean isEnabled() {
        return this.cJ.isEnabled();
    }

    private boolean isPassword() {
        return this.cJ.isPassword();
    }

    private boolean isScrollable() {
        return this.cJ.isScrollable();
    }

    public final void setScrollable(boolean z) {
        this.cJ.setScrollable(true);
    }

    private CharSequence getPackageName() {
        return this.cJ.getPackageName();
    }

    private CharSequence getClassName() {
        return this.cJ.getClassName();
    }

    public final void setClassName(CharSequence charSequence) {
        this.cJ.setClassName(charSequence);
    }

    private CharSequence getText() {
        return this.cJ.getText();
    }

    private CharSequence getContentDescription() {
        return this.cJ.getContentDescription();
    }

    private String getViewIdResourceName() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.cJ.getViewIdResourceName();
        }
        return null;
    }

    public final void l(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.cJ.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((a) obj).cL);
        }
    }

    public final void m(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.cJ.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((C0008b) obj).cL);
        }
    }

    public final int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.cJ;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.cJ;
        if (accessibilityNodeInfo == null) {
            if (bVar.cJ != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(bVar.cJ)) {
            return false;
        }
        return true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        getBoundsInParent(rect);
        sb.append("; boundsInParent: " + rect);
        getBoundsInScreen(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(getPackageName());
        sb.append("; className: ");
        sb.append(getClassName());
        sb.append("; text: ");
        sb.append(getText());
        sb.append("; contentDescription: ");
        sb.append(getContentDescription());
        sb.append("; viewId: ");
        sb.append(getViewIdResourceName());
        sb.append("; checkable: ");
        sb.append(isCheckable());
        sb.append("; checked: ");
        sb.append(isChecked());
        sb.append("; focusable: ");
        sb.append(isFocusable());
        sb.append("; focused: ");
        sb.append(isFocused());
        sb.append("; selected: ");
        sb.append(isSelected());
        sb.append("; clickable: ");
        sb.append(isClickable());
        sb.append("; longClickable: ");
        sb.append(isLongClickable());
        sb.append("; enabled: ");
        sb.append(isEnabled());
        sb.append("; password: ");
        sb.append(isPassword());
        sb.append("; scrollable: " + isScrollable());
        sb.append("; [");
        int actions = getActions();
        while (actions != 0) {
            int iNumberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(actions);
            actions &= iNumberOfTrailingZeros ^ (-1);
            sb.append(q(iNumberOfTrailingZeros));
            if (actions != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
