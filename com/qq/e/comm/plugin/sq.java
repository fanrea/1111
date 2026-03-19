package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.NinePatch;
import android.graphics.drawable.NinePatchDrawable;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class sq extends ImageView implements dl {
    private p4 a;
    private bq b;
    protected int c;
    protected int d;

    public sq(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.a.f(i);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        p4 p4Var = this.a;
        if (p4Var != null) {
            p4Var.a(view, i);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        v40<sq> v40VarV = this.a.v();
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

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        int height;
        p4 p4Var = this.a;
        xj xjVarS = p4Var == null ? null : p4Var.s();
        if (xjVarS != null) {
            width = getWidth();
            height = getHeight();
            xjVarS.a(canvas, width, height);
        } else {
            width = 0;
            height = 0;
        }
        bq bqVar = this.b;
        if (bqVar == null) {
            a(canvas);
            super.onDraw(canvas);
        } else {
            bqVar.a(canvas);
        }
        if (xjVarS != null) {
            xjVarS.b(canvas, width, height);
        }
    }

    private void a(Canvas canvas) {
        if (this.c <= 0 || this.d <= 0 || this.a == null) {
            return;
        }
        int height = getHeight();
        int width = getWidth();
        if (height <= 0 || width <= 0 || this.a.P() != 3) {
            return;
        }
        double d = height;
        double d2 = width;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = d / d2;
        int i = this.d;
        double d4 = i;
        int i2 = this.c;
        double d5 = i2;
        Double.isNaN(d4);
        Double.isNaN(d5);
        if (d3 <= d4 / d5) {
            getDrawable().setBounds(0, 0, width, (i * width) / i2);
        } else {
            int i3 = (((i2 * height) / i) - width) / 2;
            getDrawable().setBounds(-i3, 0, width + i3, height);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        byte[] ninePatchChunk = bitmap.getNinePatchChunk();
        if (ninePatchChunk != null && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            super.setImageDrawable(new NinePatchDrawable(bitmap, ninePatchChunk, null, null));
        } else {
            super.setImageBitmap(bitmap);
        }
        this.c = bitmap.getWidth();
        this.d = bitmap.getHeight();
    }

    public void a(Movie movie) {
        if (movie == null) {
            return;
        }
        this.b = new bq(this.a, this, movie);
    }

    @Override // com.qq.e.comm.plugin.dl
    public void a(w40 w40Var) {
        this.a = (p4) w40Var;
    }
}
