package com.kwai.video.hodor;

import com.kwai.video.cache.AwesomeCacheInitConfig;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class AbstractHodorTask implements IHodorTask {
    private int mTaskQosClass = 0;
    private int mPriority = 3000;
    private int mConnectTimeoutMs = 3000;
    private int mMaxSpeedKbps = -1;
    protected String mBizType = "unknown";
    protected String mGroupName = "";

    static {
        AwesomeCacheInitConfig.waitSoLibReady();
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void setGroupName(String str) {
        this.mGroupName = str;
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void setBizType(String str) {
        this.mBizType = str;
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void setTaskQosClass(int i) {
        this.mTaskQosClass = i;
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void setPriority(int i) {
        this.mPriority = i;
    }

    public void setMaxSpeedKbps(int i) {
        this.mMaxSpeedKbps = i;
    }

    public void setConnectTimeoutMs(int i) {
        this.mConnectTimeoutMs = i;
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void submit(boolean z) {
        submit();
    }
}
