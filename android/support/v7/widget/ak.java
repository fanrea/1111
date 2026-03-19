package android.support.v7.widget;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.al;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ak extends android.support.v4.e.b {
    final aj mRecyclerView;
    final android.support.v4.e.b sv = new a(this);

    public ak(aj ajVar) {
        this.mRecyclerView = ajVar;
    }

    final boolean shouldIgnore() {
        return this.mRecyclerView.hasPendingAdapterUpdates();
    }

    @Override // android.support.v4.e.b
    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        if (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) {
            return false;
        }
        return this.mRecyclerView.getLayoutManager().performAccessibilityAction(i, bundle);
    }

    @Override // android.support.v4.e.b
    public final void a(View view, android.support.v4.e.a.b bVar) {
        super.a(view, bVar);
        bVar.setClassName(aj.class.getName());
        if (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) {
            return;
        }
        this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(bVar);
    }

    @Override // android.support.v4.e.b
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(aj.class.getName());
        if (!(view instanceof aj) || shouldIgnore()) {
            return;
        }
        aj ajVar = (aj) view;
        if (ajVar.getLayoutManager() != null) {
            ajVar.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    public final android.support.v4.e.b en() {
        return this.sv;
    }

    public static class a extends android.support.v4.e.b {
        final ak sw;

        public a(ak akVar) {
            this.sw = akVar;
        }

        @Override // android.support.v4.e.b
        public final void a(View view, android.support.v4.e.a.b bVar) {
            super.a(view, bVar);
            if (this.sw.shouldIgnore() || this.sw.mRecyclerView.getLayoutManager() == null) {
                return;
            }
            this.sw.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, bVar);
        }

        @Override // android.support.v4.e.b
        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (this.sw.shouldIgnore() || this.sw.mRecyclerView.getLayoutManager() == null) {
                return false;
            }
            return this.sw.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(view, i, bundle);
        }
    }

    /* renamed from: android.support.v7.widget.ak$1, reason: invalid class name */
    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    final class AnonymousClass1 extends ad {
        AnonymousClass1(Context context) {
            super(context);
        }

        protected final void a(View view, al.t.a aVar) {
            ak akVar = ak.this;
            int[] iArrA = akVar.a(akVar.pD.getLayoutManager(), view);
            int i = iArrA[0];
            int i2 = iArrA[1];
            int iAu = au(Math.max(Math.abs(i), Math.abs(i2)));
            if (iAu > 0) {
                aVar.a(i, i2, iAu, this.rB);
            }
        }

        protected final float a(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }

        protected final int av(int i) {
            return Math.min(100, super.av(i));
        }
    }
}
