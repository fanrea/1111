package com.bytedance.sdk.djx.core.business.base;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface BaseContract {

    public interface BasePresenter<T extends BaseView> {
        void attach(T t);

        void detach();
    }

    public interface BaseView {
        Context getContext();

        void showError();
    }
}
