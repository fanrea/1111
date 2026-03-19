package com.baidu.mobstat.forbes;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class h {
    private static volatile int c = 0;
    private final Handler b = new Handler(Looper.getMainLooper());
    private final b a = new b();

    static class a {
        private final Paint b = new Paint(2);
        private Bitmap a = null;
    }

    static class b implements Callable<List<Object>> {
        private final int d = 160;
        private final DisplayMetrics b = new DisplayMetrics();
        private final List<Object> a = new ArrayList();
        private final a c = new a();

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<Object> call() {
            return null;
        }
    }
}
