package com.bytedance.sdk.djx.core.business.base;

import com.bytedance.sdk.djx.core.business.base.BaseContract;
import com.bytedance.sdk.djx.core.business.base.BaseContract.BaseView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class PresenterAbstract<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {
    protected T mView;

    @Override // com.bytedance.sdk.djx.core.business.base.BaseContract.BasePresenter
    public void attach(T t) {
        this.mView = t;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.BaseContract.BasePresenter
    public void detach() {
        this.mView = null;
    }
}
