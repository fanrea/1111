package com.baidu.mobads.container.x;

import android.media.MediaPlayer;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.component.player.AdVideoViewListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class c implements AdVideoViewListener {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    @Override // com.component.player.AdVideoViewListener
    public void playCompletion() {
        this.a.h();
        if (this.a.g != null) {
            this.a.g.a((MediaPlayer) null);
        }
    }

    @Override // com.component.player.AdVideoViewListener
    public void playFailure(String str) {
        this.a.d(true);
    }

    @Override // com.component.player.AdVideoViewListener
    public void renderingStart() {
        this.a.d(false);
        this.a.a();
        this.a.k.removeMessages(12);
        this.a.k.sendEmptyMessageDelayed(12, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    @Override // com.component.player.AdVideoViewListener
    public void playStart() {
    }

    @Override // com.component.player.AdVideoViewListener
    public void playStop() {
    }

    @Override // com.component.player.AdVideoViewListener
    public void playPause() {
    }

    @Override // com.component.player.AdVideoViewListener
    public void playResume() {
    }
}
