package com.kwad.sdk.widget;

import android.view.View;
import android.view.ViewTreeObserver;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bz;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class k {
    private final m awn;
    private final bz bKb;
    private boolean cqc;
    private boolean cqd;
    private ViewTreeObserver.OnScrollChangedListener cqf;
    private final View mView;
    private final int qu;
    private float cqb = 0.1f;
    private boolean cqe = true;

    public k(View view, m mVar) {
        this.mView = view;
        this.awn = mVar;
        this.bKb = new bz(view);
        this.qu = com.kwad.sdk.utils.m.getScreenHeight(view.getContext());
    }

    public final void dL(boolean z) {
        this.cqe = z;
    }

    public final void setVisiblePercent(float f) {
        this.cqb = f;
    }

    public final float getVisiblePercent() {
        return this.cqb;
    }

    public final void aqP() {
        aqT();
    }

    public final void f(int i, int i2, int i3, int i4) {
        this.cqd = false;
        if (this.cqc || (i3 | i4) != 0 || (i | i2) == 0) {
            return;
        }
        this.cqd = true;
        this.cqc = true;
    }

    public final void aqS() {
        if (this.cqd) {
            qv();
        }
    }

    public final void onAttachedToWindow() {
        adq();
    }

    public final void onDetachedFromWindow() {
        adr();
        this.cqc = false;
    }

    private void qv() {
        if (this.cqe) {
            aqT();
        }
    }

    private void aqT() {
        if (aqU()) {
            aY();
        } else {
            adr();
            adq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY() {
        try {
            adr();
            m mVar = this.awn;
            if (mVar != null) {
                mVar.E(this.mView);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqU() {
        return this.bKb.aqr() && ((float) Math.abs(this.bKb.cog.height() - this.mView.getHeight())) <= ((float) this.mView.getHeight()) * (1.0f - this.cqb) && this.mView.getHeight() > 0 && this.mView.getWidth() > 0 && this.bKb.cog.bottom > 0 && this.bKb.cog.top < this.qu;
    }

    private void adq() {
        if (this.cqf == null) {
            this.cqf = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.k.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (k.this.aqU()) {
                        k.this.aY();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.cqf);
            }
        }
    }

    private void adr() {
        if (this.cqf == null) {
            return;
        }
        try {
            ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnScrollChangedListener(this.cqf);
            }
            this.cqf = null;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }
}
