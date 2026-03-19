package com.ss.texturerender.vsync;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface IVsyncHelper {
    public static final int MSG_ADD_OBSERVER = 29;
    public static final int MSG_REMOVE_OBSERVER = 30;
    public static final int MSG_VSYNC_COMING = 28;

    void addObserver(IVsyncCallback iVsyncCallback);

    boolean isWorking();

    void removeObserver(IVsyncCallback iVsyncCallback);

    void setEnable(boolean z);

    void update();
}
