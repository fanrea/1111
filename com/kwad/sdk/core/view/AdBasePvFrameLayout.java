package com.kwad.sdk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import com.kwad.sdk.utils.bz;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.widget.n;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AdBasePvFrameLayout extends AdBaseFrameLayout {
    private long bJV;
    private float bJW;
    private boolean bJX;
    private boolean bJY;
    private ViewTreeObserver.OnScrollChangedListener bJZ;
    private ViewTreeObserver bKa;
    private bz bKb;
    private n gr;
    private int qu;

    public AdBasePvFrameLayout(Context context) {
        super(context);
        this.bJV = 500L;
        this.bJW = 0.1f;
        this.bJY = true;
        init();
    }

    public AdBasePvFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bJV = 500L;
        this.bJW = 0.1f;
        this.bJY = true;
        init();
    }

    public AdBasePvFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bJV = 500L;
        this.bJW = 0.1f;
        this.bJY = true;
        init();
    }

    private void init() {
        this.bKb = new bz(this);
        this.qu = m.getScreenHeight(getContext());
        this.bJY = true;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z = true;
        if (this.bJX || (i3 | i4) != 0 || (i | i2) == 0) {
            z = false;
        } else {
            this.bJX = true;
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (z) {
            qv();
        }
    }

    private void qv() {
        if (this.bJY) {
            adn();
        }
    }

    private void adn() {
        if (adp()) {
            ado();
        } else {
            adq();
        }
    }

    protected final void ado() {
        adr();
        n nVar = this.gr;
        if (nVar != null) {
            nVar.aY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean adp() {
        return this.bKb.aqr() && ((float) Math.abs(this.bKb.cog.height() - getHeight())) <= ((float) getHeight()) * (1.0f - this.bJW) && getHeight() > 0 && getWidth() > 0 && this.bKb.cog.bottom > 0 && this.bKb.cog.top < this.qu;
    }

    public void setCheckDefaultImpressionLogThreshold(float f) {
        this.bJW = f;
    }

    private void adq() {
        if (this.bJZ == null) {
            this.bJZ = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.core.view.AdBasePvFrameLayout.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (AdBasePvFrameLayout.this.adp()) {
                        AdBasePvFrameLayout.this.ado();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            this.bKa = viewTreeObserver;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.bJZ);
            }
        }
    }

    private void adr() {
        ViewTreeObserver viewTreeObserver;
        try {
            if (this.bJZ != null && (viewTreeObserver = this.bKa) != null && viewTreeObserver.isAlive()) {
                this.bKa.removeOnScrollChangedListener(this.bJZ);
            }
            this.bJZ = null;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        adr();
        this.bJX = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        adq();
    }

    public void setVisibleListener(n nVar) {
        this.gr = nVar;
    }
}
