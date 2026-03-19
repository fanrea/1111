package com.qq.e.comm.plugin.dysi;

import com.qq.e.comm.plugin.j40;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public interface IGDTBiz {
    public static final String KEY_GDTBIZ = "GDTBiz";

    boolean isOnViewAppearanceChangedEnable();

    boolean isTimerTickEnable();

    void onApkStartInstall(String str);

    void onBizCustomEventTriggered(String str);

    void onDialogDismiss(int i);

    void onDialogShow(int i);

    void onGoAppStore(String str);

    void onLandingPageClose();

    void onLandingPageOpen();

    void onPageLoadEnd(String str);

    void onPageLoadStart(String str);

    void onPlayStateChange(j40 j40Var, int i);

    void onReward(int i);

    void onTimerTick(long j);

    void onVideoLandingPageClicked();

    void onViewAppearanceChanged(String str);

    void setObserveFlag(int i);
}
