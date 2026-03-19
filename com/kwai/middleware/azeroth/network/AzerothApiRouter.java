package com.kwai.middleware.azeroth.network;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class AzerothApiRouter implements IApiRouter {
    @Override // com.kwai.middleware.azeroth.network.IApiRouter
    public String getHost() {
        return AzerothApiManager.get().getHost();
    }

    @Override // com.kwai.middleware.azeroth.network.IApiRouter
    public void switchHost() {
        AzerothApiManager.get().switchHost();
    }
}
