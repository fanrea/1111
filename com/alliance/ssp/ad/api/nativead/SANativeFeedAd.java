package com.alliance.ssp.ad.api.nativead;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.alliance.ssp.ad.api.BaseAllianceAd;
import com.alliance.ssp.ad.api.expressfeed.SAExpressFeedAdVideoListener;
import com.alliance.ssp.ad.x.b;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface SANativeFeedAd extends BaseAllianceAd {
    int getAdInteractionType();

    int getAdMode();

    void registerView(Activity activity, ViewGroup viewGroup, List<View> list, b bVar);

    void setExpressFeedAdVideoListener(SAExpressFeedAdVideoListener sAExpressFeedAdVideoListener);

    void setNativeFeedInteractionListener(View view, SANativeFeedAdInteractionListener sANativeFeedAdInteractionListener);
}
