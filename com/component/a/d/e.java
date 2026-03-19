package com.component.a.d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.baidu.mobads.container.util.x;
import com.component.a.d.b;
import com.component.a.f.e;
import com.component.a.i.n;
import com.component.a.i.r;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class e extends ScrollView implements com.component.a.c.b {
    private com.component.a.i.f a;
    private float[] b;
    private float c;
    private final Path d;
    private final RectF e;
    private boolean f;
    private c g;

    public e(Context context, com.component.a.f.e eVar) {
        super(context);
        this.b = new float[8];
        this.c = -2.0f;
        this.d = new Path();
        this.e = new RectF();
        this.f = false;
        if (eVar != null) {
            this.a = new com.component.a.i.f(eVar);
            a(context, eVar);
        }
    }

    private void a(com.component.a.f.e eVar) {
        if (eVar != null) {
            Context context = getContext();
            e.f fVarH = eVar.h();
            Drawable drawableA = r.a(context, fVarH);
            if (x.a(context).a() > 16) {
                setBackground(drawableA);
            } else {
                setBackgroundDrawable(drawableA);
            }
            this.b = fVarH.a(this.b);
            n.a(context, this.b);
            this.c = fVarH.f(-2.0f);
        }
    }

    @Override // com.component.a.c.c
    public void switchViewStyle(com.component.a.f.e eVar) {
        a(eVar);
        invalidate();
    }

    private void a(Context context, com.component.a.f.e eVar) {
        a(eVar);
        setFillViewport(true);
        this.g = new c(context, null);
        this.g.setLifeCycle(this.a);
        addView(this.g, new a(-1, -2));
    }

    @Override // com.component.a.c.b
    public void a(View view, com.component.a.f.e eVar, int i) {
        this.g.a(view, eVar, i);
    }

    @Override // com.component.a.c.c
    public void setLifeCycle(com.component.a.i.f fVar) {
        this.a = fVar;
    }

    @Override // com.component.a.c.c
    public com.component.a.i.f getLifeCycle() {
        return this.a;
    }

    @Override // android.view.View
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        return new a(-1, -1);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!a(this.b) && getWidth() > 0 && getHeight() > 0) {
            float paddingLeft = getPaddingLeft();
            float paddingTop = getPaddingTop();
            float width = (getWidth() - paddingLeft) - getPaddingRight();
            float height = (getHeight() - paddingTop) - getPaddingBottom();
            float fA = r.a(width, height, this.c, -1.0f);
            if (fA > 0.0f) {
                Arrays.fill(this.b, fA);
            }
            this.e.set(paddingLeft, paddingTop, width + paddingLeft, height + paddingTop);
            this.d.addRoundRect(this.e, this.b, Path.Direction.CCW);
            this.f = true;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f) {
            canvas.clipPath(this.d);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a != null) {
            this.a.e(this);
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.a != null) {
            this.a.f(this);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.a != null) {
            this.a.b(view, i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (this.a != null) {
            this.a.a(motionEvent, zDispatchTouchEvent);
        }
        return zDispatchTouchEvent;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (this.a != null) {
            this.a.b(motionEvent, zOnTouchEvent);
        }
        return zOnTouchEvent;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (this.g != null) {
            this.g.setOnClickListener(onClickListener);
        }
    }

    private boolean a(float[] fArr) {
        int iFloatToIntBits = Float.floatToIntBits(0.0f);
        for (float f : fArr) {
            if (Float.floatToIntBits(f) != iFloatToIntBits) {
                return false;
            }
        }
        return true;
    }

    public static class a extends FrameLayout.LayoutParams implements b.c {
        private b.C0314b a;

        public a(int i, int i2) {
            super(i, i2);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        @Override // com.component.a.d.b.c
        public b.C0314b a() {
            if (this.a == null) {
                this.a = new b.C0314b();
            }
            return this.a;
        }
    }
}
