package aegon.chrome.net.impl;

import aegon.chrome.net.CronetException;
import aegon.chrome.net.RequestFinishedInfo;
import aegon.chrome.net.UrlResponseInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.Collections;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class RequestFinishedInfoImpl extends RequestFinishedInfo {
    private final Collection<Object> mAnnotations;
    private final CronetException mException;
    private final int mFinishedReason;
    private final RequestFinishedInfo.Metrics mMetrics;
    private final UrlResponseInfo mResponseInfo;
    private final String mUrl;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FinishedReason {
    }

    public RequestFinishedInfoImpl(String str, Collection<Object> collection, RequestFinishedInfo.Metrics metrics, int i, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
        this.mUrl = str;
        this.mAnnotations = collection;
        this.mMetrics = metrics;
        this.mFinishedReason = i;
        this.mResponseInfo = urlResponseInfo;
        this.mException = cronetException;
    }

    @Override // aegon.chrome.net.RequestFinishedInfo
    public String getUrl() {
        return this.mUrl;
    }

    @Override // aegon.chrome.net.RequestFinishedInfo
    public Collection<Object> getAnnotations() {
        Collection<Object> collection = this.mAnnotations;
        return collection == null ? Collections.emptyList() : collection;
    }

    @Override // aegon.chrome.net.RequestFinishedInfo
    public RequestFinishedInfo.Metrics getMetrics() {
        return this.mMetrics;
    }

    @Override // aegon.chrome.net.RequestFinishedInfo
    public int getFinishedReason() {
        return this.mFinishedReason;
    }

    @Override // aegon.chrome.net.RequestFinishedInfo
    public UrlResponseInfo getResponseInfo() {
        return this.mResponseInfo;
    }

    @Override // aegon.chrome.net.RequestFinishedInfo
    public CronetException getException() {
        return this.mException;
    }
}
