package com.kwai.video.ksvodplayerkit.prefetcher;

import android.content.Context;
import com.kwai.video.hodor.AbstractHodorPreloadTask;
import com.kwai.video.hodor.VodAdaptivePreloadPriorityTask;
import com.kwai.video.ksvodplayerkit.HttpDns.HostSwitcher;
import com.kwai.video.ksvodplayerkit.KSVodPlayerConfig;
import com.kwai.video.ksvodplayerkit.MultiRate.KSVodAdaptationModel;
import com.kwai.video.ksvodplayerkit.MultiRate.KwaiMediaManifest_JsonUtils;
import com.kwai.video.ksvodplayerkit.MultiRate.VideoAdaptationModel_JsonUtils;
import com.kwai.video.ksvodplayerkit.Utils.NetworkUtils;
import com.kwai.video.ksvodplayerkit.Utils.VodPlayerUtils;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AdaptivePrefetchModel extends BasePrefetchModel {
    private KSVodAdaptationModel mAdaptationModel;
    private VodAdaptivePreloadPriorityTask.VodAdaptiveInit mAdaptiveInit;
    private String mKwaiMediaManifest;
    private String mPrefetchUrl;

    public AdaptivePrefetchModel(String str, String str2, int i) {
        setupWithManifestV2(str, str2, i, 0);
    }

    public AdaptivePrefetchModel(String str, String str2, int i, int i2) {
        setupWithManifestV2(str, str2, i, i2);
    }

    private void setupWithManifestV2(String str, String str2, int i, int i2) {
        this.mIsSecondPreload = false;
        this.mPreloadType = i2;
        this.mKwaiMediaManifest = str;
        this.mPriority = i;
        this.mVideoId = str2;
        this.mHostSwitcher = new HostSwitcher(this.mKwaiMediaManifest, 3);
        if (this.mHostSwitcher.getKwaiManifestModel() != null) {
            this.mPrefetchUrl = KwaiMediaManifest_JsonUtils.toJson(this.mHostSwitcher.getKwaiManifestModel());
        }
    }

    public AdaptivePrefetchModel(KSVodAdaptationModel kSVodAdaptationModel, String str, int i) {
        setupWithPrefetchModel(kSVodAdaptationModel, str, i, 0);
    }

    public AdaptivePrefetchModel(KSVodAdaptationModel kSVodAdaptationModel, String str, int i, int i2) {
        setupWithPrefetchModel(kSVodAdaptationModel, str, i, i2);
    }

    private void setupWithPrefetchModel(KSVodAdaptationModel kSVodAdaptationModel, String str, int i, int i2) {
        this.mPreloadType = i2;
        this.mAdaptationModel = kSVodAdaptationModel;
        this.mPriority = i;
        this.mVideoId = str;
        this.mHostSwitcher = new HostSwitcher(this.mAdaptationModel);
        if (this.mHostSwitcher.getModel() != null) {
            this.mPrefetchUrl = VideoAdaptationModel_JsonUtils.toJson(this.mHostSwitcher.getModel());
        }
        this.mIsSecondPreload = false;
    }

    void setContext(Context context) {
        VodAdaptivePreloadPriorityTask.VodAdaptiveInit vodAdaptiveInit = new VodAdaptivePreloadPriorityTask.VodAdaptiveInit();
        this.mAdaptiveInit = vodAdaptiveInit;
        vodAdaptiveInit.rateConfig = KSVodPlayerConfig.get().getVodAdaptive();
        this.mAdaptiveInit.lowDevice = KSVodPlayerConfig.get().isLowDevice();
        this.mAdaptiveInit.netType = NetworkUtils.getAdaptiveNetType(context);
        this.mAdaptiveInit.devResHeigh = VodPlayerUtils.getScreenHeight(context);
        this.mAdaptiveInit.devResWidth = VodPlayerUtils.getScreenWidth(context);
        this.mAdaptiveInit.manifestType = this.mKwaiMediaManifest != null ? 1 : 0;
    }

    @Override // com.kwai.video.ksvodplayerkit.prefetcher.BasePrefetchModel
    String getDataSource() {
        return this.mPrefetchUrl;
    }

    @Override // com.kwai.video.ksvodplayerkit.prefetcher.BasePrefetchModel
    protected AbstractHodorPreloadTask switchNextAndGetTask() {
        this.mHostSwitcher.refreshUrlList(false);
        if (this.mHostSwitcher.size() <= 0 || this.mHostSwitcher.isLastUrl() || this.mRetryCount.get() >= KSVodPlayerConfig.get().getMaxRetryCount() || !this.mHostSwitcher.switchHost()) {
            return null;
        }
        if (this.mKwaiMediaManifest != null) {
            this.mPrefetchUrl = KwaiMediaManifest_JsonUtils.toJson(this.mHostSwitcher.getKwaiManifestModel());
        } else {
            this.mPrefetchUrl = VideoAdaptationModel_JsonUtils.toJson(this.mHostSwitcher.getModel());
        }
        this.mTask = new VodAdaptivePreloadPriorityTask(this.mPrefetchUrl, this.mAdaptiveInit);
        return this.mTask;
    }

    @Override // com.kwai.video.ksvodplayerkit.prefetcher.BasePrefetchModel
    protected AbstractHodorPreloadTask getTask() {
        if (this.mTask == null) {
            this.mTask = new VodAdaptivePreloadPriorityTask(this.mPrefetchUrl, this.mAdaptiveInit);
        }
        return this.mTask;
    }
}
