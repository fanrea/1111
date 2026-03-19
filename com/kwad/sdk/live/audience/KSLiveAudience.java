package com.kwad.sdk.live.audience;

import com.kuaishou.live.longconnection.LiveLongConnection;
import com.kwad.sdk.live.audience.listener.KSLiveStateListener;
import com.kwad.sdk.live.audience.player.KSLivePlayerController;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface KSLiveAudience {
    void destroy();

    LiveLongConnection getLongConnection();

    KSLivePlayerController getPlayerController();

    void init();

    void pause();

    void resume();

    void setLiveStateListener(KSLiveStateListener kSLiveStateListener);
}
