package com.sigmob.sdk.mraid;

import android.os.Handler;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.u;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class t {
    static final int a = 50;
    static final long b = 3000000;
    private static final long d = 3000000;
    private static final Map<String, a> e = Collections.synchronizedMap(new HashMap());
    static final b c = new b();
    private static Handler f = new Handler();

    public static class a {
        private final com.sigmob.sdk.base.views.g a;
        private final WeakReference<u> b;
        private final com.sigmob.sdk.base.common.s c;
        private final d d;

        a(com.sigmob.sdk.base.views.g baseWebView, u baseInterstitial, com.sigmob.sdk.base.common.s sessionManager, d controller) {
            this.a = baseWebView;
            this.b = new WeakReference<>(baseInterstitial);
            this.c = sessionManager;
            this.d = controller;
        }

        public com.sigmob.sdk.base.views.g a() {
            return this.a;
        }

        public WeakReference<u> b() {
            return this.b;
        }

        public com.sigmob.sdk.base.common.s c() {
            return this.c;
        }

        public d d() {
            return this.d;
        }
    }

    private static class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            t.a();
        }
    }

    private t() {
    }

    public static a a(final String broadcastIdentifier) {
        Preconditions.checkNotNull(broadcastIdentifier);
        return e.remove(broadcastIdentifier);
    }

    static synchronized void a() {
        Iterator<Map.Entry<String, a>> it = e.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, a> next = it.next();
            if (next.getValue().b().get() == null) {
                next.getValue().c().a();
                it.remove();
            }
        }
        if (e.isEmpty()) {
            return;
        }
        Handler handler = f;
        b bVar = c;
        handler.removeCallbacks(bVar);
        f.postDelayed(bVar, 3000000L);
    }

    @Deprecated
    static void a(final Handler handler) {
        f = handler;
    }

    public static void a(String broadcastIdentifier, e baseInterstitial, com.sigmob.sdk.base.views.g baseWebView, com.sigmob.sdk.base.common.s sessionManager, d controller) {
        Preconditions.checkNotNull(broadcastIdentifier);
        Preconditions.checkNotNull(baseInterstitial);
        Preconditions.checkNotNull(baseWebView);
        a();
        Map<String, a> map = e;
        if (map.size() >= 50) {
            SigmobLog.w("Unable to cache web view. Please destroy some via #destroy() and try again.");
        } else {
            map.put(broadcastIdentifier, new a(baseWebView, baseInterstitial, sessionManager, controller));
        }
    }

    @Deprecated
    public static void b() {
        e.clear();
        f.removeCallbacks(c);
    }

    @Deprecated
    static Map<String, a> c() {
        return e;
    }
}
