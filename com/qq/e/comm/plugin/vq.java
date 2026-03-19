package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class vq extends LinearLayout implements el {
    protected w40 a;
    private boolean b;
    private ao c;

    public vq(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.a.f(i);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        v40 v40VarV;
        w40 w40Var = this.a;
        if (w40Var != null && (v40VarV = w40Var.v()) != null) {
            ao aoVar = this.c;
            if (aoVar != null) {
                aoVar.d();
            }
            Pair<Integer, Integer> pairB = v40VarV.b(i, i2);
            super.onMeasure(((Integer) pairB.first).intValue(), ((Integer) pairB.second).intValue());
            Pair<Integer, Integer> pairA = v40VarV.a(i, i2);
            if (pairA != null) {
                super.onMeasure(((Integer) pairA.first).intValue(), ((Integer) pairA.second).intValue());
            }
            ao aoVar2 = this.c;
            if (aoVar2 != null) {
                aoVar2.b();
                return;
            }
            return;
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int width;
        int height;
        ao aoVar = this.c;
        if (aoVar != null) {
            aoVar.b(true);
        }
        w40 w40Var = this.a;
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
        ao aoVar2 = this.c;
        if (aoVar2 != null) {
            aoVar2.a(true);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        ao aoVar = this.c;
        if (aoVar != null) {
            aoVar.b(false);
        }
        super.dispatchDraw(canvas);
        ao aoVar2 = this.c;
        if (aoVar2 != null) {
            aoVar2.a(false);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        w40 w40Var = this.a;
        if (w40Var != null) {
            w40Var.a(view, i);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ao aoVar = this.c;
        if (aoVar != null) {
            aoVar.c();
        }
        this.b = true;
        super.onLayout(z, i, i2, i3, i4);
        this.b = false;
        ao aoVar2 = this.c;
        if (aoVar2 != null) {
            aoVar2.a();
        }
    }

    @Override // android.view.ViewGroup
    public View getChildAt(int i) {
        w40 w40Var;
        if (this.b && (w40Var = this.a) != null) {
            v40 v40VarV = w40Var.v();
            if ((v40VarV instanceof co) && ((co) v40VarV).k()) {
                return super.getChildAt((getChildCount() - i) - 1);
            }
        }
        return super.getChildAt(i);
    }

    @Override // com.qq.e.comm.plugin.el
    public void a(ao aoVar) {
        this.c = aoVar;
    }

    @Override // com.qq.e.comm.plugin.dl
    public void a(w40 w40Var) {
        this.a = w40Var;
    }
}
