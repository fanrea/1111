package com.kwai.player.debuginfo.model;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KwaiPlayerDebugInfo {
    public AppLiveQosDebugInfo mAppLiveQosDebugInfo;
    public AppLiveQosDebugInfoNew mAppLiveQosDebugInfoNew;
    public AppVodQosDebugInfoNew mAppVodQosDebugInfo;
    private boolean mIsLive = false;
    public PlayerConfigDebugInfo mPlayerApplyConfig = new PlayerConfigDebugInfo();
    public String mSdkVersion;

    public boolean isLive() {
        return this.mIsLive;
    }

    public void setIsLive(boolean z) {
        this.mIsLive = z;
    }
}
