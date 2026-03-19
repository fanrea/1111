package com.ss.android.downloadlib.addownload;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class tc {
    public static int d(int i, int i2) {
        return (i2 <= 0 || i2 >= 100 || !d(i)) ? i2 : (int) (Math.sqrt(i2) * 10.0d);
    }

    public static long d(int i, long j, long j2) {
        if (!d(i)) {
            return j;
        }
        if (j <= 0) {
            return 0L;
        }
        return j2 <= 0 ? j : (j2 * d(i, (int) ((j * 100) / j2))) / 100;
    }

    public static com.ss.android.d.d.u.u d(com.ss.android.d.d.u.u uVar) {
        if (uVar != null && d((int) uVar.d)) {
            uVar.c = d((int) uVar.d, uVar.c, uVar.b);
        }
        return uVar;
    }

    private static boolean d(int i) {
        return com.ss.android.socialbase.downloader.uo.d.d(i).d("pause_optimise_pretend_download_percent_switch", 0) == 1 && com.ss.android.socialbase.downloader.uo.d.d(i).d("pause_optimise_switch", 0) == 1;
    }
}
