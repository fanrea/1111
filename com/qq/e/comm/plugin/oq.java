package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class oq extends h60 implements el {
    private w40 c;
    private ao d;

    public oq(Context context) {
        super(context);
    }

    @Override // com.qq.e.comm.plugin.h60, android.view.View
    protected void onMeasure(int i, int i2) {
        w40 w40Var = this.c;
        if (w40Var != null) {
            v40 v40VarV = w40Var.v();
            if (v40VarV instanceof ue) {
                ao aoVar = this.d;
                if (aoVar != null) {
                    aoVar.d();
                }
                v40VarV.b(i, i2);
                super.onMeasure(i, i2);
                if (!(getParent() instanceof oq)) {
                    ViewGroup.LayoutParams layoutParams = getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).setMargins((int) a().a(d60.LEFT), (int) a().a(d60.TOP), (int) a().a(d60.BOTTOM), (int) a().a(d60.RIGHT));
                    }
                }
                ao aoVar2 = this.d;
                if (aoVar2 != null) {
                    aoVar2.b();
                    return;
                }
                return;
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // com.qq.e.comm.plugin.h60, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ao aoVar = this.d;
        if (aoVar != null) {
            aoVar.c();
        }
        super.onLayout(z, i, i2, i3, i4);
        ao aoVar2 = this.d;
        if (aoVar2 != null) {
            aoVar2.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        ao aoVar = this.d;
        if (aoVar != null) {
            aoVar.b(false);
        }
        super.dispatchDraw(canvas);
        ao aoVar2 = this.d;
        if (aoVar2 != null) {
            aoVar2.a(false);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int width;
        int height;
        ao aoVar = this.d;
        if (aoVar != null) {
            aoVar.b(true);
        }
        w40 w40Var = this.c;
        xj xjVarS = w40Var == null ? null : w40Var.s();
        if (xjVarS != null) {
            width = getWidth();
            height = getHeight();
            xjVarS.a(canvas, width, height);
        } else {
            width = 0;
            height = 0;
        }
        super.draw(canvas);
        if (xjVarS != null) {
            xjVarS.b(canvas, width, height);
        }
        ao aoVar2 = this.d;
        if (aoVar2 != null) {
            aoVar2.a(true);
        }
    }

    @Override // com.qq.e.comm.plugin.el
    public void a(ao aoVar) {
        this.d = aoVar;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        w40 w40Var = this.c;
        if (w40Var != null) {
            w40Var.a(view, i);
        }
    }

    @Override // com.qq.e.comm.plugin.dl
    public void a(w40 w40Var) {
        this.c = w40Var;
    }
}
