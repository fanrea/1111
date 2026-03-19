package com.kwai.video.ksliveplayer.model;

import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLivePlayerConfigModel implements Serializable {
    public boolean normalEnableCache = true;
    public boolean adaptiveEnableCache = true;
    public int cacheReadTimeOutMs = 15000;
    public int cacheConnectTimeOutMs = 5000;
    public float bufferTimeMaxSec = 6.0f;
    public String configJson = "\"{\"spd_chg_en\":1,\"live_adapt_frame_drop_buf_threshold\":11}\"";
    public int enableAsyncStreamOpen = -1;
    public boolean enableAlignedPts = false;
    public LiveRetryConfigModel liveRetryConfig = new LiveRetryConfigModel();

    public boolean enableAsyncStreamOpen() {
        return this.enableAsyncStreamOpen > 0;
    }
}
