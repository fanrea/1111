package com.ss.android.downloadlib.h;

import android.os.AsyncTask;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class hc {
    static final d d = new C0758hc();

    private static class d {
        private d() {
        }

        public <T> void d(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(com.bytedance.sdk.component.tc.c.hc.d, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.h.hc$hc, reason: collision with other inner class name */
    private static class C0758hc extends d {
        private C0758hc() {
            super();
        }

        @Override // com.ss.android.downloadlib.h.hc.d
        public <T> void d(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    public static <T> void d(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        d.d(asyncTask, tArr);
    }
}
