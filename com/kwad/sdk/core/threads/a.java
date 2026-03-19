package com.kwad.sdk.core.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.kwad.sdk.utils.cb;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    private static Map<String, WeakReference<C0591a>> bHB = new ConcurrentHashMap();

    public static synchronized cb a(cb.a aVar) {
        return fT("commonHT").b(aVar);
    }

    public static synchronized Handler abY() {
        return fT("reportHT").getHandler();
    }

    private static C0591a fT(String str) {
        WeakReference<C0591a> weakReference = bHB.get(str);
        if (weakReference == null || weakReference.get() == null) {
            C0591a c0591a = new C0591a(str);
            bHB.put(str, new WeakReference<>(c0591a));
            return c0591a;
        }
        return weakReference.get();
    }

    /* renamed from: com.kwad.sdk.core.threads.a$a, reason: collision with other inner class name */
    public static class C0591a {
        private Handler mHandler;
        private HandlerThread mThread;

        public C0591a(String str) {
            HandlerThread handlerThread = new HandlerThread(TextUtils.isEmpty(str) ? "ksad-HT" : "ksad-" + str);
            this.mThread = handlerThread;
            handlerThread.start();
            this.mHandler = new Handler(this.mThread.getLooper());
        }

        public final Handler getHandler() {
            return this.mHandler;
        }

        public final cb b(cb.a aVar) {
            return new cb(aVar, this.mThread.getLooper());
        }
    }
}
