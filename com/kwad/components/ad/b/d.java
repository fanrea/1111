package com.kwad.components.ad.b;

import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface d extends com.kwad.sdk.components.b {
    View a(ViewGroup viewGroup, int i);

    boolean a(KSFrameLayout kSFrameLayout, KsAdVideoPlayConfig ksAdVideoPlayConfig);

    void loadConfigFeedAd(KsScene ksScene, KsLoadManager.FeedAdListener feedAdListener);

    void loadFeedAd(KsScene ksScene, KsLoadManager.FeedAdListener feedAdListener);
}
