package com.kwad.sdk.core.response.model;

import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AdVideoPreCacheConfig extends com.kwad.sdk.core.response.a.a implements Serializable {
    public static final int DEFAULT_PRE_CACHE_SIZE = 800;
    private static final long serialVersionUID = -3793189825357939577L;
    public int adVideoPreCacheSize;
    public boolean continueLoadingAll;

    public AdVideoPreCacheConfig(int i, boolean z) {
        this.adVideoPreCacheSize = i;
        this.continueLoadingAll = z;
    }

    public AdVideoPreCacheConfig() {
        this.adVideoPreCacheSize = 800;
    }

    public int getAdVideoPreCacheSize() {
        return this.adVideoPreCacheSize;
    }

    public void setAdVideoPreCacheSize(int i) {
        this.adVideoPreCacheSize = i;
    }

    public boolean isContinueLoadingAll() {
        return this.continueLoadingAll;
    }

    public void setContinueLoadingAll(boolean z) {
        this.continueLoadingAll = z;
    }
}
