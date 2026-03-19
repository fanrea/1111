package com.bytedance.msdk.core.mq;

import android.os.Handler;
import android.os.Looper;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class an {
    private static final String d = "an";
    private Looper hc = Looper.getMainLooper();
    private final Set<String> b = new HashSet(1);

    public abstract void d();

    public abstract void d(String str);

    public synchronized boolean hc(String str) {
        com.bytedance.msdk.d.u.b.hc(d, "permission not found:".concat(String.valueOf(str)));
        return true;
    }

    protected final synchronized boolean d(String str, int i) {
        if (i == 0) {
            return d(str, c.GRANTED);
        }
        return d(str, c.DENIED);
    }

    /* renamed from: com.bytedance.msdk.core.mq.an$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] d;

        static {
            int[] iArr = new int[c.values().length];
            d = iArr;
            try {
                iArr[c.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                d[c.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                d[c.NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    protected final synchronized boolean d(final String str, c cVar) {
        this.b.remove(str);
        int i = AnonymousClass5.d[cVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                new Handler(this.hc).post(new Runnable() { // from class: com.bytedance.msdk.core.mq.an.2
                    @Override // java.lang.Runnable
                    public void run() {
                        an.this.d(str);
                    }
                });
                return true;
            }
            if (i == 3) {
                if (hc(str)) {
                    if (this.b.isEmpty()) {
                        new Handler(this.hc).post(new Runnable() { // from class: com.bytedance.msdk.core.mq.an.3
                            @Override // java.lang.Runnable
                            public void run() {
                                an.this.d();
                            }
                        });
                        return true;
                    }
                } else {
                    new Handler(this.hc).post(new Runnable() { // from class: com.bytedance.msdk.core.mq.an.4
                        @Override // java.lang.Runnable
                        public void run() {
                            an.this.d(str);
                        }
                    });
                    return true;
                }
            }
        } else if (this.b.isEmpty()) {
            new Handler(this.hc).post(new Runnable() { // from class: com.bytedance.msdk.core.mq.an.1
                @Override // java.lang.Runnable
                public void run() {
                    an.this.d();
                }
            });
            return true;
        }
        return false;
    }

    protected final synchronized void d(String[] strArr) {
        Collections.addAll(this.b, strArr);
    }
}
