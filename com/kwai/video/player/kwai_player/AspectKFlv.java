package com.kwai.video.player.kwai_player;

import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AspectKFlv {
    private final KwaiMediaPlayer mPlayer;

    public AspectKFlv(KwaiMediaPlayer kwaiMediaPlayer, boolean z) {
        this.mPlayer = kwaiMediaPlayer;
        kwaiMediaPlayer.setOption(4, "enable-live-manifest", z ? 1L : 0L);
    }

    public void setLiveAdaptiveConfig(String str) {
        KwaiMediaPlayer kwaiMediaPlayer = this.mPlayer;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        kwaiMediaPlayer.setOption(1, "liveAdaptConfig", str);
    }

    public boolean isLiveManifest() {
        return this.mPlayer._isLiveManifest();
    }
}
