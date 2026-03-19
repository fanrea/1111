package com.kwai.video.hodor;

import com.kwai.video.cache.AwesomeCacheCallback;
import com.kwai.video.hodor.util.HeaderUtil;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class HlsPreloadPriorityTask extends AbstractHodorPreloadTask {
    private AwesomeCacheCallback mAwesomeCacheCallback;
    private String mCacheKey;
    private String mHeaders;
    private String mManifestJson;
    private int mPreferBandwidth;
    private long mPreloadBytes;

    private native void _cancel();

    private native void _submit(String str, int i, long j, String str2, AwesomeCacheCallback awesomeCacheCallback);

    public native void _pause();

    public native void _resume();

    public HlsPreloadPriorityTask(String str, int i) {
        this.mPreloadBytes = 1048576L;
        this.mManifestJson = str;
        this.mPreferBandwidth = i;
        this.mHeaders = "";
        this.mAwesomeCacheCallback = null;
    }

    public HlsPreloadPriorityTask(String str, int i, Map<String, String> map) {
        this.mPreloadBytes = 1048576L;
        this.mManifestJson = str;
        this.mPreferBandwidth = i;
        this.mHeaders = HeaderUtil.parseHeaderMapToFlatString(map);
        this.mAwesomeCacheCallback = null;
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void setAwesomeCacheCallback(AwesomeCacheCallback awesomeCacheCallback) {
        this.mAwesomeCacheCallback = awesomeCacheCallback;
    }

    public void setPreloadBytes(long j) {
        this.mPreloadBytes = j;
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void submit() {
        _submit(this.mManifestJson, this.mPreferBandwidth, this.mPreloadBytes, this.mHeaders, this.mAwesomeCacheCallback);
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void cancel() {
        _cancel();
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void pause() {
        _pause();
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void resume() {
        _resume();
    }
}
