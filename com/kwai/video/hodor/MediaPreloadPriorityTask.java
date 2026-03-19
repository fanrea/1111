package com.kwai.video.hodor;

import android.text.TextUtils;
import com.kwai.video.cache.AwesomeCacheCallback;
import com.kwai.video.hodor.util.HeaderUtil;
import com.kwai.video.hodor.util.Timber;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class MediaPreloadPriorityTask extends AbstractHodorPreloadTask {
    private AwesomeCacheCallback mAwesomeCacheCallback;
    public final String mCacheKey;
    public final String mHttpHeaders;
    public final String mUrl;
    private long mPreloadBytes = 1048576;
    private String mMd5HashCode = "";
    private int mEvictStrategy = 1;

    @Override // com.kwai.video.hodor.IHodorTask
    public native void cancel();

    @Override // com.kwai.video.hodor.IHodorTask
    public native void pause();

    @Override // com.kwai.video.hodor.IHodorTask
    public native void resume();

    @Override // com.kwai.video.hodor.IHodorTask
    public native void submit();

    public static MediaPreloadPriorityTask newTaskWithHttpDns(String str, String str2, String str3) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            map.put("Host", str2);
        }
        return new MediaPreloadPriorityTask(str, map, str3);
    }

    public MediaPreloadPriorityTask(String str, Map<String, String> map, String str2) {
        this.mUrl = str;
        this.mHttpHeaders = HeaderUtil.parseHeaderMapToFlatString(map);
        this.mCacheKey = str2;
    }

    public void setEvictStrategy(int i) {
        this.mEvictStrategy = i;
    }

    public void setmMd5HashCode(String str) {
        if (str == null) {
            Timber.e("setmMd5HashCode,input md5 is null invalid", new Object[0]);
        } else {
            this.mMd5HashCode = str;
        }
    }

    public void setPreloadBytes(long j) {
        this.mPreloadBytes = j;
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void setAwesomeCacheCallback(AwesomeCacheCallback awesomeCacheCallback) {
        this.mAwesomeCacheCallback = awesomeCacheCallback;
    }
}
