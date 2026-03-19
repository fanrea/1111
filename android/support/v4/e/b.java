package android.support.v4.e;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class b {
    private static final View.AccessibilityDelegate cl = new View.AccessibilityDelegate();
    private final View.AccessibilityDelegate cm = new a(this);

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static final class a extends View.AccessibilityDelegate {

        /* renamed from: cn, reason: collision with root package name */
        private final b f707cn;

        a(b bVar) {
            this.f707cn = bVar;
        }

        @Override // android.view.View.AccessibilityDelegate
        public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return b.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f707cn.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            this.f707cn.a(view, android.support.v4.e.a.b.a(accessibilityNodeInfo));
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            b.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return b.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void sendAccessibilityEvent(View view, int i) {
            b.sendAccessibilityEvent(view, i);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            b.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            android.support.v4.e.a.c cVarA = b.a(view);
            if (cVarA != null) {
                return (AccessibilityNodeProvider) cVarA.ab();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.f707cn.performAccessibilityAction(view, i, bundle);
        }
    }

    final View.AccessibilityDelegate X() {
        return this.cm;
    }

    public static void sendAccessibilityEvent(View view, int i) {
        cl.sendAccessibilityEvent(view, i);
    }

    public static void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        cl.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public static boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return cl.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public static void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        cl.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        cl.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void a(View view, android.support.v4.e.a.b bVar) {
        cl.onInitializeAccessibilityNodeInfo(view, bVar.aa());
    }

    public static boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return cl.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public static android.support.v4.e.a.c a(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = cl.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new android.support.v4.e.a.c(accessibilityNodeProvider);
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return cl.performAccessibilityAction(view, i, bundle);
        }
        return false;
    }
}
