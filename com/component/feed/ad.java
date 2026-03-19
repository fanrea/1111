package com.component.feed;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.mobads.container.util.bv;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ad extends com.component.a.d.c {
    private a a;
    private com.style.widget.e.f b;
    private boolean d;
    private String e;

    public static abstract class a {
        public void a(View view, MotionEvent motionEvent) {
        }

        public void a(int i, int i2) {
        }

        public void a() {
        }

        public void b() {
        }

        public boolean a(int i, KeyEvent keyEvent) {
            return false;
        }
    }

    public ad(Context context) {
        this(context, null);
    }

    public ad(Context context, com.component.a.f.e eVar) {
        super(context, eVar);
        this.d = false;
        this.e = null;
    }

    public void a(a aVar) {
        this.a = aVar;
    }

    public void a(com.style.widget.e.f fVar) {
        this.b = fVar;
    }

    public void a(String str) {
        this.e = str;
    }

    public String a() {
        return this.e;
    }

    public boolean b() {
        return this.d && this.e != null;
    }

    public void a(int i, int i2, int[] iArr) {
        if (iArr != null && iArr.length == 2) {
            int width = getWidth();
            int height = getHeight();
            Context context = getContext();
            if (width <= 0 || height <= 0) {
                if (i <= 0) {
                    i = bv.b(context);
                }
                if (i2 <= 0) {
                    i2 = bv.c(context);
                }
                measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE));
                width = getMeasuredWidth();
                height = getMeasuredHeight();
            }
            iArr[0] = bv.b(context, width);
            iArr[1] = bv.b(context, height);
        }
    }

    @Override // com.component.a.d.c, android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && this.a != null) {
            this.a.a(getWidth(), getHeight());
        }
    }

    @Override // com.component.a.d.c, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.a != null) {
            this.a.a(this, motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.component.a.d.c, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.d = true;
        if (this.a != null) {
            this.a.a();
        }
        if (this.b != null) {
            this.b.d();
        }
    }

    @Override // com.component.a.d.c, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.d = false;
        if (this.b != null) {
            this.b.e();
        }
    }

    @Override // com.component.a.d.c, android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.b != null) {
            this.b.a(view, i);
        }
    }

    @Override // com.component.a.d.c, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.b != null) {
            this.b.a(i);
        }
    }

    @Override // com.component.a.d.c, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.b != null) {
            this.b.a(z);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.a != null) {
            return this.a.a(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void c() {
        if (this.b != null) {
            this.b.f();
            this.b = null;
        }
    }
}
