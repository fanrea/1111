package com.bytedance.sdk.djx;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IDJXCustomView {

    public interface IDJXNotifyListener {
        void notifyDelete();
    }

    View bindHolder(int i, int i2);

    void createHolder(int i, int i2);

    void notifyListener(IDJXNotifyListener iDJXNotifyListener);

    void onDestroy();

    void selectHolder(int i, int i2);
}
