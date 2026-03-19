package com.qq.e.comm.plugin;

import java.util.Locale;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class jz {
    public static String c(long j) {
        return String.format(Locale.ENGLISH, "%.2f M", Float.valueOf(j / 1048576.0f));
    }

    public static String b(long j) {
        return String.format(Locale.ENGLISH, "%.2f K", Float.valueOf(j / 1024.0f));
    }

    public static String a(long j) {
        if (j > 1048576) {
            return c(j);
        }
        return b(j);
    }
}
