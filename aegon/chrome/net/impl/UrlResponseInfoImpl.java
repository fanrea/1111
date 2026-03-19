package aegon.chrome.net.impl;

import aegon.chrome.net.UrlResponseInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class UrlResponseInfoImpl extends UrlResponseInfo {
    private final HeaderBlockImpl mHeaders;
    private final int mHttpStatusCode;
    private final String mHttpStatusText;
    private final String mNegotiatedProtocol;
    private final String mProxyServer;
    private final AtomicLong mReceivedByteCount;
    private final List<String> mResponseInfoUrlChain;
    private final boolean mWasCached;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static final class HeaderBlockImpl extends UrlResponseInfo.HeaderBlock {
        private final List<Map.Entry<String, String>> mAllHeadersList;
        private Map<String, List<String>> mHeadersMap;

        HeaderBlockImpl(List<Map.Entry<String, String>> list) {
            this.mAllHeadersList = list;
        }

        @Override // aegon.chrome.net.UrlResponseInfo.HeaderBlock
        public final List<Map.Entry<String, String>> getAsList() {
            return this.mAllHeadersList;
        }

        @Override // aegon.chrome.net.UrlResponseInfo.HeaderBlock
        public final Map<String, List<String>> getAsMap() {
            Map<String, List<String>> map = this.mHeadersMap;
            if (map != null) {
                return map;
            }
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (Map.Entry<String, String> entry : this.mAllHeadersList) {
                ArrayList arrayList = new ArrayList();
                if (treeMap.containsKey(entry.getKey())) {
                    arrayList.addAll((Collection) treeMap.get(entry.getKey()));
                }
                arrayList.add(entry.getValue());
                treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
            }
            Map<String, List<String>> mapUnmodifiableMap = Collections.unmodifiableMap(treeMap);
            this.mHeadersMap = mapUnmodifiableMap;
            return mapUnmodifiableMap;
        }
    }

    public UrlResponseInfoImpl(List<String> list, int i, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3, long j) {
        this.mResponseInfoUrlChain = Collections.unmodifiableList(list);
        this.mHttpStatusCode = i;
        this.mHttpStatusText = str;
        this.mHeaders = new HeaderBlockImpl(Collections.unmodifiableList(list2));
        this.mWasCached = z;
        this.mNegotiatedProtocol = str2;
        this.mProxyServer = str3;
        this.mReceivedByteCount = new AtomicLong(j);
    }

    @Deprecated
    public UrlResponseInfoImpl(List<String> list, int i, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3) {
        this(list, i, str, list2, z, str2, str3, 0L);
    }

    @Override // aegon.chrome.net.UrlResponseInfo
    public final String getUrl() {
        return this.mResponseInfoUrlChain.get(r0.size() - 1);
    }

    @Override // aegon.chrome.net.UrlResponseInfo
    public final List<String> getUrlChain() {
        return this.mResponseInfoUrlChain;
    }

    @Override // aegon.chrome.net.UrlResponseInfo
    public final int getHttpStatusCode() {
        return this.mHttpStatusCode;
    }

    @Override // aegon.chrome.net.UrlResponseInfo
    public final String getHttpStatusText() {
        return this.mHttpStatusText;
    }

    @Override // aegon.chrome.net.UrlResponseInfo
    public final List<Map.Entry<String, String>> getAllHeadersAsList() {
        return this.mHeaders.getAsList();
    }

    @Override // aegon.chrome.net.UrlResponseInfo
    public final Map<String, List<String>> getAllHeaders() {
        return this.mHeaders.getAsMap();
    }

    @Override // aegon.chrome.net.UrlResponseInfo
    public final boolean wasCached() {
        return this.mWasCached;
    }

    @Override // aegon.chrome.net.UrlResponseInfo
    public final String getNegotiatedProtocol() {
        return this.mNegotiatedProtocol;
    }

    @Override // aegon.chrome.net.UrlResponseInfo
    public final String getProxyServer() {
        return this.mProxyServer;
    }

    @Override // aegon.chrome.net.UrlResponseInfo
    public final long getReceivedByteCount() {
        return this.mReceivedByteCount.get();
    }

    public final String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedByteCount = %d", Integer.toHexString(System.identityHashCode(this)), getUrl(), getUrlChain().toString(), Integer.valueOf(getHttpStatusCode()), getHttpStatusText(), getAllHeadersAsList().toString(), Boolean.valueOf(wasCached()), getNegotiatedProtocol(), getProxyServer(), Long.valueOf(getReceivedByteCount()));
    }

    public final void setReceivedByteCount(long j) {
        this.mReceivedByteCount.set(j);
    }
}
