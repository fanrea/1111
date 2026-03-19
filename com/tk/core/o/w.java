package com.tk.core.o;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.util.LruCache;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class w {
    private static final w ajv = new w();
    private final LruCache<String, Bitmap> ajw;

    public static w sR() {
        return ajv;
    }

    public w() {
        int iSS = (int) (sS() * 0.01f);
        if (iSS < 4194304) {
            iSS = 4194304;
        } else if (iSS > 12582912) {
            iSS = 12582912;
        }
        this.ajw = new LruCache<String, Bitmap>(iSS) { // from class: com.tk.core.o.w.1
            @Override // android.util.LruCache
            protected final /* synthetic */ int sizeOf(String str, Bitmap bitmap) {
                return b(bitmap);
            }

            private static int b(Bitmap bitmap) {
                return bitmap.getByteCount();
            }
        };
    }

    public final Bitmap cZ(String str) {
        if (str == null) {
            return null;
        }
        return this.ajw.get(str);
    }

    public final void b(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            return;
        }
        this.ajw.put(str, bitmap);
    }

    private static long sS() {
        ActivityManager activityManager = (ActivityManager) s.getContext().getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }
}
