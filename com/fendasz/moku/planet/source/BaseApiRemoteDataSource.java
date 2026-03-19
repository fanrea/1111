package com.fendasz.moku.planet.source;

import android.content.Context;
import com.fendasz.moku.planet.common.network.CompanyNetworkManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class BaseApiRemoteDataSource<T> {
    private T api;

    public BaseApiRemoteDataSource(Context context, Class<T> cls) {
        this.api = (T) CompanyNetworkManager.getApiInstance(context).create(cls);
    }

    protected T getApi() {
        return this.api;
    }
}
