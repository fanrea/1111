package com.component.a.a;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.mobads.container.util.x;
import com.component.a.f.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class q extends TextView implements com.component.a.c.c {
    private com.component.a.i.f a;
    private boolean b;

    public q(Context context, com.component.a.f.e eVar) {
        super(context);
        this.b = false;
        this.a = new com.component.a.i.f(eVar);
        setIncludeFontPadding(false);
        setText(eVar.o(""));
        a(eVar);
    }

    private void a(com.component.a.f.e eVar) {
        if (eVar == null) {
            return;
        }
        Context context = getContext();
        Drawable drawableA = com.component.a.i.r.a(context, eVar.h());
        if (x.a(context).a() > 16) {
            setBackground(drawableA);
        } else {
            setBackgroundDrawable(drawableA);
        }
        e.i iVarG = eVar.g();
        if (iVarG != null) {
            setTextSize(iVarG.c(12));
            setTextColor(com.component.a.i.r.a(iVarG.d(-16777216), iVarG.a(1.0f)));
            setTypeface(com.component.a.i.n.a(iVarG, 0));
            TextPaint paint = getPaint();
            a(paint, iVarG.e(0));
            setGravity(a(iVarG.a(1)));
            b(iVarG.f(0));
            c(iVarG.g(0));
            a(paint, iVarG.b(0.0f), iVarG.c(0.0f), iVarG.d(0.0f), com.component.a.i.r.a(iVarG.h(-16777216), iVarG.e(1.0f)));
            this.b = iVarG.b(0) == 1;
        }
    }

    private void a(Paint paint, int i) {
        if (paint != null && com.component.a.i.n.a(i)) {
            paint.setFlags(8);
        }
    }

    private void a(Paint paint, float f, float f2, float f3, int i) {
        if (paint != null && f > 0.0f) {
            paint.setShadowLayer(f, f2, f3, i);
        }
    }

    private int a(int i) {
        if (i == 1) {
            return 8388627;
        }
        if (i == 2) {
            return 17;
        }
        if (i == 3) {
            return 8388629;
        }
        return 0;
    }

    private void b(int i) {
        if (i > 1) {
            setMaxLines(i);
        } else if (i == 1) {
            setSingleLine();
        }
    }

    private void c(int i) {
        if (1 == i) {
            setEllipsize(TextUtils.TruncateAt.START);
            return;
        }
        if (2 == i) {
            setEllipsize(TextUtils.TruncateAt.END);
            return;
        }
        if (3 == i) {
            setEllipsize(TextUtils.TruncateAt.MIDDLE);
            return;
        }
        if (4 == i) {
            setEllipsize(TextUtils.TruncateAt.MARQUEE);
            setSingleLine();
            setMarqueeRepeatLimit(-1);
            setFocusableInTouchMode(true);
            requestFocus();
        }
    }

    private boolean a() {
        int lineCount;
        Layout layout = getLayout();
        if (layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
            return true;
        }
        return false;
    }

    @Override // com.component.a.c.c
    public void switchViewStyle(com.component.a.f.e eVar) {
        a(eVar);
        invalidate();
    }

    @Override // com.component.a.c.c
    public void setLifeCycle(com.component.a.i.f fVar) {
        this.a = fVar;
    }

    @Override // com.component.a.c.c
    public com.component.a.i.f getLifeCycle() {
        return this.a;
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.a != null) {
            this.a.a(this, z);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.a != null) {
            this.a.a((View) this, i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a != null) {
            this.a.e(this);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.a != null) {
            this.a.f(this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.a != null) {
            this.a.b(view, i);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (this.a != null) {
            this.a.a(motionEvent, zDispatchTouchEvent);
        }
        return zDispatchTouchEvent;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (this.a != null) {
            this.a.b(motionEvent, zOnTouchEvent);
        }
        if (this.b && motionEvent.getAction() == 0 && a()) {
            Toast.makeText(getContext(), getText(), 0).show();
        }
        return zOnTouchEvent;
    }
}
