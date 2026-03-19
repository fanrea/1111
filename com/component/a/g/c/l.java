package com.component.a.g.c;

import android.text.Layout;
import android.view.ViewTreeObserver;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class l implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ com.component.a.a.q a;
    final /* synthetic */ int b;
    final /* synthetic */ k c;

    l(k kVar, com.component.a.a.q qVar, int i) {
        this.c = kVar;
        this.a = qVar;
        this.b = i;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        try {
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
            Layout layout = this.a.getLayout();
            if (layout != null && layout.getLineCount() > 1) {
                int width = layout.getWidth() - 12;
                this.a.setTextSize(Math.max((int) ((this.b * width) / (width + layout.getLineWidth(1))), Math.max(8, this.b / 2)));
                return false;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
