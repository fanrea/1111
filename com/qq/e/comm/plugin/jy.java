package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Pair;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class jy extends RecyclerView implements el<hy> {
    private w40 a;

    @Override // com.qq.e.comm.plugin.el
    public void a(ao aoVar) {
    }

    public jy(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onMeasure(int i, int i2) {
        v40 v40VarV = this.a.v();
        if (v40VarV == null) {
            super.onMeasure(i, i2);
            return;
        }
        Pair<Integer, Integer> pairB = v40VarV.b(i, i2);
        super.onMeasure(((Integer) pairB.first).intValue(), ((Integer) pairB.second).intValue());
        Pair<Integer, Integer> pairA = v40VarV.a(i, i2);
        if (pairA != null) {
            super.setMeasuredDimension(View.MeasureSpec.getSize(((Integer) pairA.first).intValue()), View.MeasureSpec.getSize(((Integer) pairA.second).intValue()));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void draw(Canvas canvas) {
        int width;
        int height;
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
    }

    @Override // com.qq.e.comm.plugin.dl
    public void a(hy hyVar) {
        this.a = hyVar;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        w40 w40Var = this.a;
        if (w40Var != null) {
            w40Var.a(view, i);
        }
    }
}
