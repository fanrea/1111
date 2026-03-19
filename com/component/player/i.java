package com.component.player;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class i extends SurfaceView implements SurfaceHolder.Callback, q {
    private int i;
    private int j;
    private int k;
    private final WeakReference<p> l;

    public i(Context context, p pVar) {
        super(context);
        this.i = 1;
        this.l = new WeakReference<>(pVar);
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.j, i);
        int defaultSize2 = getDefaultSize(this.k, i2);
        if (this.j > 0 && this.k > 0) {
            switch (this.i) {
                case 0:
                    if (this.j * i2 > this.k * i && this.j * defaultSize2 > this.k * defaultSize) {
                        defaultSize2 = (this.k * defaultSize) / this.j;
                        break;
                    }
                    break;
                case 1:
                    if (this.j * defaultSize2 > this.k * defaultSize) {
                        defaultSize2 = (this.k * defaultSize) / this.j;
                        break;
                    } else if (this.j * defaultSize2 < this.k * defaultSize) {
                        defaultSize = (this.j * defaultSize2) / this.k;
                        break;
                    }
                    break;
                case 3:
                    defaultSize = this.j;
                    defaultSize2 = this.k;
                    break;
                case 4:
                    int i3 = defaultSize * 9;
                    int i4 = defaultSize2 * 16;
                    if (i3 < i4) {
                        defaultSize2 = i3 / 16;
                        break;
                    } else if (i3 > i4) {
                        defaultSize = i4 / 9;
                        break;
                    }
                    break;
                case 5:
                    int i5 = defaultSize * 3;
                    int i6 = defaultSize2 * 4;
                    if (i5 < i6) {
                        defaultSize2 = i5 / 4;
                        break;
                    } else if (i5 > i6) {
                        defaultSize = i6 / 3;
                        break;
                    }
                    break;
                case 6:
                    defaultSize = (this.j * defaultSize2) / this.k;
                    break;
                case 7:
                    if (this.j * defaultSize2 > this.k * defaultSize) {
                        defaultSize = (this.j * defaultSize2) / this.k;
                        break;
                    } else if (this.j * defaultSize2 < this.k * defaultSize) {
                        defaultSize2 = (this.k * defaultSize) / this.j;
                        break;
                    }
                    break;
            }
        }
        com.baidu.mobads.container.l.g.h("BaseSurfaceView").c(String.format("onMeasure.  measure size(%sx%s)", Integer.valueOf(this.j), Integer.valueOf(this.k)));
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // com.component.player.q
    public void a(int i, int i2) {
        this.j = i;
        this.k = i2;
        if (this.j != 0 && this.k != 0) {
            c();
        }
    }

    public int a() {
        return this.i;
    }

    @Override // com.component.player.q
    public void a(int i) {
        this.i = i;
    }

    private void c() {
        requestLayout();
        invalidate();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        p pVar = this.l.get();
        if (pVar != null) {
            pVar.a(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        p pVar = this.l.get();
        if (pVar != null) {
            pVar.a();
        }
    }

    @Override // com.component.player.q
    public void b() {
    }
}
