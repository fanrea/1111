package com.tk.core.component.text;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class g extends TextView {
    private static final int afp = com.tk.core.o.o.eb(20);
    private final float afq;
    private float afr;
    private String afs;
    private float aft;
    private float afu;
    private float afv;
    private boolean afw;
    private com.tk.core.o.n afx;
    private int us;

    public g(Context context) {
        this(context, null);
    }

    private g(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.afw = true;
        this.afq = ((context.getResources().getDisplayMetrics().density * 12.0f) * 48.0f) / 1000.0f;
    }

    @Override // android.widget.TextView, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.afr = (int) ((getHeight() / 2) - ((getPaint().descent() + getPaint().ascent()) / 2.0f));
    }

    @Override // android.widget.TextView, android.view.View
    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.us = getWidth();
        if (TextUtils.isEmpty(this.afs) || this.aft <= 0.0f || this.us <= 0) {
            return;
        }
        float f = -this.afu;
        while (f < this.us) {
            canvas.drawText(this.afs, f, this.afr, getPaint());
            f += this.aft + afp;
        }
    }

    public final void setText(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = this.afs;
        if (str2 == null || !str2.equals(str)) {
            this.afs = str;
            this.aft = getPaint().measureText(this.afs);
        }
        rn();
        postInvalidate();
        rk();
    }

    private void rk() {
        com.tk.core.o.n nVar = this.afx;
        if (nVar == null || nVar.isRunning()) {
            return;
        }
        this.afx.start();
        this.afw = false;
    }

    private void rl() {
        com.tk.core.o.n nVar = this.afx;
        if (nVar != null) {
            nVar.stop();
            this.afw = true;
        }
    }

    public final void rm() {
        rl();
        if (this.afu != getScrollInitialValue()) {
            this.afu = getScrollInitialValue();
            postInvalidate();
        }
    }

    private void rn() {
        if (this.afx != null) {
            return;
        }
        this.afx = new com.tk.core.o.n(48L, new Runnable() { // from class: com.tk.core.component.text.g.1
            @Override // java.lang.Runnable
            public final void run() {
                if (g.this.afw) {
                    return;
                }
                g.this.afu += g.this.afq;
                if (g.this.afu > g.this.aft + g.afp) {
                    g.this.afu -= g.this.aft + g.afp;
                }
                g.this.postInvalidate();
            }
        });
    }

    private float getScrollInitialValue() {
        return -this.afv;
    }
}
