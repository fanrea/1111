package com.tk.component.scroll.b.b;

import android.support.v7.widget.al;
import android.view.View;
import android.view.ViewParent;
import com.tk.component.scroll.b.b.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class e implements h.g {
    private final int Wi;

    public e(int i) {
        this.Wi = i;
    }

    @Override // com.tk.component.scroll.b.b.h.g
    public final void c(View view, float f) {
        h hVarAM = aM(view);
        float f2 = this.Wi * f;
        if (hVarAM.getOrientation() == 0) {
            if (hVarAM.ov()) {
                f2 = -f2;
            }
            view.setTranslationX(f2);
            return;
        }
        view.setTranslationY(f2);
    }

    private static h aM(View view) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if ((parent instanceof al) && (parent2 instanceof h)) {
            return (h) parent2;
        }
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }
}
