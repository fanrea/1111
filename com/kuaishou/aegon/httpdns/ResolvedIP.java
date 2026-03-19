package com.kuaishou.aegon.httpdns;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ResolvedIP implements Comparable<ResolvedIP> {
    public final long mExpiredDate;
    public final String mHost;
    public final String mIP;
    public String mResolver;
    public long mRtt;
    public final long mTtl;

    public ResolvedIP(String str, String str2, String str3, long j, long j2) {
        this.mHost = str;
        this.mIP = str2;
        this.mResolver = str3;
        this.mRtt = j2;
        this.mExpiredDate = System.currentTimeMillis() + j;
        this.mTtl = j;
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
        StringBuilder sb = new StringBuilder("{\n");
        sb.append("\thost = ").append(this.mHost).append("\n\tip = ").append(this.mIP).append("\n\ttype = ").append(this.mResolver).append("\n\trtt = ").append(this.mRtt).append("\n\tttl = ").append(this.mTtl).append("\n\texpired = ").append(this.mExpiredDate).append("\n}\n");
        return sb.toString();
    }
}
