package com.baidu.mobads.container.rewardvideo;

import android.view.View;
import com.component.a.f.a;
import com.component.a.g.a;
import com.component.a.g.g;
import com.style.widget.viewpager2.PageItem;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class dm extends NativeRewardActivity {
    private int d;
    private boolean e;
    private final AtomicBoolean f;

    public dm(com.baidu.mobads.container.adrequest.t tVar, PageItem pageItem) {
        super(tVar, pageItem);
        this.d = -100;
        this.e = false;
        this.f = new AtomicBoolean(false);
        this.showAdType = "image";
    }

    @Override // com.baidu.mobads.container.rewardvideo.NativeRewardActivity
    protected void initVideoView() {
        this.d = -100;
    }

    @Override // com.baidu.mobads.container.rewardvideo.NativeRewardActivity
    protected com.component.a.e.d.b onAdjustAdapterParams(a.C0317a c0317a) {
        c0317a.a(this.mSharedParent);
        if (isFirstPage()) {
            c0317a.a(a.b.SHARE);
        }
        return new com.component.a.e.d.b(true);
    }

    @Override // com.baidu.mobads.container.rewardvideo.NativeRewardActivity
    protected JSONObject getOptimizedTemplateJson(com.component.a.g.d dVar, g.a aVar) {
        JSONObject optimizedTemplateJson = super.getOptimizedTemplateJson(dVar, aVar);
        this.mDuration = Math.max(60, this.mRewardTime);
        return optimizedTemplateJson;
    }

    @Override // com.baidu.mobads.container.rewardvideo.NativeRewardActivity
    protected void onViewCreate(View view, String str, String str2) {
    }

    @Override // com.baidu.mobads.container.rewardvideo.NativeRewardActivity
    protected void onNativeRenderComplete(View view) {
        super.onNativeRenderComplete(view);
        onInitializeComponents(this.mDuration);
        this.mNativeShakeView = null;
        this.mEggLottieView = null;
        this.mRewardCountdownView = null;
        if (isFirstPage()) {
            startTimer();
            processAdStart();
        }
        this.e = true;
        b();
    }

    private void b() {
        if (this.isCurrentPageResumed && this.e && this.f.compareAndSet(false, true)) {
            sendRVideoLog(5);
            dp.a(this.fatherOfFullScreen, this.mAdInstanceInfo, this.mAdContainerCxt);
            this.mSendImpressionLog.set(true);
        }
    }

    @Override // com.baidu.mobads.container.rewardvideo.NativeRewardActivity
    public void videoResume() {
        super.videoResume();
        b();
    }

    @Override // com.baidu.mobads.container.rewardvideo.NativeRewardActivity
    public void videoPause(int i, int i2) {
    }

    @Override // com.baidu.mobads.container.rewardvideo.NativeRewardActivity
    protected void onTimeUp() {
        super.onTimeUp();
        showSkipView();
    }

    @Override // com.baidu.mobads.container.rewardvideo.NativeRewardActivity
    protected int getCurrentTimeMillis() {
        this.d += 100;
        return this.d;
    }

    @Override // com.baidu.mobads.container.rewardvideo.NativeRewardActivity
    protected boolean isLastPage() {
        return true;
    }

    @Override // com.baidu.mobads.container.rewardvideo.NativeRewardActivity
    protected void addEndPage() {
        handleCloseAd();
    }

    @Override // com.baidu.mobads.container.rewardvideo.NativeRewardActivity
    protected int getUserRewardTime() {
        return this.mRewardTime;
    }
}
