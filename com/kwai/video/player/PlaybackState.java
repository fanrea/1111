package com.kwai.video.player;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface PlaybackState {
    public static final int MP_STATE_ASYNC_PREPARING = 2;
    public static final int MP_STATE_COMPLETED = 6;
    public static final int MP_STATE_END = 9;
    public static final int MP_STATE_ERROR = 8;
    public static final int MP_STATE_IDLE = 0;
    public static final int MP_STATE_INITIALIZED = 1;
    public static final int MP_STATE_PAUSED = 5;
    public static final int MP_STATE_PREPARED = 3;
    public static final int MP_STATE_STARTED = 4;
    public static final int MP_STATE_STOPPED = 7;
    public static final String[] STATE_STRING = {"MP_STATE_IDLE", "MP_STATE_INITIALIZED", "MP_STATE_ASYNC_PREPARING", "MP_STATE_PREPARED", "MP_STATE_STARTED", "MP_STATE_PAUSED", "MP_STATE_COMPLETED", "MP_STATE_STOPPED", "MP_STATE_ERROR", "MP_STATE_END"};

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public @interface State {
    }
}
