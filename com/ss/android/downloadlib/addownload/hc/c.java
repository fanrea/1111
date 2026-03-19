package com.ss.android.downloadlib.addownload.hc;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bytedance.sdk.djx.model.DramaFeed;
import com.ss.android.downloadlib.addownload.mq;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c {
    private static final String[] b = {"com", "android", "ss"};
    private static final int[] c = {3101, 3102, 3103, 3201, 3202, DramaFeed.CELL_DRAMA_DRAW_AD};
    private static volatile c d;
    private final LinkedList<d> hc = new LinkedList<>();

    private c() {
    }

    public static c d() {
        if (d == null) {
            synchronized (c.class) {
                if (d == null) {
                    d = new c();
                }
            }
        }
        return d;
    }

    public void d(String str) {
        d dVarB;
        hc();
        if (TextUtils.isEmpty(str) || (dVarB = b(str)) == null) {
            return;
        }
        synchronized (this.hc) {
            this.hc.add(dVarB);
        }
    }

    public void hc(String str) {
        hc();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.hc) {
            Iterator<d> it = this.hc.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().d)) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public d d(com.ss.android.hc.d.hc.hc hcVar) {
        if (hcVar == null) {
            return null;
        }
        hc();
        synchronized (this.hc) {
            Iterator<d> it = this.hc.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.u > hcVar.j()) {
                    return next;
                }
            }
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0095, code lost:
    
        r7[1] = r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.util.Pair<com.ss.android.downloadlib.addownload.hc.c.d, java.lang.Integer> hc(com.ss.android.hc.d.hc.hc r18) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.hc.c.hc(com.ss.android.hc.d.hc.hc):android.util.Pair");
    }

    private void hc() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.hc) {
            Iterator<d> it = this.hc.iterator();
            while (it.hasNext() && jCurrentTimeMillis - it.next().u > 1800000) {
                it.remove();
            }
        }
    }

    private d b(String str) {
        try {
            PackageManager packageManager = mq.getContext().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return new d(str, packageInfo.versionCode, packageInfo.versionName, (String) packageManager.getApplicationLabel(packageInfo.applicationInfo), System.currentTimeMillis());
            }
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
            return null;
        }
    }

    private static boolean d(String str, String str2) {
        String[] strArrSplit;
        String[] strArrSplit2;
        boolean z;
        try {
            strArrSplit = str.split("\\.");
            strArrSplit2 = str2.split("\\.");
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
        if (strArrSplit.length != 0 && strArrSplit2.length != 0) {
            int i = 0;
            int i2 = 0;
            for (String str3 : strArrSplit) {
                String[] strArr = b;
                int length = strArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        z = false;
                        break;
                    }
                    String str4 = strArr[i3];
                    if (str4.equals(str3)) {
                        if (i < strArrSplit2.length && str4.equals(strArrSplit2[i])) {
                            i++;
                        }
                        z = true;
                    } else {
                        i3++;
                    }
                }
                if (!z) {
                    int i4 = i2;
                    int i5 = i;
                    while (i < strArrSplit2.length) {
                        if (str3.equals(strArrSplit2[i])) {
                            if (i == i5) {
                                i5++;
                            }
                            i4++;
                            if (i4 >= 2) {
                                return true;
                            }
                        }
                        i++;
                    }
                    i = i5;
                    i2 = i4;
                }
            }
            return false;
        }
        return false;
    }

    public static class d {
        public final String b;
        public final String c;
        public final String d;
        public final int hc;
        public final long u;

        private d(String str, int i, String str2, String str3, long j) {
            this.d = str;
            this.hc = i;
            this.b = str2 != null ? str2.toLowerCase() : null;
            this.c = str3 != null ? str3.toLowerCase() : null;
            this.u = j;
        }
    }
}
