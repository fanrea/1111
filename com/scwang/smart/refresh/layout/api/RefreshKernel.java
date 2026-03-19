package com.scwang.smart.refresh.layout.api;

import android.animation.Animator;
import android.animation.ValueAnimator;
import com.scwang.smart.refresh.layout.constant.RefreshState;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface RefreshKernel {
    ValueAnimator animSpinner(int i);

    RefreshKernel finishTwoLevel();

    RefreshContent getRefreshContent();

    RefreshLayout getRefreshLayout();

    RefreshKernel moveSpinner(int i, boolean z);

    RefreshKernel onAutoLoadMoreAnimationEnd(Animator animator, boolean z);

    RefreshKernel onAutoRefreshAnimationEnd(Animator animator, boolean z);

    RefreshKernel requestDefaultTranslationContentFor(RefreshComponent refreshComponent, boolean z);

    RefreshKernel requestDrawBackgroundFor(RefreshComponent refreshComponent, int i);

    RefreshKernel requestFloorBottomPullUpToCloseRate(float f);

    RefreshKernel requestFloorDuration(int i);

    RefreshKernel requestNeedTouchEventFor(RefreshComponent refreshComponent, boolean z);

    RefreshKernel requestRemeasureHeightFor(RefreshComponent refreshComponent);

    RefreshKernel setState(RefreshState refreshState);

    RefreshKernel startTwoLevel(boolean z);
}
