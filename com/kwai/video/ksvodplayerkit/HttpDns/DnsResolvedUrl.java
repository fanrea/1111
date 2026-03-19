package com.kwai.video.ksvodplayerkit.HttpDns;

import java.util.Map;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class DnsResolvedUrl implements Comparable<DnsResolvedUrl> {
    public final String mHost;
    public String mOriginalUrl;
    public final ResolvedIP mResolvedIP;
    public final String mUrl;
    public final Map<String, String> mUrlHeaders;

    public DnsResolvedUrl(String str, String str2, ResolvedIP resolvedIP) {
        this(str, str2, resolvedIP, (Map<String, String>) null);
    }

    public DnsResolvedUrl(String str, String str2, String str3, ResolvedIP resolvedIP) {
        this.mHost = str;
        this.mUrl = str3;
        this.mResolvedIP = resolvedIP;
        this.mOriginalUrl = str2;
        this.mUrlHeaders = null;
    }

    public DnsResolvedUrl(String str, String str2, ResolvedIP resolvedIP, Map<String, String> map) {
        this.mHost = str;
        this.mUrl = str2;
        this.mResolvedIP = resolvedIP;
        this.mUrlHeaders = map;
    }

    public DnsResolvedUrl(String str, String str2, ResolvedIP resolvedIP, boolean z) {
        this(str, str2, resolvedIP, (Map<String, String>) null);
    }

    public DnsResolvedUrl(String str, String str2, ResolvedIP resolvedIP, boolean z, String str3, String str4, Set<Integer> set) {
        this(str, str2, resolvedIP);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DnsResolvedUrl)) {
            return false;
        }
        String str = this.mUrl;
        String str2 = ((DnsResolvedUrl) obj).mUrl;
        return str != null ? str.equals(str2) : str2 == null;
    }

    @Override // java.lang.Comparable
    public int compareTo(DnsResolvedUrl dnsResolvedUrl) {
        ResolvedIP resolvedIP = this.mResolvedIP;
        if (resolvedIP == null || dnsResolvedUrl.mResolvedIP == null) {
            return 0;
        }
        return (int) (resolvedIP.mRtt - dnsResolvedUrl.mResolvedIP.mRtt);
    }
}
