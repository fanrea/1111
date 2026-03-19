package com.baidu.mobads.container.x;

import android.media.MediaPlayer;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.component.player.AdVideoViewListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class n implements AdVideoViewListener {
    final /* synthetic */ k a;

    n(k kVar) {
        this.a = kVar;
    }

    @Override // com.component.player.AdVideoViewListener
    public void playCompletion() {
        this.a.o = true;
        this.a.p();
        this.a.q();
        this.a.a(true);
        if (this.a.r != null) {
            this.a.r.a((MediaPlayer) null);
        }
    }

    @Override // com.component.player.AdVideoViewListener
    public void playFailure(String str) {
        this.a.p();
        this.a.a(true);
    }

    @Override // com.component.player.AdVideoViewListener
    public void renderingStart() {
        this.a.a(false);
        int iH = this.a.t.h();
        int iL = this.a.t.l();
        if (iH > 0) {
            this.a.f.setMax(iH);
            this.a.f.setProgress(iL);
            int i = iH / 1000;
            long j = i % 60;
            long j2 = (i / 60) % 60;
            long j3 = (i / 3600) % 24;
            if (iL == 0) {
                if (j3 > 0) {
                    this.a.j.setText("00:00:00");
                } else {
                    this.a.j.setText("00:00");
                }
            }
            if (j3 > 0) {
                this.a.i.setText(String.format("%d:%02d:%02d", Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j)));
            } else {
                this.a.i.setText(String.format("%02d:%02d", Long.valueOf(j2), Long.valueOf(j)));
            }
        }
        this.a.e.setVisibility(0);
        this.a.y.removeMessages(10);
        this.a.y.sendEmptyMessageDelayed(10, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        if (this.a.r != null) {
            this.a.r.a();
        }
    }

    @Override // com.component.player.AdVideoViewListener
    public void playStart() {
    }

    @Override // com.component.player.AdVideoViewListener
    public void playStop() {
    }

    @Override // com.component.player.AdVideoViewListener
    public void playPause() {
        if (this.a.r != null) {
            this.a.r.d();
        }
    }

    @Override // com.component.player.AdVideoViewListener
    public void playResume() {
        if (this.a.r != null) {
            this.a.r.e();
        }
    }
}
