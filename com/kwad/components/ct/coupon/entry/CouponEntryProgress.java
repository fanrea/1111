package com.kwad.components.ct.coupon.entry;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.kwad.components.ct.coupon.entry.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CouponEntryProgress extends RelativeLayout {
    private d anL;
    private boolean anM;

    public CouponEntryProgress(Context context) {
        super(context);
        init();
    }

    public CouponEntryProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public CouponEntryProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setRadius(float f) {
        d dVar = this.anL;
        if (dVar != null) {
            dVar.setRadius(f);
        }
        invalidate();
    }

    public void setProgress(int i) {
        d dVar = this.anL;
        if (dVar != null) {
            dVar.setProgress(i);
        }
    }

    public int getProgress() {
        d dVar = this.anL;
        if (dVar != null) {
            return dVar.getProgress();
        }
        return -1;
    }

    public void setShowProgress(boolean z) {
        this.anM = z;
        invalidate();
    }

    public final boolean xW() {
        return this.anM;
    }

    public void setTargetProgress(int i) {
        d dVar = this.anL;
        if (dVar != null) {
            dVar.setTargetProgress(i);
        }
    }

    public void setStokeWidth(int i) {
        d dVar = this.anL;
        if (dVar != null) {
            dVar.setStokeWidth(i);
        }
        invalidate();
    }

    public void setColor(int i) {
        d dVar = this.anL;
        if (dVar != null) {
            dVar.setColor(i);
        }
        invalidate();
    }

    public void setSpeed(int i) {
        d dVar = this.anL;
        if (dVar != null) {
            dVar.setSpeed(i);
        }
    }

    private void init() {
        this.anL = new d(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        d dVar;
        super.dispatchDraw(canvas);
        if (!this.anM || (dVar = this.anL) == null) {
            return;
        }
        dVar.a(canvas, getWidth(), getHeight());
    }

    public final void a(d.a aVar) {
        d dVar = this.anL;
        if (dVar != null) {
            dVar.b(aVar);
        }
    }

    public final void pause() {
        d dVar = this.anL;
        if (dVar != null) {
            dVar.pause();
        }
    }

    public final void resume() {
        d dVar = this.anL;
        if (dVar != null) {
            dVar.resume();
        }
    }

    public final void xX() {
        d dVar = this.anL;
        if (dVar != null) {
            dVar.reset();
        }
    }
}
