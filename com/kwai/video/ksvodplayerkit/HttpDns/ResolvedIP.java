package com.kwai.video.ksvodplayerkit.HttpDns;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ResolvedIP implements Comparable<ResolvedIP> {
    public final long mExpiredDate;
    public final String mHost;
    public final String mIP;
    public String mResolver;
    public long mRtt;

    public ResolvedIP(String str, String str2, ResolverType resolverType, long j) {
        this.mHost = str;
        this.mIP = str2;
        this.mResolver = resolverType.mValue;
        this.mExpiredDate = System.currentTimeMillis() + j;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ResolvedIP) && this.mIP.equals(((ResolvedIP) obj).mIP);
    }

    public int hashCode() {
        return this.mIP.hashCode();
    }

    @Override // java.lang.Comparable
    public int compareTo(ResolvedIP resolvedIP) {
        return (int) (this.mRtt - resolvedIP.mRtt);
    }

    public String toString() {
        return this.mIP;
    }
}
