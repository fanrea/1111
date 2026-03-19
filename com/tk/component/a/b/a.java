package com.tk.component.a.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.tk.core.o.t;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends View {
    private boolean OX;
    private InterfaceC0808a OY;
    private final RectF OZ;
    private boolean Pa;
    private boolean Pb;
    private final Rect nw;
    private boolean sT;

    /* renamed from: com.tk.component.a.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0808a {
        void aB(int i, int i2);

        void i(Canvas canvas);
    }

    public a(Context context) {
        super(context);
        this.OZ = new RectF();
        this.nw = new Rect();
        this.Pb = true;
        ae();
    }

    private static void ae() {
        t.isDebug();
    }

    public final void setCheckVisiblePreDraw(boolean z) {
        this.Pb = z;
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.Pa = i == 0;
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        RectF rectF = this.OZ;
        rectF.right = i;
        rectF.bottom = i2;
        InterfaceC0808a interfaceC0808a = this.OY;
        if (interfaceC0808a != null) {
            interfaceC0808a.aB(i, i2);
        }
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        InterfaceC0808a interfaceC0808a;
        super.onDraw(canvas);
        if (this.OX) {
            if ((!this.Pb || isVisible()) && (interfaceC0808a = this.OY) != null) {
                interfaceC0808a.i(canvas);
            }
        }
    }

    public final void mm() {
        this.OX = true;
        invalidate();
    }

    @Override // android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.sT = true;
    }

    @Override // android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.sT = false;
    }

    private boolean isVisible() {
        if (this.Pa && this.sT) {
            return getGlobalVisibleRect(this.nw);
        }
        return false;
    }

    public final void setCallback(InterfaceC0808a interfaceC0808a) {
        this.OY = interfaceC0808a;
    }

    public final void onDestroy() {
        this.OY = null;
    }
}
