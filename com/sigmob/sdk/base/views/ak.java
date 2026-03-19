package com.sigmob.sdk.base.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ak extends v {
    private aj a;
    private f b;
    private boolean c;

    public ak(Context context) {
        super(context);
        this.c = false;
        c();
    }

    public ak(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.c = false;
        c();
    }

    public ak(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.c = false;
        c();
    }

    private void c() {
        f fVar = new f(getContext());
        this.b = fVar;
        addView(fVar, new RelativeLayout.LayoutParams(-1, -1));
        this.a = new aj(getContext());
        addView(this.a, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.sigmob.sdk.base.views.v
    public void a() {
        this.c = true;
    }

    public void a(float progress) {
        aj ajVar = this.a;
        if (ajVar == null || !this.c) {
            return;
        }
        ajVar.a(progress);
    }

    @Override // com.sigmob.sdk.base.views.v
    public void b() {
        this.c = false;
        aj ajVar = this.a;
        if (ajVar == null) {
            return;
        }
        ajVar.a(0.0f);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }
}
