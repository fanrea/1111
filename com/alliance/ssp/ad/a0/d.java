package com.alliance.ssp.ad.a0;

import android.media.MediaPlayer;
import android.view.SurfaceHolder;

/* compiled from: NMStreamAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class d implements SurfaceHolder.Callback {
    public final /* synthetic */ String a;
    public final /* synthetic */ b b;

    public d(b bVar, String str) {
        this.b = bVar;
        this.a = str;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.b.M0.set(true);
        b bVar = this.b;
        MediaPlayer mediaPlayer = bVar.K0;
        if (mediaPlayer != null) {
            mediaPlayer.setDisplay(surfaceHolder);
        } else {
            bVar.c(this.a);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.b.Q0.removeCallbacksAndMessages(null);
        this.b.M0.set(false);
        b.a(this.b);
        this.b.E0.setChecked(false);
    }
}
