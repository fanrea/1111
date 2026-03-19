package com.alliance.ssp.ad.api.unifiedfeed;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.alliance.ssp.ad.api.BaseAllianceAd;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface SAUnifiedFeedAd extends BaseAllianceAd {
    void bindAdToView(ViewGroup viewGroup, List<View> list, SAUnifiedFeedAdInteractionListener sAUnifiedFeedAdInteractionListener);

    Bitmap getAdLogo();

    String getDescription();

    int getFeedAdInteractionType();

    int getFeedAdMode();

    List<String> getImageList();

    String getTitle();

    void resume();

    void setUnifiedFeedAdVideoListener(SAUnifiedFeedAdVideoListener sAUnifiedFeedAdVideoListener);
}
