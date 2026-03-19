package com.kwad.sdk;

import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompoInitConfig;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KsAdLive {
    private IAdLiveOfflineCompoInitConfig mInitConfig;

    static class Holder {
        private static final KsAdLive sInstance = new KsAdLive();

        private Holder() {
        }
    }

    private KsAdLive() {
    }

    public static KsAdLive get() {
        return Holder.sInstance;
    }

    public IAdLiveOfflineCompoInitConfig getConfig() {
        return this.mInitConfig;
    }

    void setConfig(IAdLiveOfflineCompoInitConfig iAdLiveOfflineCompoInitConfig) {
        this.mInitConfig = iAdLiveOfflineCompoInitConfig;
    }
}
