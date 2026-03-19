package com.style.widget.viewpager2;

import android.os.Handler;
import com.baidu.mobads.container.util.cf;
import com.style.widget.viewpager2.ViewPager2;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class AutoBannerHelper {
    private static final int UPDATE_INTERVAL = 100;
    private PagerIndicatorView mIndicatorView;
    private ViewPager2 mViewPager;
    private final Handler mCountdownHandler = new Handler();
    private long autoScrollInterval = -1;
    private long currentTimeMillis = 0;
    private int pagerCount = 0;
    private boolean isStarted = true;
    private int prevItem = 0;
    private final cf.a mUpdateRunnable = new cf.a() { // from class: com.style.widget.viewpager2.AutoBannerHelper.1
        @Override // com.baidu.mobads.container.util.cf.a
        public void safeRun() {
            if (AutoBannerHelper.this.autoScrollInterval > 0 && AutoBannerHelper.this.mIndicatorView != null) {
                AutoBannerHelper.this.mIndicatorView.setCurrentProgress(AutoBannerHelper.this.currentTimeMillis / AutoBannerHelper.this.autoScrollInterval);
                if (AutoBannerHelper.this.currentTimeMillis >= AutoBannerHelper.this.autoScrollInterval) {
                    AutoBannerHelper.this.onTimeUp();
                } else {
                    AutoBannerHelper.access$214(AutoBannerHelper.this, 100L);
                    AutoBannerHelper.this.mCountdownHandler.postDelayed(this, 100L);
                }
            }
        }
    };

    static /* synthetic */ long access$214(AutoBannerHelper autoBannerHelper, long j) {
        long j2 = autoBannerHelper.currentTimeMillis + j;
        autoBannerHelper.currentTimeMillis = j2;
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTimeUp() {
        if (this.mViewPager != null) {
            int currentItem = this.mViewPager.getCurrentItem() + 1;
            if (currentItem < this.pagerCount) {
                this.mViewPager.setCurrentItem(currentItem);
                return;
            }
            stopTimer();
            if (this.mIndicatorView != null) {
                this.mIndicatorView.setCurrentProgress(1.0f);
            }
        }
    }

    private boolean isIndicatorVisible() {
        return this.mIndicatorView != null && this.mIndicatorView.getVisibility() == 0;
    }

    public void bindWithViewPager(ViewPager2 viewPager2) {
        this.mViewPager = viewPager2;
        this.mViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.style.widget.viewpager2.AutoBannerHelper.2
            @Override // com.style.widget.viewpager2.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i) {
                if (i == 0) {
                    int currentItem = AutoBannerHelper.this.mViewPager.getCurrentItem();
                    if (AutoBannerHelper.this.prevItem != currentItem) {
                        AutoBannerHelper.this.prevItem = currentItem;
                        AutoBannerHelper.this.startTimerInternal();
                        return;
                    } else {
                        AutoBannerHelper.this.resumeTimerInternal();
                        return;
                    }
                }
                AutoBannerHelper.this.stopTimerInternal();
            }

            @Override // com.style.widget.viewpager2.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                if (AutoBannerHelper.this.isStarted && AutoBannerHelper.this.mIndicatorView != null) {
                    AutoBannerHelper.this.mIndicatorView.setCurrentProgress(0.0f);
                }
            }
        });
        final RVAdapter<?> adapter = this.mViewPager.getAdapter();
        this.prevItem = this.mViewPager.getCurrentItem();
        if (adapter != null) {
            this.pagerCount = adapter.getItemCount();
        }
        if (adapter instanceof PageItemAdapter) {
            ((PageItemAdapter) adapter).registerAdapterDataObserver(new ViewPager2.DataSetChangeObserver() { // from class: com.style.widget.viewpager2.AutoBannerHelper.3
                @Override // com.style.widget.viewpager2.ViewPager2.DataSetChangeObserver
                public void onChanged() {
                    AutoBannerHelper.this.pagerCount = adapter.getItemCount();
                }
            });
        }
    }

    public void bindWithIndicator(PagerIndicatorView pagerIndicatorView) {
        this.mIndicatorView = pagerIndicatorView;
    }

    public void setAutoScrollInterval(long j) {
        this.autoScrollInterval = j;
    }

    public void startTimer() {
        this.isStarted = true;
        this.currentTimeMillis = 0L;
        postTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTimerInternal() {
        if (this.isStarted) {
            this.currentTimeMillis = 0L;
            postTimer();
        }
    }

    public void resumeTimer() {
        resumeTimerInternal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeTimerInternal() {
        if (this.isStarted) {
            postTimer();
        }
    }

    private void postTimer() {
        if (this.autoScrollInterval <= 0 || !isIndicatorVisible()) {
            return;
        }
        if (this.currentTimeMillis >= this.autoScrollInterval) {
            this.currentTimeMillis = 0L;
        }
        this.mCountdownHandler.removeCallbacksAndMessages(null);
        this.mCountdownHandler.post(this.mUpdateRunnable);
    }

    public void pauseTimer() {
        stopTimerInternal();
    }

    public void stopTimer() {
        this.isStarted = false;
        stopTimerInternal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopTimerInternal() {
        if (this.autoScrollInterval <= 0) {
            return;
        }
        this.mCountdownHandler.removeCallbacksAndMessages(null);
    }
}
