package com.netease.htprotect.p001OO8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.netease.htprotect.OO〇8.〇O8, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O8 {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static final int f34O8oO888 = 5;

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static final int f35O8 = 60;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static final int f36Ooo = 5;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private final ExecutorService f37o0o0 = new ThreadPoolExecutor(5, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory());

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void m488O8oO888(Runnable runnable) {
        try {
            this.f37o0o0.execute(runnable);
        } catch (Exception unused) {
        }
    }
}
