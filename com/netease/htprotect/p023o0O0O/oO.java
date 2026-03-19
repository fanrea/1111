package com.netease.htprotect.p023o0O0O;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Window;
import com.netease.htprotect.p00700oOOo.O8;
import com.netease.htprotect.p00700oOOo.o0o0;
import com.netease.htprotect.p019o0o0.O8oO888;

/* renamed from: com.netease.htprotect.〇o〇0O〇0O.〇oO, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class oO implements Application.ActivityLifecycleCallbacks {

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private static final int f615o0o0 = Build.VERSION.SDK_INT;

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private final Handler f616O8oO888;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private final o0o0 f618Ooo = new Oo0(this);

    /* renamed from: 〇O8, reason: contains not printable characters */
    private volatile boolean f617O8 = false;

    public oO(Handler handler) {
        this.f616O8oO888 = handler;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        if (!O8oO888.m1089O8oO888() || this.f617O8) {
            return;
        }
        try {
            if (activity.getClass().getName().endsWith(".wxapi.WXEntryActivity")) {
                String strM495O8oO888 = com.netease.htprotect.p001OO8.o0o0.m495O8oO888(activity);
                if (TextUtils.isEmpty(strM495O8oO888) || "com.tencent.mm".equals(strM495O8oO888)) {
                    return;
                }
                this.f617O8 = true;
                Handler handler = this.f616O8oO888;
                if (handler != null) {
                    handler.obtainMessage(10003, strM495O8oO888).sendToTarget();
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        Window window = activity.getWindow();
        if (window == null) {
            return;
        }
        Window.Callback callback = window.getCallback();
        if (callback != null && !(callback instanceof WindowCallbackC0686)) {
            window.setCallback(new WindowCallbackC0686(callback, this.f616O8oO888));
        }
        int i = f615o0o0;
        if (i < 28 || (i <= 34 && O8oO888.m1089O8oO888())) {
            try {
                window.getDecorView().getViewTreeObserver().addOnPreDrawListener(new O8(window, activity.getClass().getSimpleName(), this.f618Ooo));
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
