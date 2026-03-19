package com.kwai.video.ksvodplayerkit.prefetcher;

import android.text.TextUtils;
import com.kwai.video.hodor.AbstractHodorPreloadTask;
import com.kwai.video.hodor.MediaPreloadPriorityTask;
import com.kwai.video.ksvodplayerkit.HttpDns.HostSwitcher;
import com.kwai.video.ksvodplayerkit.KSVodPlayerConfig;
import com.kwai.video.ksvodplayerkit.Utils.NetworkUtils;
import com.kwai.video.ksvodplayerkit.Utils.VodPlayerUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class NomalPrefetchModel extends BasePrefetchModel {
    public NomalPrefetchModel(List<String> list, String str, int i) {
        if (list == null || list.isEmpty() || TextUtils.isEmpty(list.get(0))) {
            throw new IllegalArgumentException("Wrong Input Arguments! Play url can't be null!");
        }
        createNomalPrefetchModel(list, str, i);
    }

    public NomalPrefetchModel(String str, String str2, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        createNomalPrefetchModel(arrayList, str2, i);
    }

    private void createNomalPrefetchModel(List<String> list, String str, int i) {
        this.mHostSwitcher = new HostSwitcher(list);
        this.mConfig = KSVodPlayerConfig.get().getPrefetcherConfig();
        this.mPrefetchUrl = list.get(0);
        this.mPriority = i;
        this.mVideoId = str;
        String host = NetworkUtils.getHost(this.mPrefetchUrl);
        if (this.mHostSwitcher.getCurrent() != null && !TextUtils.isEmpty(this.mHostSwitcher.getCurrent().mUrl)) {
            this.mPrefetchUrl = this.mHostSwitcher.getCurrent().mUrl;
            host = this.mHostSwitcher.getCurrentHost();
        }
        this.mPriority = i;
        this.mTask = MediaPreloadPriorityTask.newTaskWithHttpDns(this.mPrefetchUrl, host, VodPlayerUtils.getCacheKey(this.mPrefetchUrl));
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
        if (this.mHostSwitcher.getCurrent() != null && !TextUtils.isEmpty(this.mHostSwitcher.getCurrent().mUrl)) {
            this.mPrefetchUrl = this.mHostSwitcher.getCurrent().mUrl;
            this.mTask = MediaPreloadPriorityTask.newTaskWithHttpDns(this.mPrefetchUrl, this.mHostSwitcher.getCurrentHost(), VodPlayerUtils.getCacheKey(this.mPrefetchUrl));
        }
        return this.mTask;
    }

    @Override // com.kwai.video.ksvodplayerkit.prefetcher.BasePrefetchModel
    protected AbstractHodorPreloadTask getTask() {
        if (this.mTask == null) {
            this.mTask = MediaPreloadPriorityTask.newTaskWithHttpDns(this.mPrefetchUrl, this.mHostSwitcher.getCurrentHost() != null ? this.mHostSwitcher.getCurrentHost() : NetworkUtils.getHost(this.mPrefetchUrl), VodPlayerUtils.getCacheKey(this.mPrefetchUrl));
        }
        return this.mTask;
    }
}
