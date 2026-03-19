package com.alliance.ssp.ad.api.nativead;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface SANativeFeedAdInteractionListener {
    void onAdClick();

    void onAdShow();

    void onRenderFail(int i, String str);

    void onRenderSuccess(View view);
}
