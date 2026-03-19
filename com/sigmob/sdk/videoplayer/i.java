package com.sigmob.sdk.videoplayer;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.Surface;
import android.view.TextureView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class i implements TextureView.SurfaceTextureListener {
    public SurfaceTexture a;
    public Handler b;
    public Handler c;
    public h d;

    public i(h videoPlayerListener) {
        this.d = videoPlayerListener;
    }

    public abstract void a();

    public abstract void a(float leftVolume);

    public abstract void a(long time);

    public abstract void a(Surface surface);

    public abstract void a(boolean loop);

    public abstract void b();

    public abstract void b(float speed);

    public abstract void c();

    public abstract void d();

    public abstract boolean e();

    public abstract void f();

    public abstract long g();

    public abstract int h();

    public abstract int i();

    public abstract long j();
}
