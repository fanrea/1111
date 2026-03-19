package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.n;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class CpuChannelResponse {
    private n mCpuChannelInfo;

    public CpuChannelResponse(n nVar) {
        this.mCpuChannelInfo = nVar;
    }

    public int getChannelId() {
        n nVar = this.mCpuChannelInfo;
        if (nVar != null) {
            return nVar.a();
        }
        return -1;
    }

    public String getChannelName() {
        n nVar = this.mCpuChannelInfo;
        return nVar != null ? nVar.b() : "";
    }
}
