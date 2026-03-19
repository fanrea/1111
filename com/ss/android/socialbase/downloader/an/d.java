package com.ss.android.socialbase.downloader.an;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.mq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d {
    private static int d = 4;
    private static AbstractC0767d hc;

    /* renamed from: com.ss.android.socialbase.downloader.an.d$d, reason: collision with other inner class name */
    public static abstract class AbstractC0767d {
    }

    public static void d(int i) {
        d = i;
    }

    public static boolean d() {
        return d <= 3;
    }

    public static void d(String str, String str2) {
        if (str2 == null || hc == null) {
            return;
        }
        hc(str);
    }

    public static void d(String str) {
        hc("DownloaderLogger", str);
    }

    public static String hc(String str) {
        return !TextUtils.isEmpty(str) ? "Downloader-" + str : "DownloaderLogger";
    }

    public static void hc(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (d <= 3) {
            hc(str);
        }
        if (hc != null) {
            hc(str);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (d <= 3) {
            hc(str);
        }
        if (hc != null) {
            hc(str);
        }
    }

    public static void b(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (d <= 4) {
            mq.d(hc(str), str2);
        }
        if (hc != null) {
            hc(str);
        }
    }

    public static void b(String str) {
        c("DownloaderLogger", str);
    }

    public static void c(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (d <= 5) {
            mq.hc(hc(str), str2);
        }
        if (hc != null) {
            hc(str);
        }
    }

    public static void u(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (d <= 6) {
            mq.c(hc(str), str2);
        }
        if (hc != null) {
            hc(str);
        }
    }

    public static void hc(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (d <= 6) {
            mq.b(hc(str), str2, th);
        }
        if (hc != null) {
            hc(str);
        }
    }
}
