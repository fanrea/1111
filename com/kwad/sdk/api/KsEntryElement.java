package com.kwad.sdk.api;

import android.content.Context;
import android.view.View;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.core.KsAdSdkApi;

@KsAdSdkApi
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface KsEntryElement {

    @KsAdSdkApi
    public @interface EntranceType {
        public static final int ENTRYTYPE_BLUR = 4;
        public static final int ENTRYTYPE_GIF = 3;
        public static final int ENTRYTYPE_HOT_LIST = 6;
        public static final int ENTRYTYPE_SCROOLTYPE = 2;
        public static final int ENTRYTYPE_TAB = 5;
        public static final int ENTRYTYPE_TWOSINGLE = 1;
    }

    @KsAdSdkApi
    public interface OnFeedClickListener {
        @KsAdSdkApi
        void handleFeedClick(int i, int i2, View view);
    }

    @KsAdSdkApi
    View getEntryView(Context context, OnFeedClickListener onFeedClickListener);

    @KsAdSdkApi
    int getEntryViewType();

    @KsAdSdkApi
    void refresh();

    @KsAdSdkApi
    void setEnableSlideAutoOpen(boolean z);

    @KsAdSdkApi
    void setPageListener(KsContentPage.PageListener pageListener);

    @KsAdSdkApi
    void setShareListener(KsContentPage.KsShareListener ksShareListener);

    @KsAdSdkApi
    void setTouchIntercept(boolean z);

    @KsAdSdkApi
    void setVideoListener(KsContentPage.VideoListener videoListener);
}
