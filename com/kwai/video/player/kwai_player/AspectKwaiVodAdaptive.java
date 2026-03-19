package com.kwai.video.player.kwai_player;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AspectKwaiVodAdaptive {
    private final KwaiMediaPlayer mPlayer;
    private String mRateConfig;

    public AspectKwaiVodAdaptive(KwaiMediaPlayer kwaiMediaPlayer, boolean z) {
        this.mPlayer = kwaiMediaPlayer;
    }

    public void setAbrConfig(String str) {
        this.mPlayer.setOption(1, "abr-config-string", str);
    }

    public void setDeviceResolution(int i, int i2) {
        this.mPlayer.setOption(1, "device-resolution-width", i);
        this.mPlayer.setOption(1, "device-resolution-height", i2);
    }
}
