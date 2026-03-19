package com.alliance.ssp.ad.api.expressfeed;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface SAExpressFeedAdInteractionListener {
    void onAdClick();

    void onAdClose();

    void onAdShow();

    void onRenderFail(int i, String str);

    void onRenderSuccess(View view);
}
