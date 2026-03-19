package com.sigmob.sdk.base;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public enum j {
    AppSWith(1),
    AutoNextPreload(2),
    NormalRequest(3),
    SplashCloseRequest(5),
    ReloadAfterExpiration(6),
    ActiveFailureReload(7),
    OtherRequest(999);

    private final int h;

    j(int type) {
        this.h = type;
    }

    public int a() {
        return this.h;
    }
}
