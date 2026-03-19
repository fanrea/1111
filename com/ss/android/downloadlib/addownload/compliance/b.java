package com.ss.android.downloadlib.addownload.compliance;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b extends com.ss.android.socialbase.downloader.e.gb<Long, com.ss.android.downloadlib.addownload.hc.hc> {

    private static class d {
        private static b d = new b();
    }

    public static b d() {
        return d.d;
    }

    private b() {
        super(16, 16);
    }

    public void d(com.ss.android.downloadlib.addownload.hc.hc hcVar) {
        if (hcVar == null) {
            return;
        }
        put(Long.valueOf(hcVar.d()), hcVar);
    }

    public com.ss.android.downloadlib.addownload.hc.hc d(long j, long j2) {
        return (com.ss.android.downloadlib.addownload.hc.hc) get(get(Long.valueOf(j)) != null ? Long.valueOf(j) : Long.valueOf(j2));
    }

    public com.ss.android.downloadlib.addownload.hc.hc d(long j) {
        return (com.ss.android.downloadlib.addownload.hc.hc) get(Long.valueOf(j));
    }
}
