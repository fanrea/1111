package com.bytedance.sdk.djx;

import androidx.fragment.app.Fragment;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IDJXWidget {
    void backRefresh();

    boolean canBackPress();

    void destroy();

    int getCurrentDramaIndex();

    Fragment getFragment();

    android.app.Fragment getFragment2();

    @Deprecated
    Fragment getReportFragment();

    @Deprecated
    android.app.Fragment getReportFragment2();

    void openDramaGallery();

    void openMoreDialog();

    void refresh();

    void scrollToTop();

    void seekTo(long j);

    void setCurrentDramaIndex(int i);

    boolean setCurrentPage(int i);

    void setSpeedPlay(float f, DJXPlaySpeedScope dJXPlaySpeedScope);
}
