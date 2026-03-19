package com.netease.htprotect.p001OO8;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.netease.htprotect.OO〇8.〇oO, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class oO {
    private static volatile boolean Oo0;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private static final boolean f48o0o0;

    /* renamed from: 〇oO, reason: contains not printable characters */
    private static volatile boolean f49oO;

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static final CountDownLatch f45O8oO888 = new CountDownLatch(2);

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static volatile String f47Ooo = null;

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static volatile String f46O8 = null;

    static {
        f48o0o0 = Build.VERSION.SDK_INT >= 28;
        f49oO = false;
        Oo0 = false;
    }

    private oO() {
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static void m500O8oO888() throws InterruptedException {
        if (f48o0o0 && f49oO && !Oo0) {
            try {
                CountDownLatch countDownLatch = f45O8oO888;
                if (countDownLatch != null) {
                    countDownLatch.await(1000L, TimeUnit.MILLISECONDS);
                }
            } catch (InterruptedException unused) {
            }
            Oo0 = true;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static synchronized void m501O8oO888(Context context) {
        if (f48o0o0) {
            if (f49oO) {
                return;
            }
            f49oO = true;
            new Thread(new Oo0(context)).start();
            new Thread(new O(context)).start();
        }
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    public static String m502O8() {
        String str = f47Ooo;
        return !((TextUtils.isEmpty(str) || str.length() != 36) ? false : str.matches("^[0-9A-Fa-f]{8}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{12}$")) ? "" : str;
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public static String m503Ooo() {
        String str = f46O8;
        String str2 = f46O8;
        boolean z = false;
        if (!TextUtils.isEmpty(str2) && str2.length() >= 16 && !str2.startsWith("00000000")) {
            z = true;
        }
        return !z ? "" : str;
    }
}
