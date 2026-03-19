package aegon.chrome.net.impl;

import aegon.chrome.net.impl.SafeNativeFunctionCaller;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final /* synthetic */ class CronetUrlRequest$$Lambda$1 implements SafeNativeFunctionCaller.Supplier {
    private final CronetUrlRequest arg$1;

    private CronetUrlRequest$$Lambda$1(CronetUrlRequest cronetUrlRequest) {
        this.arg$1 = cronetUrlRequest;
    }

    public static SafeNativeFunctionCaller.Supplier lambdaFactory$(CronetUrlRequest cronetUrlRequest) {
        return new CronetUrlRequest$$Lambda$1(cronetUrlRequest);
    }

    @Override // aegon.chrome.net.impl.SafeNativeFunctionCaller.Supplier
    public final Object get() {
        CronetUrlRequest cronetUrlRequest = this.arg$1;
        return Long.valueOf(cronetUrlRequest.nativeCreateRequestAdapter(cronetUrlRequest.mRequestContext.getUrlRequestContextAdapter(), cronetUrlRequest.mInitialUrl, cronetUrlRequest.mPriority, cronetUrlRequest.mDisableCache, cronetUrlRequest.mDisableConnectionMigration, cronetUrlRequest.mRequestContext.hasRequestFinishedListener() || cronetUrlRequest.mRequestFinishedListener != null, cronetUrlRequest.mTrafficStatsTagSet, cronetUrlRequest.mTrafficStatsTag, cronetUrlRequest.mTrafficStatsUidSet, cronetUrlRequest.mTrafficStatsUid));
    }
}
