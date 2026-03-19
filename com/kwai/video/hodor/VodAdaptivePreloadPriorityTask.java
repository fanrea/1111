package com.kwai.video.hodor;

import com.kuaishou.socket.nano.SocketMessages;
import com.kwai.video.cache.AwesomeCacheCallback;
import com.kwai.video.hodor.util.HeaderUtil;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class VodAdaptivePreloadPriorityTask extends AbstractHodorPreloadTask {
    private AwesomeCacheCallback mAwesomeCacheCallback;
    private String mCacheKey;
    private VodAdaptiveDataSpec mDataSpec;
    private VodAdaptiveInit mVodAdaptiveInitValue;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static class VodAdaptiveDataSpec {
        String headers;
        String manifestJson;
        long preloadBytes = 1048576;
        long durMs = -1;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static class VodAdaptiveInit {
        public String rateConfig = "";
        public int devResWidth = 720;
        public int devResHeigh = SocketMessages.PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_TYPE_NOTICE;
        public int netType = 1;
        public int lowDevice = 0;
        public int signalStrength = 1;
        public int switchCode = 0;
        public int manifestType = 0;
    }

    private native void _cancel();

    private native void _submit(Object obj, Object obj2, Object obj3);

    public native void _pause();

    public native void _resume();

    public VodAdaptivePreloadPriorityTask(String str, VodAdaptiveInit vodAdaptiveInit) {
        VodAdaptiveDataSpec vodAdaptiveDataSpec = new VodAdaptiveDataSpec();
        this.mDataSpec = vodAdaptiveDataSpec;
        vodAdaptiveDataSpec.manifestJson = str;
        this.mDataSpec.headers = "";
        this.mVodAdaptiveInitValue = vodAdaptiveInit;
        this.mAwesomeCacheCallback = null;
    }

    public VodAdaptivePreloadPriorityTask(String str, VodAdaptiveInit vodAdaptiveInit, Map<String, String> map) {
        VodAdaptiveDataSpec vodAdaptiveDataSpec = new VodAdaptiveDataSpec();
        this.mDataSpec = vodAdaptiveDataSpec;
        vodAdaptiveDataSpec.manifestJson = str;
        this.mDataSpec.headers = HeaderUtil.parseHeaderMapToFlatString(map);
        this.mVodAdaptiveInitValue = vodAdaptiveInit;
        this.mAwesomeCacheCallback = null;
    }

    public void setPreloadDurationMs(long j) {
        this.mDataSpec.durMs = j;
    }

    public void setPreloadBytes(long j) {
        this.mDataSpec.preloadBytes = j;
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void setAwesomeCacheCallback(AwesomeCacheCallback awesomeCacheCallback) {
        this.mAwesomeCacheCallback = awesomeCacheCallback;
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void submit() {
        _submit(this.mDataSpec, this.mVodAdaptiveInitValue, this.mAwesomeCacheCallback);
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

    public String getCacheKey() {
        return this.mCacheKey;
    }
}
