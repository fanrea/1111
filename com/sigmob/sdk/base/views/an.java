package com.sigmob.sdk.base.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class an extends v {
    private am a;
    private e b;
    private boolean c;

    public an(Context context) {
        super(context);
        this.c = false;
        View fVar = new f(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView(fVar, layoutParams);
        this.b = new e(context);
        this.a = new am(context);
        this.b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.b);
        addView(this.a);
        c();
    }

    public an(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.c = false;
        c();
    }

    public an(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.c = false;
        c();
    }

    private void c() {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sigmob.sdk.base.views.an.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                an.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                an.this.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int width = (int) (getWidth() * 0.25f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, (int) (width * 1.62f));
        layoutParams.setMargins(0, (int) (getHeight() * 0.38f), 0, 0);
        layoutParams.addRule(14);
        this.a.setLayoutParams(layoutParams);
    }

    @Override // com.sigmob.sdk.base.views.v
    public void a() {
        this.c = true;
        am amVar = this.a;
        if (amVar != null) {
            amVar.a();
        }
    }

    public void a(float process) {
        e eVar = this.b;
        if (eVar == null || !this.c) {
            return;
        }
        eVar.a(process);
    }

    @Override // com.sigmob.sdk.base.views.v
    public void b() {
        this.c = false;
        e eVar = this.b;
        if (eVar != null) {
            eVar.a(0.0f);
        }
        am amVar = this.a;
        if (amVar != null) {
            amVar.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.c) {
            a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        c();
    }
}
