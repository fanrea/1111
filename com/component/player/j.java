package com.component.player;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class j extends TextureView implements TextureView.SurfaceTextureListener, q {
    private int i;
    private int j;
    private int k;
    private final WeakReference<r> l;
    private boolean m;
    private SurfaceTexture n;

    public j(Context context, r rVar) {
        super(context);
        this.i = 1;
        this.m = false;
        this.l = new WeakReference<>(rVar);
        setSurfaceTextureListener(this);
    }

    public void a(boolean z) {
        this.m = z;
    }

    @Override // android.view.View
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

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.m) {
            this.n = surfaceTexture;
        }
        r rVar = this.l.get();
        if (rVar != null) {
            rVar.a(new Surface(surfaceTexture));
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        r rVar = this.l.get();
        if (rVar != null) {
            rVar.a();
        }
        this.n = surfaceTexture;
        return !this.m;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // com.component.player.q
    public void b() {
        if (this.n != null) {
            setSurfaceTexture(this.n);
        }
    }
}
