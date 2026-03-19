package com.netease.htprotect.p023o0O0O;

import android.app.Activity;
import android.os.Handler;
import android.view.Window;

/* renamed from: com.netease.htprotect.〇o〇0O〇0O.〇o0〇o0, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class o0o0 implements Runnable {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    final /* synthetic */ Handler f614O8oO888;

    o0o0(Handler handler) {
        this.f614O8oO888 = handler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Window window;
        Window.Callback callback;
        if (Ooo.f605O) {
            return;
        }
        try {
            Activity activityM1142O8oO888 = O8oO888.m1142O8oO888();
            if (activityM1142O8oO888 == null || (window = activityM1142O8oO888.getWindow()) == null || (callback = window.getCallback()) == null || (callback instanceof WindowCallbackC0686)) {
                return;
            }
            window.setCallback(new WindowCallbackC0686(callback, this.f614O8oO888));
        } catch (Exception unused) {
        }
    }
}
